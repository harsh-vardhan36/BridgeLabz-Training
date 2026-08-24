package com.fundoo.notes.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoteRequestDTO {
	@NotBlank
private String title;
private String content;
// Optional: tags can be set at creation/patch time instead of the dedicated tag endpoints
private Set<String> tags;
}
