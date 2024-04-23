package com.gestion.tournoi;

import java.util.Scanner;

public class Echange {

	private Joueur joueurActual;
	private Boolean secondService;
	private Scanner entree = new Scanner(System.in);

	/**
	 * Constructeur avec parameters
	 * @param joueur
	 * @param secondSercive
	 */
	public Echange(Joueur joueur, Boolean secondSercive) {
		this.joueurActual = joueur;
		this.secondService = secondSercive;
	}

	public Joueur getJoueurActual() {
		return joueurActual;
	}

	public void setJoueurActual(Joueur joueurActual) {
		this.joueurActual = joueurActual;
	}

	public Boolean getSecondService() {
		return secondService;
	}

	public void setSecondService(Boolean secondService) {
		this.secondService = secondService;
	}

	/**
	 * Lancer un échange manuellement
	 * @param afficherDetails
	 * @return
	 */
	public String lancerEchange(Boolean afficherDetails) {
		String evenement = "";
		String resultat = "";
		if(afficherDetails) {
			System.out.println("****** debut de l'échange : " + joueurActual.getNomNaissance() + "******");
			System.out.println("faute || filet || correct");
		}
		do {
			evenement = entree.nextLine();
		} while (!evenement.equals("faute") && !evenement.equals("filet") && !evenement.equals("correct"));

		if (evenement.equals("faute")) {
			if (secondService) {
				setSecondService(false);
				if(afficherDetails) {
					System.out.println("Second service");
				}
				resultat = lancerEchange(afficherDetails);
			} else {
				resultat = "faute";
			}
		} else if (evenement.equals("filet")) {
			resultat = lancerEchange(afficherDetails);
		} else if (evenement.equals("correct")) {
			resultat = "correct";
		} 
		return resultat;
	}

	/**
	 * Lancer un échange automatiquement
	 * @param afficherDetails
	 * @return
	 */
	public String lancerEchangeAuto(Boolean afficherDetails) {
		String evenement = "";
		String resultat = "";
		if(afficherDetails) {
			System.out.println("****** debut de l'échange : " + joueurActual.getNomNaissance() + "******");
			System.out.println("faute || filet || correct");
		}
		int b = (int) (Math.random() * 3 + 1);
		switch (b) {
		case 1:
			evenement = "correct";
			break;
		case 2:
			evenement = "filet";
			break;
		case 3:
			evenement = "faute";
			break;
		}
		if(afficherDetails) {
		System.out.println("-----> " + evenement);
		}
		if (evenement.equals("faute")) {
			if (secondService) {
				setSecondService(false);
				if(afficherDetails) {
				System.out.println("Second service");
				}
				resultat = lancerEchangeAuto(afficherDetails);
			} else {
				resultat = "faute";
			}
		} else if (evenement.equals("filet")) {
			resultat = lancerEchangeAuto(afficherDetails);
		} else if (evenement.equals("correct")) {
			resultat = "correct";
		} 
		return resultat;
	}
}
