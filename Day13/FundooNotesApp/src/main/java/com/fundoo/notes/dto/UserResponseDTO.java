package com.fundoo.notes.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserResponseDTO {
	private Long id;
	private String userName;
	private String name;
	private String email;
	private String createdAt;
	
}
