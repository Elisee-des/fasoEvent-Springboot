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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private CategoryService categoriyService;
	
	@GetMapping("/admin-page")
	public String adminPage(Model model, Principal principal){
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("admin", userDetails);
		return "private/admin/tableaudebord";
	}
	
	
	/****************** CATEGORIES ****************/
	
	
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
	
	@GetMapping("/categorie-edit-{id}")
	public String editCategory(@PathVariable Long id, Model model, Principal principal)
	{
		Category category = categoriyService.getCategoryById(id);
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		List<Category> categories = categoriyService.getAllCategories();
		model.addAttribute("admin", userDetails);
		model.addAttribute("categories", categories);
		model.addAttribute("category", category);
		
		return "private/admin/category/edit";
	}
	
	@PostMapping("/update")
	public String updateCategory(@ModelAttribute Category category, HttpSession session, Model model, Principal principal) {
		categoriyService.updateCategory(category);
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		List<Category> categories = categoriyService.getAllCategories();
		model.addAttribute("admin", userDetails);
		model.addAttribute("categories", categories);
		model.addAttribute("success", "Catégorie edité avec succès !");
		/*return "redirect:/categories-liste";*/
		return "private/admin/category/index";

	}

	@GetMapping("/categorie-delete-{id}")
	public String deleteCategory(@PathVariable Long id, HttpSession session, Model model, Principal principal) {
		categoriyService.deleteCategory(id);
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		List<Category> categories = categoriyService.getAllCategories();
		model.addAttribute("admin", userDetails);
		model.addAttribute("categories", categories);
		session.setAttribute("success", "Catégorie supprimer avec succès !");
		return "private/admin/category/index";
	}
	
	
	/****************** FIN CATEGORIES ******************/
	
	
	/****************** UTILISATEURS ********************/
	
	
	@GetMapping("/utilisateurs-liste")
	public String indexUtilisateur(Principal principal, Model model)
	{
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("admin", userDetails);
		return "private/admin/users/index";
	}

}
