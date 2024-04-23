package com.gestion.tournoi;

import java.util.Date;

public class Spectateur extends Personne {

	private String billet;
	private String place;

	public Spectateur(String nomNaissance, String prenom, String surnom, Date dateNaissance, String lieuNaissance,
			String nationalite, int taille, int poids, String genre, String tribune, int numero, String billet) {
		super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids, genre);
		this.place = tribune + numero;
		this.billet = billet;
	}

	public Spectateur(String nomNaissance, String nomCourant, String prenom, String surnom, Date dateNaissance,
			String lieuNaissance, String nationalite, int taille, int poids, String genre,
			String tribune, int numero, String billet) {
		super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille,
				poids, genre);
		this.billet = billet;
		this.place = tribune + numero;
	}

	public String getPlace() {
		return place;
	}

	public String getBillet() {
		return billet;
	}

	public void applaudir() {
		System.out.println("Bravo Bravo");
	}

	public void crier() {
		System.out.println("Allez Allez");
	}

	public void huer() {
		System.out.println("huée huée");
	}

	public void dormir() {
		System.out.println("Zzzzzzzz");
	}
}
