package com.fundoo.notes.service;

import java.util.List;
import java.util.Map;

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
    
    List<NoteResponseDTO> getNotesByState(String email, String state);
    List<NoteResponseDTO> getNotesByPinned(String email, boolean pinned);

}
