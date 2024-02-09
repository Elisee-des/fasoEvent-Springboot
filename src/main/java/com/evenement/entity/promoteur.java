package com.evenement.entity;

public class promoteur {
	private int id;
	private String nom;
	private String adresse;
	private String email;
	private String telephone;
	private int salaire;
	
	@Override
	public String toString() {
		return "promoteur [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", email=" + email + ", telephone="
				+ telephone + ", salaire=" + salaire + "]";
	}

	public promoteur(int id, String nom, String adresse, String email, String telephone, int salaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.salaire = salaire;
	}
	

}
