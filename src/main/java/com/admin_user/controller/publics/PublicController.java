package com.admin_user.controller.publics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.admin_user.dto.UserDto;
import com.admin_user.service.UserService;

@Controller
public class PublicController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "public/auth/login";
	}
	
	@GetMapping("/options-incriptions")
	public String optionInscription() {
		return "public/auth/options";
	}
	
	@PostMapping("/registration-promoteur")
	public String saveUserPromoteur(@ModelAttribute("userPromoteur") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Inscription reussi !");
		return "public/auth/register-promoteur";
	}
	
	@GetMapping("/registration-promoteur")
	public String getRegistrationPromoteurPage(@ModelAttribute("userPromoteur") UserDto userDto, Model model) {
		return "public/auth/register-promoteur";
	}
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto, Model model) {
		return "public/auth/register";
	}

	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Inscription reussi !");
		return "public/auth/register";
	}
	
}
