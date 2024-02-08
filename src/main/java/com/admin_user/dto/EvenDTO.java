package com.admin_user.dto;

import java.util.Date;

public class EvenDTO {
	
	private String intitule;
	private Date dateDebut;
	private Date dateFin;
	private String lieu;
	public EvenDTO(String intitule, Date dateDebut, Date dateFin, String lieu) {
		super();
		this.intitule = intitule;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.lieu = lieu;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
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
}
