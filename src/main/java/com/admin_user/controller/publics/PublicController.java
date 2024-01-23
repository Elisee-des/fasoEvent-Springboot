package com.admin_user.controller.publics;

import org.springframework.web.bind.annotation.GetMapping;

public class PublicController {
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
}
