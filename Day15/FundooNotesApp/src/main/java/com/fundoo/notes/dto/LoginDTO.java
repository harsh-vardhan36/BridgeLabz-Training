package com.fundoo.notes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LoginDTO {
 @Email(message = "Email must be Valid")
 private String email;
 @Size(min = 8, message = " Password must contains atleast 8 characters.")
 private String password;
}
