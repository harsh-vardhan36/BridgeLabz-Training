package com.fundoo.notes.dto;

import java.util.Set;

import lombok.Data;

@Data
public class TagRequestDTO {
	private Set<String> tags;
}
