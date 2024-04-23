package com.gestion.tournoi;

public class Set {
	protected int numeroSet;
	protected Joueur joueur1;
	protected Joueur joueur2;
	protected int scoreJoueur1 = 0;
	protected int scoreJoueur2 = 0;
	protected Joueur vainqueur;
	protected Match match;
	private final static int MAX_NOMBRE_JEU = 6;

	/**
	 * Constructeur sans parameters
	 */
	public Set() {
		super();
	}

	/**
	 * Constructeur avec Parameters
	 * 
	 * @param joueur1
	 * @param joueur2
	 * @param match
	 * @param numeroSet
	 */
	public Set(Joueur joueur1, Joueur joueur2, Match match, int numeroSet) {
		super();
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.match = match;
		this.numeroSet = numeroSet;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public int getScoreJoueur1() {
		return scoreJoueur1;
	}

	public void setScoreJoueur1(int scoreJoueur1) {
		this.scoreJoueur1 = scoreJoueur1;
	}

	public int getScoreJoueur2() {
		return scoreJoueur2;
	}

	public void setScoreJoueur2(int scoreJoueur2) {
		this.scoreJoueur2 = scoreJoueur2;
	}

	public Joueur getVainqueur() {
		return vainqueur;
	}

	public void setVainqueur(Joueur vainqueur) {
		this.vainqueur = vainqueur;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public int getNumeroSet() {
		return numeroSet;
	}

	public void setNumeroSet(int numeroSet) {
		this.numeroSet = numeroSet;
	}

	/**
	 * Fonction pour lancer le Set
	 * 
	 * @param Auto
	 * @param afficherDetails
	 * @return
	 */
	public Joueur jouer(Boolean Auto, Boolean afficherDetails) {
		int numeroJeu = 1;
		if (afficherDetails) {
			System.out.println("****** debut du set " + this.numeroSet + " : " + joueur1.getNomNaissance() + " vs "
					+ joueur2.getNomNaissance() + "******");
		}
		Joueur joueurAcService = joueur1;
		Joueur adversaire = joueur2;
		Joueur j = joueur1;
		while (this.scoreJoueur1 < MAX_NOMBRE_JEU && this.scoreJoueur2 < MAX_NOMBRE_JEU) {
			lancerJeu(joueurAcService, adversaire, numeroJeu++, Auto, afficherDetails);
			j = adversaire;
			adversaire = joueurAcService;
			joueurAcService = j;
		}
		int diffScore = Math.max(scoreJoueur1, scoreJoueur2) - Math.min(scoreJoueur1, scoreJoueur2);
		if (diffScore == 1) {
			while (diffScore == 1) {
				lancerJeu(joueurAcService, adversaire, numeroJeu++, Auto, afficherDetails);
				diffScore = Math.max(scoreJoueur1, scoreJoueur2) - Math.min(scoreJoueur1, scoreJoueur2);
				j = adversaire;
				adversaire = joueurAcService;
				joueurAcService = j;
			}
			selectionnerVinqueur();
		} else {
			selectionnerVinqueur();
		}
		if (afficherDetails) {
			System.out.println(
					"****** fin du set : " + joueur1.getNomNaissance() + " vs " + joueur2.getNomNaissance() + "******");
		}
		return this.vainqueur;
	}

	/**
	 * Fonction pour lancer un nouveau Jeu
	 * 
	 * @param joueurAvecService
	 * @param adversaire
	 * @param numeroJeu
	 * @param Auto
	 * @param afficherDetails
	 */
	private void lancerJeu(Joueur joueurAvecService, Joueur adversaire, int numeroJeu, Boolean Auto,
			Boolean afficherDetails) {
		Jeu jeu = new Jeu(joueurAvecService, adversaire, this, numeroJeu);
		jeu.gererJeu(joueurAvecService, adversaire, Auto, afficherDetails);
		if (jeu.getVainqueur().equals(joueur1)) {
			this.scoreJoueur1++;
		} else {
			this.scoreJoueur2++;
		}
		if (afficherDetails) {
			this.match.arbitre.annoncerScoreSet(jeu);
		}
	}

	/**
	 * Fonction qui permet de positionner le vainqueur du Set
	 */
	private void selectionnerVinqueur() {
		if (this.scoreJoueur1 > this.scoreJoueur2) {
			this.vainqueur = joueur1;
		} else {
			this.vainqueur = joueur2;
		}
	}
}
