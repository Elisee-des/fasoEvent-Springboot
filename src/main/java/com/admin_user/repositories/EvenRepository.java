package com.admin_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin_user.model.Evenement;

public interface EvenRepository extends JpaRepository<Evenement, Long>{
	

}
