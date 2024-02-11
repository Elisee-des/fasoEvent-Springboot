package com.admin_user.controller.privates;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.admin_user.model.Evenement;
import com.admin_user.service.EvenService;
import com.admin_user.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EvenementController {
	
	@Autowired
	EvenService evenService;
	
	@Autowired
	UserService userService;

	//Acceder a la page de la liste des evenements
	@GetMapping("/evenement-page")
	public String evenementPage(Model model) {
	    List<Evenement> evenements = evenService.getAllEvenements();
	    model.addAttribute("evenements",evenements);
	    return "private/evenement/evenement";
	}
	
	//Les evenements visibles par les abonne
	@GetMapping("/even-abonne")
	public String evenPageAbonne(Model model) {
	    List<Evenement> evenements = evenService.getAllEvenements();
	    model.addAttribute("evenements",evenements);
	    return "private/abonne/LesEven";
	}

	////////// Vers la page d'accueil ////////////////
	@GetMapping("/ajout-evenement")
	public String ajoutEven() {
		return "private/evenement/ajoutEven";
	}
	
	
	
	@PostMapping("/evenement-page")
	public String ajouterEvenement(@ModelAttribute Evenement evenement, HttpSession session) {
	    evenService.ajouterEvenement(evenement);
	    // Mise à jour de la liste des événements
	    session.setAttribute("message", "Evènement ajouté !");	    
	   // List<Evenement> evenements = evenService.getAllEvenements();
	  //  model.addAttribute("evenements", evenements);
	    return "private/evenement/evenement";
	}
	
	//Modification d'un évènement
	@GetMapping("/editEven/{id}")
	public String editEvenement(@PathVariable Long id, Model model) {
		
		Evenement evenement = evenService.getEvenementById(id);
		
		model.addAttribute("evenements", evenement);
		
		return "private/evenement/editEven";
	}
	
	@PostMapping("/update-Even")
	public String updateEven(@ModelAttribute Evenement evenement, HttpSession session) {
		
	   // session.setAttribute("message", "Evènement mise à jour !");	    

		evenService.ajouterEvenement(evenement);
		return "redirect:/evenement-page";
	}
	
	//Suppression d'un evenement
	
	@GetMapping("/deleteEven/{id}")
	public String deleteEven(@PathVariable Long id, HttpSession session) {
		
		evenService.deleteEven(id);
		// session.setAttribute("message", "Evénement supprimé avec succès !");	    
		return "redirect:/evenement-page";
		
	}
	
	
	///////////////// POUR UN ABONNE///////////////
	 @GetMapping("/mes-evenements")
	 public String mesEvenements(Model model, Principal principal) {
	    // List<Evenement> mesEvenements = userService.getMesEvenements(principal.getName());
	     //model.addAttribute("mesEvenements", mesEvenements);
	     return "private/abonne/mesEvenements";
	 }

	    @PostMapping("/ajouter-evenement/{evenementId}")
	    public String ajouterEvenAbonne(@PathVariable Long evenementId, Principal principal) {
	        // Implémentez la logique pour ajouter un événement à la liste de l'abonné
	       // userService.ajouterEvenAbonne(principal.getName(), evenementId);
	        return "redirect:/mes-evenements";
	    }
}