package com.fundoo.notes.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Payload put on the RabbitMQ activity exchange by NoteActivityProducer and
 * consumed by NoteActivityListener, which persists it as an audit trail.
 */
public class NoteActivityEvent implements Serializable {

    private String username;   // owning user's email -- identifies whose note this is
    private String action;     // CREATED, UPDATED, DELETED, ARCHIVED, TRASHED, RESTORED, PINNED, UNPINNED, TAG_ADDED, TAG_REMOVED
    private Integer noteNumber;
    private String noteTitle;
    private LocalDateTime timestamp;

    public NoteActivityEvent() {
    }

    public NoteActivityEvent(String username, String action, Integer noteNumber, String noteTitle, LocalDateTime timestamp) {
        this.username = username;
        this.action = action;
        this.noteNumber = noteNumber;
        this.noteTitle = noteTitle;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "NoteActivityEvent{user='" + username + "', action='" + action +
                "', noteNumber=" + noteNumber + ", noteTitle='" + noteTitle + "'}";
    }
}
