package com.admin_user.controller.privates;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AbonneController {
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping("abonne-page")
	public String userPage(Model model, Principal principal){
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("abonne", userDetails);
		return "private/abonne/index";
	}

}
