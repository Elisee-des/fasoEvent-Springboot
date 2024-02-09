package com.admin_user.service;

import com.admin_user.dto.UserDto;
import com.admin_user.model.User;

public interface UserService {
	
	User save (UserDto userDto);
	
    // Ajouter cette méthode pour récupérer un utilisateur par son nom d'utilisateur
    User findByUsername(String username);
}
