package com.fundoo.notes.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fundoo.notes.dto.LoginDTO;
import com.fundoo.notes.dto.UserRegistrationDTO;
import com.fundoo.notes.dto.UserResponseDTO;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.exception.InvalidCredentialsException;
import com.fundoo.notes.exception.UserAlreadyExistException;
import com.fundoo.notes.exception.UserNameAlreadyTakenException;
import com.fundoo.notes.exception.UserNotFoundException;
import com.fundoo.notes.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	
	private PasswordEncoder passwordEncoder;
	
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public UserResponseDTO registerUser(UserRegistrationDTO dto) {
		if(userRepository.findByEmail( dto.getEmail() )!=null) {
			throw new UserAlreadyExistException("Email Already in Use!");	
		}
		
		if(userRepository.findByUserName( dto.getUserName() )!=null ) {
			throw new UserNameAlreadyTakenException("Username already taken!");
		}
		String encode = passwordEncoder.encode(dto.getPassword());
		User user = new User();
		user.setUserName(dto.getUserName());
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(encode);
		user.setCreatedAt(LocalDateTime.now());
		
		User savedUser = userRepository.save(user);
		
		return new UserResponseDTO(
				savedUser.getId(),
				savedUser.getUserName(),
				savedUser.getName(),
				savedUser.getEmail(),
				savedUser.getCreatedAt().toString()
				);
	}

	@Override
	public UserResponseDTO loginUser(LoginDTO dto) {
		
	    //  Check if user exists by email
	    User user = userRepository.findByEmail(dto.getEmail());
	    if (user == null) {
	        throw new UserNotFoundException("User with email " + dto.getEmail() + " not found");
	    }

	    if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
	        throw new InvalidCredentialsException("Invalid email or password");
	    }

	    return new UserResponseDTO(
	        user.getId(),
	        user.getUserName(),
	        user.getName(),
	        user.getEmail(),
	        user.getCreatedAt().toString()
	    );
	}


}
