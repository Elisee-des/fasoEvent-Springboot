package com.admin_user.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.admin_user.dto.UserDto;
import com.admin_user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	
	
	
	
<<<<<<< HEAD
	@GetMapping("admin-page")
	public String adminPage(Model model, Principal principal){
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("admin", userDetails);
		return "admin";
	}
		
=======

	
	
	
	
	
>>>>>>> elisee
}