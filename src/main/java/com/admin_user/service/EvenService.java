package com.admin_user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin_user.model.Evenement;
import com.admin_user.model.User; 
import com.admin_user.repositories.EvenRepository;

@Service
public class EvenService {

    @Autowired
    private EvenRepository evenRepository;

    public Evenement ajouterEvenement(Evenement evenement,User promoteur) {
        evenement.setPromoteur(promoteur);
    	return evenRepository.save(evenement);
    }

    public List<Evenement> getAllEvenements() {
        return evenRepository.findAll();
    }
    
    // Pour modifier un evenement
    public Evenement getEvenementById(Long id) {
        Optional<Evenement> evenement = evenRepository.findById(id);
        
        if (evenement.isPresent()) {
            return evenement.get();
        }
        return null;
    }
    
    // Pour récupérer les événements par promoteur
    public List<Evenement> getEvenementsByPromoteur(User promoteur) {
        return evenRepository.findByPromoteur(promoteur);
    }
    
    public void deleteEven(Long id) {
        evenRepository.deleteById(id);
    }
    
    //Mise a jour d'evenement
    public void updateEvenement(Evenement evenement) {
        evenRepository.save(evenement);
    }
    
    

}
