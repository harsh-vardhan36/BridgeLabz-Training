package com.fundoo.notes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fundoo.notes.dto.NoteActivityResponseDTO;
import com.fundoo.notes.dto.NoteRequestDTO;
import com.fundoo.notes.dto.NoteResponseDTO;

public interface NoteService {
    // Note: every "Long noteNumber" below is the client-facing NoteResponseDTO.noteNumber
    // (scoped per user), NOT the internal JPA primary key.
    NoteResponseDTO createNote(String email, NoteRequestDTO note);
    List<NoteResponseDTO> getUserNotes(String email);
    NoteResponseDTO patchNote(String email, Long noteNumber, Map<String, Object> updates);
    void deleteNote(String email, Long noteNumber);
    
    NoteResponseDTO archiveNote(String email, Long noteNumber);
    NoteResponseDTO trashNote(String email, Long noteNumber);
    NoteResponseDTO restoreNote(String email, Long noteNumber);
    NoteResponseDTO pinNote(String email, Long noteNumber);
    NoteResponseDTO unpinNote(String email, Long noteNumber);
    
    List<NoteResponseDTO> getNotesByState(String email, String state);
    List<NoteResponseDTO> getNotesByPinned(String email, boolean pinned);

    // keyword: matches title OR content (contains, case-insensitive)
    // tag: single tag, or comma-separated list of tags
    // tagMatch: "ANY" (default) or "ALL" — only relevant when >1 tag is passed
    // state: exact NoteState match
    // All provided filters are combined with AND; pass null/blank to skip a filter.
    List<NoteResponseDTO> searchNotes(String email, String keyword, String tag, String tagMatch, String state);

    NoteResponseDTO addTags(String email, Long noteNumber, Set<String> tags);
    NoteResponseDTO removeTag(String email, Long noteNumber, String tag);

    // Audit trail built from RabbitMQ note-activity events (see NoteActivityListener),
    // most recent first.
    List<NoteActivityResponseDTO> getRecentActivity(String email);

    // Set a reminder (must be a future time) or pass null to cancel the
    // existing one. Fired by ReminderScheduler via RabbitMQ once reminderAt passes.
    NoteResponseDTO setReminder(String email, Long noteNumber, LocalDateTime reminderAt);

}
