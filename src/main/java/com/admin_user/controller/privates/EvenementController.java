package com.admin_user.controller.privates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EvenementController {
	
	@GetMapping("/evenement-page")
    public String evenementPage() {
        return "private/evenement/evenement"; // Le nom du fichier HTML sans l'extension
    }
	
	////////// Vers la page d'accueil ////////////////
	@GetMapping("/ajout-evenement")
	public String ajoutEven() {
		return "private/evenement/ajoutEven";
	}
	

}
