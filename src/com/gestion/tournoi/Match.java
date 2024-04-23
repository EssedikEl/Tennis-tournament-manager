package com.gestion.tournoi;

public class Match {
	protected Tournoi tournoi;
	private Joueur joueur1;
	private Joueur joueur2;
	protected int nbrSetJoueur1;
	protected int nbrSetJoueur2;
	protected Arbitre arbitre;
	private Joueur vainqueur;
	private Joueur perdant;
	private Categorie categorie;
	private Niveau niveau;
	private final static int NOMBRE_SET_FEMME = 2;
	private final static int NOMBRE_SET_HOMME = 3;
	private Boolean MatchEstFini;

	/**
	 * Constructeur sans parameters
	 */
	public Match() {

	}

	/**
	 * Constructeur avec parameters de la classe Match
	 * 
	 * @param joueur1
	 * @param joueur2
	 * @param arbitre
	 * @param categorie
	 * @param niveau
	 * @param tournoi
	 */
	public Match(Joueur joueur1, Joueur joueur2, Arbitre arbitre, Categorie categorie, Niveau niveau, Tournoi tournoi) {

		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.arbitre = arbitre;
		this.categorie = categorie;
		this.niveau = niveau;
		this.nbrSetJoueur1 = 0;
		this.nbrSetJoueur2 = 0;
		this.MatchEstFini = false;
		this.tournoi = tournoi;
	}

	public Arbitre getArbitre() {
		return arbitre;
	}

	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}

	public Joueur getVainqueur() {
		return vainqueur;
	}

	public void setVainqueur(Joueur vainqueur) {
		this.vainqueur = vainqueur;
	}

	public Joueur getPerdant() {
		return perdant;
	}

	public void setPerdant(Joueur perdant) {
		this.perdant = perdant;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur) {
		this.joueur1 = joueur;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur) {
		this.joueur2 = joueur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public int getNbrSetJoueur1() {
		return nbrSetJoueur1;
	}

	public void setNbrSetJoueur1(int nbrSetJoueur1) {
		this.nbrSetJoueur1 = nbrSetJoueur1;
	}

	public int getNbrSetJoueur2() {
		return nbrSetJoueur2;
	}

	public void setNbrSetJoueur2(int nbrSetJoueur2) {
		this.nbrSetJoueur2 = nbrSetJoueur2;
	}

	public Boolean getMatchEstFini() {
		return MatchEstFini;
	}

	public void setMatchEstFini(Boolean matchEstFini) {
		MatchEstFini = matchEstFini;
	}

	/**
	 * fonction qui permet de lancer un match
	 */
	public void LancerMatch(Boolean Auto, Boolean afficherDetails) {
		int i = 0;

		System.out.println(
				"****** debut du match :" + joueur1.getNomNaissance() + " vs " + joueur2.getNomNaissance() + "******");
		if (categorie.getDescription().equals("simple femme")) {
			while (nbrSetJoueur1 < NOMBRE_SET_FEMME && nbrSetJoueur2 < NOMBRE_SET_FEMME) {
				lancerSet(++i, Auto, afficherDetails);
			}
			selectionnerVinqueurByCategory("simple femme");
		} else if (categorie.getDescription().equals("simple homme")) {
			while (nbrSetJoueur1 < NOMBRE_SET_HOMME && nbrSetJoueur2 < NOMBRE_SET_HOMME) {
				lancerSet(++i, Auto, afficherDetails);
			}
			selectionnerVinqueurByCategory("simple homme");
		}
		System.out.println(
				"****** fin du match :" + joueur1.getNomNaissance() + " vs " + joueur2.getNomNaissance() + "******");
	}

	/**
	 * Fonction qui permet de lancer un nouveau Set
	 * 
	 * @param numeroSet
	 * @param Auto
	 * @param afficherDetails
	 */
	private void lancerSet(int numeroSet, Boolean Auto, Boolean afficherDetails) {
		Set set = new Set(this.joueur1, this.joueur2, this, numeroSet);
		set.jouer(Auto, afficherDetails);
		if (set.getVainqueur().equals(joueur1)) {
			this.nbrSetJoueur1++;
		} else {
			this.nbrSetJoueur2++;
		}

		if (afficherDetails) {
			this.arbitre.annoncerScoreMatch(set);
		}
	}

	/**
	 * Fonction qui permet de selectionner le vainqueur par catégorie
	 * 
	 * @param categorie
	 */
	private void selectionnerVinqueurByCategory(String categorie) {
		if (categorie.equals("simple femme")) {
			selectionnerVinqueur(NOMBRE_SET_FEMME);
		} else if (categorie.equals("simple homme")) {
			selectionnerVinqueur(NOMBRE_SET_HOMME);
		}
	}

	/**
	 * Fonction qui permet de selectionner le vainqueur du match
	 * 
	 * @param NbrSetARemporte
	 */
	private void selectionnerVinqueur(int NbrSetARemporte) {
		if (this.nbrSetJoueur1 == NbrSetARemporte) {
			this.vainqueur = joueur1;
		} else {
			this.vainqueur = joueur2;
		}
		if (niveau.equals(Niveau.UNTOUR)) {
			this.tournoi.joueurs2Tour.put(vainqueur, false);
		} else if (niveau.equals(Niveau.DEUXTOUR)) {
			this.tournoi.joueurs3Tour.put(vainqueur, false);
		} else if (niveau.equals(Niveau.TROISTOUR)) {
			this.tournoi.joueursHuitFinal.put(vainqueur, false);
		} else if (niveau.equals(Niveau.HUITFINAL)) {
			this.tournoi.joueursQuartFinal.put(vainqueur, false);
		} else if (niveau.equals(Niveau.QUARTFINAL)) {
			this.tournoi.joueursDemiFinal.put(vainqueur, false);
		} else if (niveau.equals(Niveau.DEMIFINALE)) {
			this.tournoi.finalistes.add(vainqueur);
		}
		System.out
				.println("--> le gagnant du match est : " + vainqueur.getNomNaissance() + " " + vainqueur.getPrenom());
	}

}
