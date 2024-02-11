package com.admin_user.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "evenement")
public class Evenement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String intitule;
	private String categorie;
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private String dateDebut;

	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private String dateFin;

	private String lieu;
	
	@ManyToOne
	@JoinColumn(name = "promoteur_id")
	private User promoteur;
	
	public Evenement() {
		super();
	}

	public Evenement(String intitule, String categorie, String dateDebut, String dateFin, String lieu, User promoteur) {
		this.intitule = intitule;
		this.categorie = categorie;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.lieu = lieu;
		this.promoteur = promoteur;
	}

	// Getters et Setters

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomPromoteur() {
        if (promoteur != null) {
            return promoteur.getFullname();
        }
        return "Promoteur inconnu";
    }

	public User getPromoteur() {
		return promoteur;
	}

	public void setPromoteur(User promoteur) {
		this.promoteur = promoteur;
	}
}
