package com.admin_user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin_user.model.Evenement;
import com.admin_user.model.User;

public interface EvenRepository extends JpaRepository<Evenement, Long> {
    List<Evenement> findByPromoteur(User promoteur);
}
