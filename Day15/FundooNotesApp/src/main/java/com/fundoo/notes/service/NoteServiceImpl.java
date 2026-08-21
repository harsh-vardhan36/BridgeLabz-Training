package com.fundoo.notes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fundoo.notes.dto.NoteRequestDTO;
import com.fundoo.notes.dto.NoteResponseDTO;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.exception.InvalidNoteStateTransitionException;
import com.fundoo.notes.exception.NoteNotFoundException;
import com.fundoo.notes.exception.NoteTitleAlreadyExistsException;
import com.fundoo.notes.exception.UserNotFoundException;
import com.fundoo.notes.repository.NoteRepository;
import com.fundoo.notes.repository.UserRepository;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
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
    public NoteResponseDTO archiveNote(String email, Long noteNumber) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        validateTransition(note.getState(), Note.NoteState.ARCHIVED);

        note.setState(Note.NoteState.ARCHIVED);
        note.setPinned(false);
        note.setUpdatedAt(LocalDateTime.now());

        return toResponse(noteRepository.save(note));
    }

    @Override
    public NoteResponseDTO trashNote(String email, Long noteNumber) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        validateTransition(note.getState(), Note.NoteState.TRASHED);

        note.setState(Note.NoteState.TRASHED);
        note.setPinned(false);
        note.setUpdatedAt(LocalDateTime.now());

        return toResponse(noteRepository.save(note));
    }

    @Override
    public NoteResponseDTO restoreNote(String email, Long noteNumber) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        validateTransition(note.getState(), Note.NoteState.ACTIVE);

        note.setState(Note.NoteState.ACTIVE);
        note.setUpdatedAt(LocalDateTime.now());

        return toResponse(noteRepository.save(note));
    }

    @Override
    public NoteResponseDTO pinNote(String email, Long noteNumber) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        if (note.getState() != Note.NoteState.ACTIVE) {
            throw new InvalidNoteStateTransitionException(
                    "Only ACTIVE notes can be pinned (note is " + note.getState() + ")");
        }

        note.setPinned(true);
        note.setUpdatedAt(LocalDateTime.now());

        return toResponse(noteRepository.save(note));
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

    //  Helper method to avoid repetition
    private NoteResponseDTO toResponse(Note note) {
        return new NoteResponseDTO(
                note.getNoteNumber(),
                note.getTitle(),
                note.getContent(),
                note.getState().name(),
                note.isPinned(),
                note.getCreatedAt(),
                note.getUpdatedAt()
        );
    }

    @Override
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

        Note savedNote = noteRepository.save(note);

        return toResponse(savedNote);
    }

    @Override
    public List<NoteResponseDTO> getUserNotes(String email) {
        User user = requireUser(email);
        List<Note> notes = noteRepository.findByUser(user);

        return notes.stream().map(this::toResponse).toList();
    }

    @Override
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

        // Always refresh updatedAt
        note.setUpdatedAt(LocalDateTime.now());

        Note savedNote = noteRepository.save(note);

        return toResponse(savedNote);
    }

    @Override
    public void deleteNote(String email, Long noteNumber) {
        User user = requireUser(email);
        Note note = requireNoteByNumber(user, noteNumber);

        noteRepository.delete(note);
    }
}
