package com.admin_user.controller.privates;

import java.security.Principal;
import java.util.List;  // Importez la classe List

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;  // Importez la classe PathVariable

import com.admin_user.model.Evenement;  // Importez la classe Evenement
import com.admin_user.service.UserService;  // Importez la classe UserService

@Controller
public class AbonneController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;  // Injection de dépendance pour le service UserService

    @GetMapping("abonne-page")
    public String userPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("abonne", userDetails);
        return "private/abonne/index";
    }
/*
    @GetMapping("/mes-evenements")
    public String mesEvenements(Model model, Principal principal) {
        List<Evenement> mesEvenements = userService.getMesEvenements(principal.getName());
        model.addAttribute("mesEvenements", mesEvenements);
        return "private/abonne/mesEvenements";
    }

    @PostMapping("/ajouter-evenement/{evenementId}")
    public String ajouterEvenement(@PathVariable Long evenementId, Principal principal) {
        // Implémentez la logique pour ajouter un événement à la liste de l'abonné
        userService.ajouterEvenementAbonne(principal.getName(), evenementId);
        return "redirect:/mes-evenements";
    }*/
}
