package com.fundoo.notes.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class NoteResponseDTO {
private Integer noteNumber;
private String title;
private String content;
private String state;
private boolean pinned;
@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
private LocalDateTime createdAt;
@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
private  LocalDateTime  updatedAt;
private Set<String> tags;
@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
private LocalDateTime reminderAt;
}
