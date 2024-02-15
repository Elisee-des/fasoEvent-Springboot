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
import org.springframework.web.bind.annotation.RequestParam;

import com.admin_user.model.Evenement;
import com.admin_user.model.User;
import com.admin_user.repositories.UserRepository;
import com.admin_user.service.EvenService;
import com.admin_user.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EvenementController {
	
	@Autowired
	EvenService evenService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	//Acceder a la page de la liste des evenements
	/*@GetMapping("/evenement-page")
	public String evenementPage(Model model) {
	    List<Evenement> evenements = evenService.getAllEvenements();
	    model.addAttribute("evenements",evenements);
	    return "private/evenement/evenement";
	}*/
	
	@GetMapping("/evenement-page")
	public String evenementPage(Model model, Principal principal) {
	    String emailPromoteurConnecte = principal.getName();
	    User promoteurConnecte = userRepository.findByEmail(emailPromoteurConnecte);
	    List<Evenement> evenements = evenService.getEvenementsByPromoteur(promoteurConnecte);
	    model.addAttribute("evenements", evenements);
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
	public String ajouterEvenement(@ModelAttribute Evenement evenement, Model model, Principal principal) {
	    String emailPromoteurConnecte = principal.getName();
	    User promoteurConnecte = userRepository.findByEmail(emailPromoteurConnecte);
	    evenService.ajouterEvenement(evenement, promoteurConnecte);
	    model.addAttribute("message", "Evénement ajouté !");
	    return "redirect:/evenement-page";
	}
	
	
	
	/*@PostMapping("/evenement-page")
	public String ajouterEvenement(@ModelAttribute Evenement evenement, HttpSession session) {
	    evenService.ajouterEvenement(evenement);
	    // Mise à jour de la liste des événements
	    session.setAttribute("message", "Evènement ajouté !");	    
	   // List<Evenement> evenements = evenService.getAllEvenements();
	  //  model.addAttribute("evenements", evenements);
	    return "private/evenement/evenement";
	}*/
	
	//Modification d'un évènement
	@GetMapping("/editEven/{id}")
	public String editEvenement(@PathVariable Long id, Model model) {
		
		Evenement evenement = evenService.getEvenementById(id);
		
		model.addAttribute("evenements", evenement);
		
		return "private/evenement/editEven";
	}
	
	@PostMapping("/update-Even")
	public String updateEven(@ModelAttribute Evenement evenement, HttpSession session) {
	    evenService.updateEvenement(evenement); 
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
	@PostMapping("/ajouter-evenement")
	public String ajouterEvenementParAbonne(@RequestParam Long evenementId, Principal principal) {
	    String emailAbonneConnecte = principal.getName();
	    User abonneConnecte = userRepository.findByEmail(emailAbonneConnecte);
	    Evenement evenement = evenService.getEvenementById(evenementId);
	  //  evenService.ajouterEvenementAbonne(abonneConnecte, evenement);
	    return "redirect:/evenement-page";
	}

	
/*
	@PostMapping("/ajouter-evenement")
	public String ajouterEvenement(@RequestParam Long evenementId, Principal principal) {
	    // Récupérer l'abonné connecté
	    String emailAbonneConnecte = principal.getName();
	    User abonneConnecte = userRepository.findByEmail(emailAbonneConnecte);

	    // Récupérer l'événement à ajouter à la liste de l'abonné
	    Evenement evenement = evenService.getEvenementById(evenementId);

	    // Ajouter l'événement à la liste de l'abonné
	    userService.ajouterEvenementListe(abonneConnecte, evenement);

	    // Rediriger vers la page des événements après l'ajout
	    return "redirect:/evenement-page";
	}*/

}