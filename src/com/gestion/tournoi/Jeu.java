package com.gestion.tournoi;

public class Jeu {
	protected int numeroJeu;
	protected Set set;
	protected Joueur joueur1;
	protected Joueur joueur2;
	protected Joueur joueurAvecService;
	protected String pointJoueur1;
	protected String pointJoueur2;
	protected Joueur vainqueur;
	private Boolean JeuEstFini;

	/**
	 * Constructeur sans parameters
	 */
	public Jeu() {
		super();
	}

	/**
	 * Constructeur avec parameters
	 * 
	 * @param joueur1
	 * @param joueur2
	 * @param set
	 * @param numeroJeu
	 */
	public Jeu(Joueur joueur1, Joueur joueur2, Set set, int numeroJeu) {
		super();
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.joueurAvecService = joueur1;
		this.pointJoueur1 = "0";
		this.pointJoueur2 = "0";
		this.JeuEstFini = false;
		this.set = set;
		this.numeroJeu = numeroJeu;
	}

	/**
	 * Fonction qui permet de lancer un jeu
	 * 
	 * @param joueurAvecService
	 * @param adversaire
	 * @param Auto
	 * @param afficherDetails
	 */
	public void gererJeu(Joueur joueurAvecService, Joueur adversaire, Boolean Auto, Boolean afficherDetails) {
		if (afficherDetails) {
			System.out.println("****** debut du jeu " + numeroJeu + " :" + joueur1.getNomNaissance() + " vs "
					+ joueur2.getNomNaissance() + "******");
		}
		String resultatEchange = "";
		Joueur j = joueurAvecService;
		Joueur joueurActual = joueurAvecService;
		Joueur joueurAdversaire = adversaire;
		Boolean secondService = true;

		do {
			resultatEchange = lancerNewEchange(joueurActual, secondService, Auto, afficherDetails);
			if (resultatEchange.equals("faute")) {
				point(joueurAdversaire, joueurActual);
				joueurActual = joueurAvecService;
				joueurAdversaire = adversaire;
				secondService = true;
				if (afficherDetails) {
					this.set.match.arbitre.annoncerScoreJeu(this);
				}
			} else if (resultatEchange.equals("correct")) {
				j = joueurAdversaire;
				joueurAdversaire = joueurActual;
				joueurActual = j;
				secondService = false;
			}
		} while (!JeuEstFini);
		if (afficherDetails) {
			System.out.println(
					"****** fin du jeu : " + joueur1.getNomNaissance() + " vs " + joueur2.getNomNaissance() + "******");
		}
	}

	/**
	 * Fonction qui permet de lancer un nouveau échange
	 * 
	 * @param joueur
	 * @param droitSecondService
	 * @param Auto
	 * @param afficherDetails
	 * @return
	 */
	public String lancerNewEchange(Joueur joueur, Boolean droitSecondService, Boolean Auto, Boolean afficherDetails) {
		Echange echange = new Echange(joueur, droitSecondService);
		String resultat = "";
		if (Auto) {
			resultat = echange.lancerEchangeAuto(afficherDetails);
		} else {
			resultat = echange.lancerEchange(afficherDetails);
		}
		return resultat;
	}

	public Joueur getVainqueur() {
		return vainqueur;
	}

	public void setVainqueur(Joueur vainqueur) {
		this.vainqueur = vainqueur;
	}

	/**
	 * Fonction qui permet de calculer les nouveaux points des joueurs selon le
	 * résultat d'échange et de positionner le vainqueur si le jeu est terminé
	 * 
	 * @param gagnant
	 * @param perdant
	 */
	public void point(Joueur gagnant, Joueur perdant) {

		String nouveauPointGagnant = "";
		String nouveauPointPerdant = "";

		if (gagnant.getNomNaissance().equals(joueur1.getNomNaissance())) {
			nouveauPointGagnant = this.pointJoueur1;
			nouveauPointPerdant = this.pointJoueur2;
		} else {
			nouveauPointGagnant = this.pointJoueur2;
			nouveauPointPerdant = this.pointJoueur1;
		}

		if (nouveauPointGagnant.equals("0")) {
			nouveauPointGagnant = "15";
		} else if (nouveauPointGagnant.equals("15")) {
			nouveauPointGagnant = "30";
		} else if (nouveauPointGagnant.equals("30")) {
			nouveauPointGagnant = "40";
		} else if (nouveauPointGagnant.equals("40")) {
			if (nouveauPointPerdant.equals("40")) {
				nouveauPointGagnant = "AV";
			} else if (pointJoueur2.equals("AV")) {
				nouveauPointPerdant = "40";
			} else {
				this.JeuEstFini = true;
			}
		} else if (nouveauPointGagnant.equals("AV")) {
			this.JeuEstFini = true;
		}

		if (gagnant.getNomNaissance().equals(joueur1.getNomNaissance())) {
			this.pointJoueur1 = nouveauPointGagnant;
			this.pointJoueur2 = nouveauPointPerdant;
		} else {
			this.pointJoueur2 = nouveauPointGagnant;
			this.pointJoueur1 = nouveauPointPerdant;
		}

		if (JeuEstFini) {
			setVainqueur(gagnant);
		}
	}

	/**
	 * Fonction qui permet de mettre à jour les points des joueurs
	 * 
	 * @param gagnantPoint
	 * @param perdantPoint
	 */
	public void updatePoint(String gagnantPoint, String perdantPoint) {

		if (gagnantPoint.equals("0")) {
			gagnantPoint = "15";
		} else if (gagnantPoint.equals("15")) {
			gagnantPoint = "30";
		} else if (gagnantPoint.equals("30")) {
			gagnantPoint = "40";
		} else if (gagnantPoint.equals("40")) {
			if (perdantPoint.equals("40")) {
				gagnantPoint = "AV";
			} else if (pointJoueur2.equals("AV")) {
				perdantPoint = "40";
			} else {
				this.JeuEstFini = true;
			}
		} else if (gagnantPoint.equals("AV")) {
			this.JeuEstFini = true;
		}

	}

}
