package com.gestion.tournoi;

import java.util.Date;

public class Joueur extends Personne {

	private String main;
	private String sponsor;
	private int classement;
	private String entraineur;

	/**
	 * Constructeur sans parameters
	 */
	public Joueur() {
		super();
	}

	/**
	 * Constructeur avec parameter sans nomCourant
	 * 
	 * @param nomNaissance
	 * @param prenom
	 * @param surnom
	 * @param dateNaissance
	 * @param lieuNaissance
	 * @param nationalite
	 * @param taille
	 * @param poids
	 * @param genre
	 * @param main
	 * @param sponsor
	 * @param classement
	 * @param entraineur
	 */
	public Joueur(String nomNaissance, String prenom, String surnom, Date dateNaissance, String lieuNaissance,
			String nationalite, int taille, int poids, String genre, String main, String sponsor, int classement,
			String entraineur) {
		super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids, genre);
		this.main = main;
		this.sponsor = sponsor;
		this.classement = classement;
		this.entraineur = entraineur;
	}

	/**
	 * Constructeur avec parameters
	 * 
	 * @param nomNaissance
	 * @param nomCourant
	 * @param prenom
	 * @param surnom
	 * @param dateNaissance
	 * @param lieuNaissance
	 * @param nationalite
	 * @param taille
	 * @param poids
	 * @param genre
	 * @param main
	 * @param sponsor
	 * @param classement
	 * @param entraineur
	 */
	public Joueur(String nomNaissance, String nomCourant, String prenom, String surnom, Date dateNaissance,
			String lieuNaissance, String nationalite, int taille, int poids, String genre, String main, String sponsor,
			int classement, String entraineur) {
		super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids,
				genre);
		this.main = main;
		this.sponsor = sponsor;
		this.classement = classement;
		this.entraineur = entraineur;
	}

	public String getMain() {
		return main;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public int getClassement() {
		return classement;
	}

	public void setClassement(int classement) {
		this.classement = classement;
	}

	public String getEntraineur() {
		return entraineur;
	}

	public void setEntraineur(String entraineur) {
		this.entraineur = entraineur;
	}

	/**
	 * Fonction qui permet de notifier l'assemblé du changement de la couleur du
	 * tenue
	 * 
	 * @param couleur
	 */
	public void notifierAssemble(String couleur) {
		if (this.getGenre().equals("femme")) {
			System.out.println("J'ai changé la couleur de ma jupe à " + couleur);
		} else if (this.getGenre().equals("homme")) {
			System.out.println("J'ai changé la couleur de mon short à " + couleur);
		}
	}

	/**
	 * fonction qui permet de servir
	 * 
	 * @param afficherDetail
	 * @return
	 */
	public String servir(Boolean afficherDetail) {
		Echange echange = new Echange(this, true);
		return echange.lancerEchange(afficherDetail);
	}

	/**
	 * Fonction qui permet de retourner un service
	 * 
	 * @param afficherDetail
	 * @return
	 */
	public String retournerService(Boolean afficherDetail) {
		String resultat = "";
		Echange echange = new Echange(this, false);
		resultat = echange.lancerEchange(afficherDetail);
		if (resultat.equals("correct")) {
			resultat = "retour";
		}
		return resultat;
	}

	/**
	 * Fonction qui permet de renvoyer le service
	 * 
	 * @param afficherDetail
	 * @return
	 */
	public String renvoyerService(Boolean afficherDetail) {
		Echange echange = new Echange(this, false);
		return echange.lancerEchange(afficherDetail);
	}

	/**
	 * Fonction qui permet le joueur de boire
	 */
	public void boire() {
		System.out.println("gr gr gr.... il fait chaud !!!");
	}

	/**
	 * Fonction qui permet le joueur de s'encourager
	 */
	public void sEncourager() {
		System.out.println("Allez courage!!");
	}

	/**
	 * Appeler l'arbitre
	 */
	public void appelerArbitre() {

	}

	/**
	 * Fonction pour crier victoire
	 */
	public void crierVictoire() {
		System.out.println("Wéééééééééééé ^_^");
	}

	/**
	 * Fonction pour crier defaite
	 */
	public void crierDefaite() {
		System.out.println("Ohhhhhh non :'( dommage la prochaine fois");
	}

}
