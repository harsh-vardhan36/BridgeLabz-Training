package com.fundoo.notes.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * Body for PATCH /api/notes/{id}/reminder.
 * reminderAt = a future timestamp to set/replace the reminder.
 * reminderAt = null (or omitted) to cancel any existing reminder.
 */
@Data
public class ReminderRequestDTO {
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime reminderAt;
}
