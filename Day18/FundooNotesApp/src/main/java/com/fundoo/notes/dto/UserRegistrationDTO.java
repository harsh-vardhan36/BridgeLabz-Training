package com.fundoo.notes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegistrationDTO {
	@NotBlank(message = "UserName is Required!")
	private String userName;
	@NotBlank(message = "Name is Required")
	private String name;
	@Email(message = "Email is Required")
	private String email;
	@Pattern(
	        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$",
	        message = "Password must contain at least 8 characters, including one uppercase, one lowercase, and one digit"
	    )
	private String password;
	
	
}
