package com.admin_user.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "evenement")
public class Evenement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String intitule;
	private String categorie;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDebut;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFin;

	private String lieu;
	
	
	public Evenement() {
		super();
	}


	public Evenement(String intitule, String categorie, Date dateDebut, Date dateFin, String lieu) {
		this.intitule = intitule;
		this.categorie = categorie;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.lieu = lieu;
	}
	
	
	//Getters et Setters
	
	
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
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
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
}