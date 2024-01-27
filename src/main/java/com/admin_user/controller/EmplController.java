package com.admin_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmplController {
	
	@GetMapping("/employer")
	public String addEvenement() {
		return "private/evenement/formulaireEven";
	}

}
