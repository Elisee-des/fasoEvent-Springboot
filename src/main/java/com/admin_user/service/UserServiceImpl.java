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
        // Définir le rôle par défaut
        String defaultRole = "ABONNE";
        
        // Créer l'utilisateur avec le rôle par défaut
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), 
                             userDto.getRole() != null ? userDto.getRole() : defaultRole, 
                             userDto.getFullname());

        // Enregistrer l'utilisateur dans la base de données
        return userRepository.save(user);
    }
	
	// Implémentation de la nouvelle méthode findByUsername
    @Override
    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }
	
}
