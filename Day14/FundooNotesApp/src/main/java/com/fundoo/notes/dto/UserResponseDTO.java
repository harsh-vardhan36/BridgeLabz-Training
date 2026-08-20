package com.fundoo.notes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {
	private Long id;
	private String userName;
	private String name;
	private String email;
	private String createdAt;
	private String role;
	
}
