package com.fundoo.notes.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fundoo.notes.dto.NoteRequestDTO;
import com.fundoo.notes.dto.NoteResponseDTO;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.exception.InvalidNoteStateTransitionException;
import com.fundoo.notes.exception.NoteNotFoundException;
import com.fundoo.notes.exception.NoteTitleAlreadyExistsException;
import com.fundoo.notes.exception.UserNotFoundException;
import com.fundoo.notes.dto.NoteActivityResponseDTO;
import com.fundoo.notes.rabbit.NoteActivityProducer;
import com.fundoo.notes.repository.NoteActivityLogRepository;
import com.fundoo.notes.repository.NoteRepository;
import com.fundoo.notes.repository.UserRepository;
import com.fundoo.notes.specification.NoteSpecifications;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final NoteActivityProducer noteActivityProducer;
    private final NoteActivityLogRepository noteActivityLogRepository;

    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository,
                            NoteActivityProducer noteActivityProducer,
                            NoteActivityLogRepository noteActivityLogRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.noteActivityProducer = noteActivityProducer;
        this.noteActivityLogRepository = noteActivityLogRepository;
    }

    // ---------- shared helpers ----------

    private User requireUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new UserNotFoundException("User not found");
        return user;
    }

    // The client only ever sees "noteNumber" (see NoteResponseDTO — it has no
    // internal id field), so every lookup coming from the API must resolve by
    // noteNumber scoped to the owning user, NOT by the JPA primary key.
    private Note requireNoteByNumber(User user, Long noteNumber) {
        return noteRepository.findByUserAndNoteNumber(user, noteNumber.intValue())
                .orElseThrow(() -> new NoteNotFoundException(
                        "Note with noteNumber " + noteNumber + " not found for this user"));
    }

    // Trim, lowercase, drop blanks, dedupe — keeps tag matching predictable
    // ("Work" and " work " are the same tag) and keeps the join table clean.
    private Set<String> normalizeTags(Collection<String> raw) {
        if (raw == null) return new HashSet<>();
        return raw.stream()
                .filter(t -> t != null && !t.isBlank())
                .map(t -> t.trim().toLowerCase())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    // Explicit state machine so transitions can't silently do the wrong thing.
    //   ACTIVE   -> ARCHIVED (archive), ACTIVE   -> TRASHED (trash)
    //   ARCHIVED -> ACTIVE   (restore), ARCHIVED -> TRASHED (trash)
    //   TRASHED  -> ACTIVE   (restore)  [must be restored before it can be archived again]
    private void validateTransition(Note.NoteState from, Note.NoteState to) {
        boolean valid = switch (from) {
            case ACTIVE -> to == Note.NoteState.ARCHIVED || to == Note.NoteState.TRASHED;
            case ARCHIVED -> to == Note.NoteState.ACTIVE || to == Note.NoteState.TRASHED;
            case TRASHED -> to == Note.NoteState.ACTIVE;
        };
        if (from == to) {
            throw new InvalidNoteStateTransitionException("Note is already " + from);
        }
        if (!valid) {
            throw new InvalidNoteStateTransitionException(
                    "Cannot move a note from " + from + " to " + to +
                    (from == Note.NoteState.TRASHED ? " — restore it first" : ""));
        }
    }

    @Override
    @CacheEvict(value = "userNotes", key = "#email")
    public NoteResponseDTO archiveNote(String email, Long noteNumber) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        validateTransition(note.getState(), Note.NoteState.ARCHIVED);

        note.setState(Note.NoteState.ARCHIVED);
        note.setPinned(false);
        note.setUpdatedAt(LocalDateTime.now());

        Note saved = noteRepository.save(note);
        noteActivityProducer.publish(email, "ARCHIVED", saved.getNoteNumber(), saved.getTitle());
        return toResponse(saved);
    }

    @Override
    @CacheEvict(value = "userNotes", key = "#email")
    public NoteResponseDTO trashNote(String email, Long noteNumber) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        validateTransition(note.getState(), Note.NoteState.TRASHED);

        note.setState(Note.NoteState.TRASHED);
        note.setPinned(false);
        note.setUpdatedAt(LocalDateTime.now());

        Note saved = noteRepository.save(note);
        noteActivityProducer.publish(email, "TRASHED", saved.getNoteNumber(), saved.getTitle());
        return toResponse(saved);
    }

    @Override
    @CacheEvict(value = "userNotes", key = "#email")
    public NoteResponseDTO restoreNote(String email, Long noteNumber) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        validateTransition(note.getState(), Note.NoteState.ACTIVE);

        note.setState(Note.NoteState.ACTIVE);
        note.setUpdatedAt(LocalDateTime.now());

        Note saved = noteRepository.save(note);
        noteActivityProducer.publish(email, "RESTORED", saved.getNoteNumber(), saved.getTitle());
        return toResponse(saved);
    }

    @Override
    @CacheEvict(value = "userNotes", key = "#email")
    public NoteResponseDTO pinNote(String email, Long noteNumber) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        if (note.getState() != Note.NoteState.ACTIVE) {
            throw new InvalidNoteStateTransitionException(
                    "Only ACTIVE notes can be pinned (note is " + note.getState() + ")");
        }
        if (note.isPinned()) {
            throw new InvalidNoteStateTransitionException("Note is already pinned");
        }

        note.setPinned(true);
        note.setUpdatedAt(LocalDateTime.now());

        Note saved = noteRepository.save(note);
        noteActivityProducer.publish(email, "PINNED", saved.getNoteNumber(), saved.getTitle());
        return toResponse(saved);
    }

    @Override
    @CacheEvict(value = "userNotes", key = "#email")
    public NoteResponseDTO unpinNote(String email, Long noteNumber) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        if (!note.isPinned()) {
            throw new InvalidNoteStateTransitionException("Note is not pinned");
        }

        note.setPinned(false);
        note.setUpdatedAt(LocalDateTime.now());

        Note saved = noteRepository.save(note);
        noteActivityProducer.publish(email, "UNPINNED", saved.getNoteNumber(), saved.getTitle());
        return toResponse(saved);
    }

    @Override
    public List<NoteResponseDTO> getNotesByState(String email, String state) {
        User user = requireUser(email);

        Note.NoteState noteState = Note.NoteState.valueOf(state.toUpperCase());
        List<Note> notes = noteRepository.findByUserAndState(user, noteState);

        return notes.stream().map(this::toResponse).toList();
    }

    @Override
    public List<NoteResponseDTO> getNotesByPinned(String email, boolean pinned) {
        User user = requireUser(email);

        List<Note> notes = noteRepository.findByUserAndPinned(user, pinned);

        return notes.stream().map(this::toResponse).toList();
    }

    @Override
    public List<NoteResponseDTO> searchNotes(String email, String keyword, String tag, String tagMatch, String state) {
        User user = requireUser(email);

        Specification<Note> spec = Specification.where(NoteSpecifications.belongsToUser(user));

        if (state != null && !state.isBlank()) {
            Note.NoteState noteState = Note.NoteState.valueOf(state.trim().toUpperCase());
            spec = spec.and(NoteSpecifications.hasState(noteState));
        }
        if (keyword != null && !keyword.isBlank()) {
            spec = spec.and(NoteSpecifications.titleOrContentContains(keyword.trim()));
        }

        List<Note> notes = noteRepository.findAll(spec);

        if (tag != null && !tag.isBlank()) {
            Set<String> requestedTags = normalizeTags(List.of(tag.split(",")));
            boolean matchAll = "ALL".equalsIgnoreCase(tagMatch);

            notes = notes.stream()
                    .filter(n -> {
                        Set<String> noteTags = n.getTags();
                        if (noteTags == null || noteTags.isEmpty()) return false;
                        return matchAll
                                ? noteTags.containsAll(requestedTags)
                                : requestedTags.stream().anyMatch(noteTags::contains);
                    })
                    .toList();
        }

        return notes.stream().map(this::toResponse).toList();
    }

    @Override
    @CacheEvict(value = "userNotes", key = "#email")
    public NoteResponseDTO addTags(String email, Long noteNumber, Set<String> tags) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        if (note.getTags() == null) note.setTags(new HashSet<>());
        note.getTags().addAll(normalizeTags(tags));
        note.setUpdatedAt(LocalDateTime.now());

        Note saved = noteRepository.save(note);
        noteActivityProducer.publish(email, "TAG_ADDED", saved.getNoteNumber(), saved.getTitle());
        return toResponse(saved);
    }

    @Override
    @CacheEvict(value = "userNotes", key = "#email")
    public NoteResponseDTO removeTag(String email, Long noteNumber, String tag) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        if (tag == null || tag.isBlank()) {
            throw new IllegalArgumentException("Tag to remove must not be blank");
        }
        if (note.getTags() != null) {
            note.getTags().removeIf(t -> t.equalsIgnoreCase(tag.trim()));
        }
        note.setUpdatedAt(LocalDateTime.now());

        Note saved = noteRepository.save(note);
        noteActivityProducer.publish(email, "TAG_REMOVED", saved.getNoteNumber(), saved.getTitle());
        return toResponse(saved);
    }

    //  Helper method to avoid repetition
    private NoteResponseDTO toResponse(Note note) {
        return new NoteResponseDTO(
                note.getNoteNumber(),
                note.getTitle(),
                note.getContent(),
                note.getState().name(),
                note.isPinned(),
                note.getCreatedAt(),
                note.getUpdatedAt(),
                note.getTags(),
                note.getReminderAt()
        );
    }

    @Override
    @CacheEvict(value = "userNotes", key = "#email")
    public NoteResponseDTO createNote(String email, NoteRequestDTO noteRequest) {
        User user = requireUser(email);

        if (noteRepository.existsByUserAndTitleIgnoreCase(user, noteRequest.getTitle())) {
            throw new NoteTitleAlreadyExistsException(
                    "You already have a note titled \"" + noteRequest.getTitle() + "\"");
        }

        int nextNumber = noteRepository.findMaxNoteNumberByUser(user) + 1;

        Note note = new Note();
        note.setTitle(noteRequest.getTitle());
        note.setContent(noteRequest.getContent());
        note.setUser(user);
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        note.setNoteNumber(nextNumber);
        note.setTags(normalizeTags(noteRequest.getTags()));

        Note savedNote = noteRepository.save(note);
        noteActivityProducer.publish(email, "CREATED", savedNote.getNoteNumber(), savedNote.getTitle());

        return toResponse(savedNote);
    }

    // Cached in Redis under "userNotes::<email>". Cleared by every mutating
    // method below via @CacheEvict so the list is never stale for more than
    // one request.
    @Override
    @Cacheable(value = "userNotes", key = "#email")
    public List<NoteResponseDTO> getUserNotes(String email) {
        User user = requireUser(email);
        List<Note> notes = noteRepository.findByUser(user);

        return notes.stream().map(this::toResponse).toList();
    }
    @Override
    public List<Note> findActiveByOwner(String email) {

        User user = requireUser(email);

        return noteRepository.findByUserAndState(
                user,
                Note.NoteState.ACTIVE
        );
    }

    @Override
    @CacheEvict(value = "userNotes", key = "#email")
    public NoteResponseDTO patchNote(String email, Long noteNumber, Map<String, Object> updates) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        // Update only provided fields
        if (updates.containsKey("title")) {
            String newTitle = (String) updates.get("title");
            // Only enforce uniqueness if the title is actually changing
            if (newTitle != null && !newTitle.equalsIgnoreCase(note.getTitle())
                    && noteRepository.existsByUserAndTitleIgnoreCase(user, newTitle)) {
                throw new NoteTitleAlreadyExistsException(
                        "You already have a note titled \"" + newTitle + "\"");
            }
            note.setTitle(newTitle);
        }
        if (updates.containsKey("content")) {
            note.setContent((String) updates.get("content"));
        }
        if (updates.containsKey("tags")) {
            @SuppressWarnings("unchecked")
            Collection<String> rawTags = (Collection<String>) updates.get("tags");
            note.setTags(normalizeTags(rawTags));
        }

        // Always refresh updatedAt
        note.setUpdatedAt(LocalDateTime.now());

        Note savedNote = noteRepository.save(note);
        noteActivityProducer.publish(email, "UPDATED", savedNote.getNoteNumber(), savedNote.getTitle());

        return toResponse(savedNote);
    }

    @Override
    @CacheEvict(value = "userNotes", key = "#email")
    public void deleteNote(String email, Long noteNumber) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        Integer noteNum = note.getNoteNumber();
        String title = note.getTitle();
        noteRepository.delete(note);
        noteActivityProducer.publish(email, "DELETED", noteNum, title);
    }

    @Override
    @CacheEvict(value = "userNotes", key = "#email")
    public NoteResponseDTO setReminder(String email, Long noteNumber, LocalDateTime reminderAt) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        if (reminderAt == null) {
            note.setReminderAt(null);
            note.setReminderSent(false);
            Note saved = noteRepository.save(note);
            noteActivityProducer.publish(email, "REMINDER_CANCELLED", saved.getNoteNumber(), saved.getTitle());
            return toResponse(saved);
        }

        if (reminderAt.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Reminder time must be in the future");
        }

        note.setReminderAt(reminderAt);
        note.setReminderSent(false); // re-arm in case this note's reminder already fired once before
        Note saved = noteRepository.save(note);
        noteActivityProducer.publish(email, "REMINDER_SET", saved.getNoteNumber(), saved.getTitle());
        return toResponse(saved);
    }

    @Override
    public List<NoteActivityResponseDTO> getRecentActivity(String email) {
        return noteActivityLogRepository.findByUsernameOrderByTimestampDesc(email).stream()
                .map(log -> new NoteActivityResponseDTO(
                        log.getAction(),
                        log.getNoteNumber(),
                        log.getNoteTitle(),
                        log.getTimestamp()))
                .toList();
    }
}
