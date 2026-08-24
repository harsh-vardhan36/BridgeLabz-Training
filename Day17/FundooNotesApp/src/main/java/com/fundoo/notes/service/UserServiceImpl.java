package com.fundoo.notes.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fundoo.notes.dto.LoginDTO;
import com.fundoo.notes.dto.LoginResponseDTO;
import com.fundoo.notes.dto.UserRegistrationDTO;
import com.fundoo.notes.dto.UserResponseDTO;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.exception.InvalidCredentialsException;
import com.fundoo.notes.exception.UserAlreadyExistException;
import com.fundoo.notes.exception.UserNameAlreadyTakenException;
import com.fundoo.notes.exception.UserNotFoundException;
import com.fundoo.notes.repository.UserRepository;
import com.fundoo.notes.security.JwtUtil;
import com.fundoo.notes.jms.EmailProducer;
import com.fundoo.notes.rabbit.RabbitEmailProducer;

@Service
public class UserServiceImpl implements UserService{
	
	
	private PasswordEncoder passwordEncoder;
	
	
	private JwtUtil jwtUtil;
	
	private UserRepository userRepository;

	private EmailProducer emailProducer;

	private RabbitEmailProducer rabbitEmailProducer;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil,
			EmailProducer emailProducer, RabbitEmailProducer rabbitEmailProducer) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
		this.emailProducer = emailProducer;
		this.rabbitEmailProducer = rabbitEmailProducer;
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
		user.setRole("USER");
		
		User savedUser = userRepository.save(user);

		// Fire-and-forget: publish to JMS (and, in parallel, RabbitMQ) instead
		// of sending mail inline so registration doesn't wait on SMTP.
		emailProducer.sendWelcomeEmail(savedUser.getEmail(), savedUser.getName());
		rabbitEmailProducer.sendWelcomeEmail(savedUser.getEmail(), savedUser.getName());

		return new UserResponseDTO(
				savedUser.getId(),
				savedUser.getUserName(),
				savedUser.getName(),
				savedUser.getEmail(),
				savedUser.getCreatedAt().toString(),
				savedUser.getRole()
				);
	}

	@Override
	public LoginResponseDTO loginUser(LoginDTO dto) {
		
	    //  Check if user exists by email
	    User user = userRepository.findByEmail(dto.getEmail());
	    if (user == null) {
	        throw new UserNotFoundException("User with email " + dto.getEmail() + " not found");
	    }

	    if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
	        throw new InvalidCredentialsException("Invalid email or password");
	    }

	    String token = jwtUtil.generateToken(user);

	    return new LoginResponseDTO("Login successful!", token);
	}

	@Override
	public UserResponseDTO getCurrentUser(String email) {
	    User user = userRepository.findByEmail(email);
	    if (user == null) {
	        throw new UserNotFoundException("User not found!");
	    }

	    return new UserResponseDTO(
	        user.getId(),
	        user.getUserName(),
	        user.getName(),
	        user.getEmail(),
	        user.getCreatedAt().toString(),
	        user.getRole()
	    );
	}

}
