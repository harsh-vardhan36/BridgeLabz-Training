package com.fundoo.notes.dto;

import java.time.LocalDateTime;

/** What GET /api/notes/activity returns -- the caller's own audit trail. */
public class NoteActivityResponseDTO {

    private String action;
    private Integer noteNumber;
    private String noteTitle;
    private LocalDateTime timestamp;

    public NoteActivityResponseDTO() {
    }

    public NoteActivityResponseDTO(String action, Integer noteNumber, String noteTitle, LocalDateTime timestamp) {
        this.action = action;
        this.noteNumber = noteNumber;
        this.noteTitle = noteTitle;
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getNoteNumber() {
        return noteNumber;
    }

    public void setNoteNumber(Integer noteNumber) {
        this.noteNumber = noteNumber;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
