package com.admin_user.controller.privates;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.admin_user.service.UserService;

@Controller
public class AbonneController {
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("abonne-page")
	public String userPage(Model model, Principal principal){
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("private/abonne/indexabonne", userDetails);
		return "abonne";
	}

}
