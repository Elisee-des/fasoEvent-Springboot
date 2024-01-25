package com.admin_user.controller.privates;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.admin_user.model.Category;
import com.admin_user.service.CategoryService;
import com.admin_user.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private CategoryService categoriyService;
	
	@GetMapping("/admin-page")
	public String adminPage(Model model, Principal principal){
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("admin", userDetails);
		return "private/admin/tableaudebord";
	}
	
	
	/****************** Categories ****************/
	
	@GetMapping("/categories-liste")
	public String indexCategory(Principal principal, Model model)
	{
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		List<Category> categories = categoriyService.getAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("admin", userDetails);
		return "private/admin/category/index";
	}
	
	@GetMapping("/categories-ajout")
	public String ajoutCategory()
	{
		return "private/admin/category/ajout";
	}
	
	@PostMapping("/categorie-ajout-action")
	public String ajoutActionCategorie(@ModelAttribute Category category, HttpSession session, Model model, Principal principal)
	{
		categoriyService.ajoutCategory(category);
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		List<Category> categories = categoriyService.getAllCategories();
		model.addAttribute("admin", userDetails);
		model.addAttribute("categories", categories);
		model.addAttribute("success", "Catégorie ajouté avec succès !");
		return "private/admin/category/index";
	}
	
	
}
