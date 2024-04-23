package com.gestion.tournoi;

import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class Personne {
	private String nomNaissance;
	private String nomCourant;
	private String prenom;
	private String surnom;
	private Date dateNaissance;
	private String lieuNaissance;
	private Date dateDeces;
	private String nationalite;
	private int taille;
	private int poids;
	private String genre;
	
	public Personne() {
		super();
	}

	public Personne(String nomNaissance, String prenom, String surnom, Date dateNaissance, String lieuNaissance,
			 String nationalite, int taille, int poids, String genre) {
		this.nomNaissance = nomNaissance;
		this.prenom = prenom;
		this.surnom = surnom;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.nationalite = nationalite;
		this.taille = taille;
		this.poids = poids;
		this.genre = genre;
	}

	public Personne(String nomNaissance, String nomCourant, String prenom, String surnom, Date dateNaissance,
			String lieuNaissance, String nationalite, int taille, int poids, String genre) {
		this.nomNaissance = nomNaissance;
		this.nomCourant = nomCourant;
		this.prenom = prenom;
		this.surnom = surnom;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.nationalite = nationalite;
		this.taille = taille;
		this.poids = poids;
		this.genre = genre;
	}

	public String getNomNaissance() {
		return nomNaissance;
	}

	public String getNomCourant() {
		return nomCourant;
	}

	public void setNomCourant(String nomCourant) {
		this.nomCourant = nomCourant;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSurnom() {
		return surnom;
	}

	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public Date getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(Date dateDeces) {
		this.dateDeces = dateDeces;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public String getGenre() {
		return genre;
	}
	
	
	public int getAge() {
		LocalDate  	dateNaissance = this.convertToLocalDateViaInstant(this.dateNaissance);
		LocalDate	dateDeces;
		LocalDate	currentDate = LocalDate.now();
		if(this.dateDeces != null) {
			dateDeces = this.convertToLocalDateViaInstant(this.dateDeces);
			return Period.between(dateNaissance, dateDeces).getYears();
		}
		else {
			return Period.between(dateNaissance, currentDate).getYears();
		}
	}
	
	private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
}
