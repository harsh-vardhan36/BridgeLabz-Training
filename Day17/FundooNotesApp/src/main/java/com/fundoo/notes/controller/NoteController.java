package com.fundoo.notes.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fundoo.notes.dto.NoteActivityResponseDTO;
import com.fundoo.notes.dto.NoteRequestDTO;
import com.fundoo.notes.dto.NoteResponseDTO;
import com.fundoo.notes.dto.ReminderRequestDTO;
import com.fundoo.notes.dto.TagRequestDTO;
import com.fundoo.notes.security.JwtUtil;
import com.fundoo.notes.service.NoteService;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;
    private final JwtUtil jwtUtil;

    public NoteController(NoteService noteService, JwtUtil jwtUtil) {
        this.noteService = noteService;
        this.jwtUtil = jwtUtil;
    }

    //  Create Note
    @PostMapping
    public ResponseEntity<NoteResponseDTO> createNote(@RequestHeader("Authorization") String token,
                                                      @RequestBody NoteRequestDTO noteRequest) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.createNote(email, noteRequest));
    }

    //  Get All Notes
    @GetMapping
    public ResponseEntity<List<NoteResponseDTO>> getNotes(@RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.getUserNotes(email));
    }

    //  Recent activity (audit trail, built from RabbitMQ note-activity events)
    @GetMapping("/activity")
    public ResponseEntity<List<NoteActivityResponseDTO>> getRecentActivity(@RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.getRecentActivity(email));
    }

    //  Set or cancel a reminder (send reminderAt: null to cancel)
    @PatchMapping("/{id}/reminder")
    public ResponseEntity<NoteResponseDTO> setReminder(@RequestHeader("Authorization") String token,
                                                        @PathVariable Long id,
                                                        @RequestBody ReminderRequestDTO request) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.setReminder(email, id, request.getReminderAt()));
    }

    //  Patch Update Note
    @PatchMapping("/{id}")
    public ResponseEntity<NoteResponseDTO> patchNote(@RequestHeader("Authorization") String token,
                                                     @PathVariable Long id,
                                                     @RequestBody Map<String, Object> updates) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.patchNote(email, id, updates));
    }

    //  Delete Note
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@RequestHeader("Authorization") String token,
                                           @PathVariable Long id) {
        String email = jwtUtil.extractUsername(token.substring(7));
        noteService.deleteNote(email, id);
        return ResponseEntity.noContent().build();
    }

    // --- State Transition Endpoints ---

    //  Archive Note
    @PatchMapping("/{id}/archive")
    public ResponseEntity<NoteResponseDTO> archiveNote(@RequestHeader("Authorization") String token,
                                                       @PathVariable Long id) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.archiveNote(email, id));
    }

    // Trash Note
    @PatchMapping("/{id}/trash")
    public ResponseEntity<NoteResponseDTO> trashNote(@RequestHeader("Authorization") String token,
                                                     @PathVariable Long id) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.trashNote(email, id));
    }

    //  Restore Note
    @PatchMapping("/{id}/restore")
    public ResponseEntity<NoteResponseDTO> restoreNote(@RequestHeader("Authorization") String token,
                                                       @PathVariable Long id) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.restoreNote(email, id));
    }

    //  Pin Note
    @PatchMapping("/{id}/pin")
    public ResponseEntity<NoteResponseDTO> pinNote(@RequestHeader("Authorization") String token,
                                                   @PathVariable Long id) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.pinNote(email, id));
    }

    //  Unpin Note
    @PatchMapping("/{id}/unpin")
    public ResponseEntity<NoteResponseDTO> unpinNote(@RequestHeader("Authorization") String token,
                                                      @PathVariable Long id) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.unpinNote(email, id));
    }

    // --- Tag Endpoints ---

    //  Add one or more tags to a note (existing tags are kept)
    @PostMapping("/{id}/tags")
    public ResponseEntity<NoteResponseDTO> addTags(@RequestHeader("Authorization") String token,
                                                    @PathVariable Long id,
                                                    @RequestBody TagRequestDTO request) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.addTags(email, id, request.getTags()));
    }

    //  Remove a single tag from a note
    @DeleteMapping("/{id}/tags/{tag}")
    public ResponseEntity<NoteResponseDTO> removeTag(@RequestHeader("Authorization") String token,
                                                      @PathVariable Long id,
                                                      @PathVariable String tag) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.removeTag(email, id, tag));
    }

    // --- Search ---

    //  Search by title/content keyword, tag(s), and/or state — all optional, combined with AND.
    //  e.g. GET /api/notes/search?keyword=grocery&tag=urgent,home&tagMatch=ANY&state=ACTIVE
    @GetMapping("/search")
    public ResponseEntity<List<NoteResponseDTO>> searchNotes(
            @RequestHeader("Authorization") String token,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String tag,
            @RequestParam(required = false, defaultValue = "ANY") String tagMatch,
            @RequestParam(required = false) String state) {

        String email = jwtUtil.extractUsername(token.substring(7));
        return ResponseEntity.ok(noteService.searchNotes(email, keyword, tag, tagMatch, state));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<NoteResponseDTO>> filterNotes(
            @RequestHeader("Authorization") String token,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) Boolean pinned) {

        String email = jwtUtil.extractUsername(token.substring(7));

        // If state is provided
        if (state != null) {
            return ResponseEntity.ok(noteService.getNotesByState(email, state));
        }

        // If pinned is provided
        if (pinned != null) {
            return ResponseEntity.ok(noteService.getNotesByPinned(email, pinned));
        }

        // Default: return active notes
        return ResponseEntity.ok(noteService.getNotesByState(email, "ACTIVE"));
    }

}
