package com.fundoo.notes.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	
	@Column(unique = true ,  nullable = false)
private String userName;
	
	@Column(nullable = false)
private String name;
	
	@Column(unique = true, nullable = false )
	@Email(message = "Email must be valid")
private String email; 
	
	@NotBlank
	@Size(min = 8 , message = "Password must contains at least 8 digit")
private String password;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")	
private LocalDateTime createdAt = LocalDateTime.now();

	@Column(nullable = false)
private  String role  =  "USER";

}
