package com.admin_user.model;

import jakarta.persistence.Entity;

@Entity
@Table(name = evenement)
public class Evenement {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;


}
