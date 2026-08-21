package com.fundoo.notes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoteRequestDTO {
	@NotBlank
private String title;
private String content;
}
