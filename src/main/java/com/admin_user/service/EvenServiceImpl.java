/*/ EvenServiceImpl.java
package com.admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin_user.model.Evenement;
import com.admin_user.model.User;
import com.admin_user.repositories.EvenRepository;

@Service
public class EvenServiceImpl implements EvenService {

    @Autowired
    private EvenRepository evenRepository;

    @Override
    public Evenement ajouterEvenement(Evenement evenement) {
        return evenRepository.save(evenement);
    }

    @Override
    public List<Evenement> getAllEvenements() {
        return evenRepository.findAll();
    }

    @Override
    public Evenement getEvenementById(Long id) {
        return evenRepository.findById(id).orElse(null);
    }

    @Override
    public List<Evenement> getEvenementsByPromoteur(User promoteur) {
        return evenRepository.findByPromoteur(promoteur);
    }

    @Override
    public void deleteEven(Long id) {
        evenRepository.deleteById(id);
    }
}*/
