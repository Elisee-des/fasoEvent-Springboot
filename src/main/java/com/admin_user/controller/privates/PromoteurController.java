package com.admin_user.controller.privates;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PromoteurController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	@GetMapping("promoteur-page")
	public String promoteurPage(Model model, Principal principal){
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("promoteur", userDetails);
		return "private/promoteur/index";
	}
	
}
