package com.admin_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.admin_user.dto.UserDto;
import com.admin_user.model.User;
import com.admin_user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//Pour masquer le mot de passe dans la BD
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getRole(), userDto.getFullname());
		return userRepository.save(user);
		 
	}
	
}
