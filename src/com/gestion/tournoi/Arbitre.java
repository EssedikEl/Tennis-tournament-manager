package com.gestion.tournoi;

import java.util.Date;

public class Arbitre extends Personne {
	
	public Arbitre(String nomNaissance, String prenom, String surnom, Date dateNaissance, String lieuNaissance,
			String nationalite, int taille, int poids, String genre) {
		super(nomNaissance, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids, genre);
	}

	public Arbitre(String nomNaissance, String nomCourant, String prenom, String surnom, Date dateNaissance,
			String lieuNaissance,  String nationalite, int taille, int poids, String genre) {
		super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, nationalite, taille, poids,
				genre);
	}
	
	public void annoncerScoreJeu (Jeu jeu) {
		System.out.println("--- resultats d'échange : ---");
		if(jeu.joueurAvecService.equals(jeu.joueur1)) {
			System.out.println("**** le score est : "+ jeu.pointJoueur1 +" : "+jeu.pointJoueur2);
		}else {
			System.out.println("**** le score est : "+ jeu.pointJoueur2 +" : "+jeu.pointJoueur1);
		}
	}
	
	public void annoncerScoreSet (Jeu jeu) {
		System.out.println("--- resultats du jeu : ---");
		System.out.println("--- le gagnant est : " + jeu.getVainqueur().getNomNaissance()+ " ---");
		System.out.println("**** le score du set est : "+ jeu.set.scoreJoueur1 +" vs "+jeu.set.scoreJoueur2);
		
	}
	
	public void annoncerScoreMatch (Set set) {
		System.out.println("--- resultats du set : ---");
		System.out.println("--- le gagnant est : " + set.getVainqueur().getNomNaissance()+" ---");
		System.out.println("**** le score du match est : "+ set.match.nbrSetJoueur1 +" sets vs "+set.match.nbrSetJoueur2 +" sets");
		
	}
	
	public void annoncerFaute() {
			System.out.println("Faute");
	}
	
	public String repondreLitigeArbitrage() {
		return null;
	}

	
	


}
