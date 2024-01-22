package com.admin_user.service;

import com.admin_user.dto.UserDto;
import com.admin_user.model.User;

public interface UserService {
	
	User save (UserDto userDto);
}
