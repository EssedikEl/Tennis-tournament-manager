package com.gestion.tournoi;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Tournoi {

	private Ville ville;
	private int annee;
	protected Map<Joueur, Boolean> joueursQualifies;
	protected Map<Joueur, Boolean> joueurs2Tour;
	protected Map<Joueur, Boolean> joueurs3Tour;
	protected Map<Joueur, Boolean> joueursHuitFinal;
	protected Map<Joueur, Boolean> joueursQuartFinal;
	protected Map<Joueur, Boolean> joueursDemiFinal;
	protected ArrayList<Joueur> finalistes;
	private ArrayList<Arbitre> arbitres;
	protected ArrayList<Match> Matchs;

	/**
	 * Constructeur sans parameter de la Classe Tournoi
	 */
	public Tournoi() {
		super();
	}

	/**
	 * Constructeur avec parameter de la Classe Tournoi
	 * 
	 * @param ville
	 * @param annee
	 */
	public Tournoi(Ville ville, int annee) {
		super();
		this.ville = ville;
		this.annee = annee;
		joueursQualifies = new HashMap<Joueur, Boolean>();
		joueurs2Tour = new HashMap<Joueur, Boolean>();
		joueurs3Tour = new HashMap<Joueur, Boolean>();
		joueursHuitFinal = new HashMap<Joueur, Boolean>();
		joueursQuartFinal = new HashMap<Joueur, Boolean>();
		finalistes = new ArrayList<Joueur>();
		joueursDemiFinal = new HashMap<Joueur, Boolean>();
		arbitres = new ArrayList<Arbitre>();
		Matchs = new ArrayList<Match>();
		initialiser();
	}

	private void initialiser() {
		// initialiserListJoueurs();
		initialiserListArbitre();
		// initialiserMatchByNiveau(Niveau.UNTOUR);
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/**
	 * Fonction qui permet de séléctionner un arbitre aléatoire de la liste de
	 * arbitres
	 * 
	 * @return arbitre
	 */
	private Arbitre getRandomArbitreMatch() {
		Random random = new Random();
		int index = random.nextInt(arbitres.size());
		return arbitres.get(index);
	}

	/**
	 * Fonction qui permer d'initialiser la liste des joueurs automatiquement à
	 * partir d'une enumération
	 */
	@SuppressWarnings("deprecation")
	public void initialiserListJoueurs() {
		ArrayList<NameJoueurHomme> nameJoueursQualifiesH = new ArrayList<NameJoueurHomme>();
		NameJoueurHomme joueurNameH;
		ArrayList<NameJoueurFemme> nameJoueursQualifiesF = new ArrayList<NameJoueurFemme>();
		NameJoueurFemme joueurNameF;
		int classement = 1;

		// Initialiser la liste des hommes
		for (int i = 0; i < 128; i++) {
			do {
				joueurNameH = NameJoueurHomme.getRandomJoueurHomme();
			} while (nameJoueursQualifiesH.contains(joueurNameH));
			nameJoueursQualifiesH.add(joueurNameH);
		}

		for (NameJoueurHomme joueurHomme : nameJoueursQualifiesH) {
			joueursQualifies.put(new Joueur(joueurHomme.getNom(), joueurHomme.getPrenom(), null,
					new Date(joueurHomme.getDateNaissance()), joueurHomme.getLieuNaissance(),
					joueurHomme.getNationalite(), joueurHomme.getTaille(), joueurHomme.getPoids(), "homme",
					joueurHomme.getMain(), Sponsor.getRandomSponsor().getDescription(), classement++,
					joueurHomme.getEntraineur()), false);
		}

		// Initialiser la liste des hommes
		classement = 1; // initialiser le classement pour les femmes
		for (int i = 0; i < 128; i++) {
			do {
				joueurNameF = NameJoueurFemme.getRandomJoueurFemme();
			} while (nameJoueursQualifiesF.contains(joueurNameF));
			nameJoueursQualifiesF.add(joueurNameF);
		}

		for (NameJoueurFemme joueurFemme : nameJoueursQualifiesF) {
			joueursQualifies.put(new Joueur(joueurFemme.getNom(), joueurFemme.getPrenom(), joueurFemme.getNomCourant(),
					new Date(joueurFemme.getDateNaissance()), joueurFemme.getLieuNaissance(),
					joueurFemme.getNationalite(), joueurFemme.getTaille(), joueurFemme.getPoids(), "femme",
					joueurFemme.getMain(), Sponsor.getRandomSponsor().getDescription(), classement++,
					joueurFemme.getEntraineur()), false);
		}

	}

	/**
	 * Fonction qui permet d'initialiser la liste des arbitres du tournoi à partir
	 * d'une énumération
	 */
	@SuppressWarnings("deprecation")
	private void initialiserListArbitre() {
		ArrayList<ArbitreName> nameArbitres = new ArrayList<ArbitreName>();
		ArbitreName arbitreName;

		for (int j = 0; j < 15; j++) {
			do {
				arbitreName = ArbitreName.getRandomArbitre();
			} while (nameArbitres.contains(arbitreName));
			nameArbitres.add(arbitreName);
		}

		for (ArbitreName arbitre : nameArbitres) {
			if (arbitre.getNomCourant() != null) {
				arbitres.add(new Arbitre(arbitre.getNom(), arbitre.getNomCourant(), arbitre.getPrenom(), null,
						new Date(arbitre.getDateNaissance()), arbitre.getLieuNaissance(), arbitre.getNationalite(),
						arbitre.getTaille(), arbitre.getPoids(), arbitre.getGenre()));
			} else {
				arbitres.add(new Arbitre(arbitre.getNom(), arbitre.getPrenom(), null,
						new Date(arbitre.getDateNaissance()), arbitre.getLieuNaissance(), arbitre.getNationalite(),
						arbitre.getTaille(), arbitre.getPoids(), arbitre.getGenre()));
			}

		}
	}

	/**
	 * Fonction qui permet de séléctionner un joueur aléatoire by catégorie afin de
	 * l'affecter à un match après
	 * 
	 * @param listJoueur
	 * @param genre
	 * @return Joueur
	 */
	private Joueur getRandomJoueurByCategorie(Map<Joueur, Boolean> listJoueur, String genre) {
		Random random = new Random();
		List<Joueur> Joueurs = new ArrayList<Joueur>(listJoueur.keySet());
		Joueur joueur = new Joueur();
		do {
			joueur = Joueurs.get(random.nextInt(Joueurs.size()));
		} while (listJoueur.get(joueur) || !joueur.getGenre().equals(genre));
		listJoueur.put(joueur, true);
		return joueur;
	}

	/**
	 * initialiser aléatoirement les matchs d'un tour
	 * 
	 * @param niveau
	 */
	public void initialiserMatchByNiveau(Niveau niveau) {

		// initialiser aléatoirement les matchs des hommes
		if (niveau.equals(Niveau.FINALE)) {
			Matchs.add(
					new Match(getListFinalisteByCategorie("homme").get(0), getListFinalisteByCategorie("homme").get(1),
							getRandomArbitreMatch(), Categorie.SIMPLEH, niveau, this));
		} else {
			for (int index = 0; index < getSize(niveau); index++) {
				Matchs.add(new Match(getRandomJoueurByCategorie(getList(niveau), "homme"),
						getRandomJoueurByCategorie(getList(niveau), "homme"), getRandomArbitreMatch(),
						Categorie.SIMPLEH, niveau, this));
			}
		}
		// initialiser aléatoirement les matchs des femmes
		if (niveau.equals(Niveau.FINALE)) {
			Matchs.add(
					new Match(getListFinalisteByCategorie("femme").get(0), getListFinalisteByCategorie("femme").get(1),
							getRandomArbitreMatch(), Categorie.SIMPLEF, niveau, this));
		} else {
			for (int index = 0; index < getSize(niveau); index++) {
				Matchs.add(new Match(getRandomJoueurByCategorie(getList(niveau), "femme"),
						getRandomJoueurByCategorie(getList(niveau), "femme"), getRandomArbitreMatch(),
						Categorie.SIMPLEF, niveau, this));
			}
		}
	}

	/**
	 * fonction qui retourne le nombre de match dans un tour
	 * 
	 * @param niveau
	 * @return
	 */
	private int getSize(Niveau niveau) {
		int size = 0;
		if (niveau.equals(Niveau.UNTOUR)) {
			size = 64;
		} else if (niveau.equals(Niveau.DEUXTOUR)) {
			size = 32;
		} else if (niveau.equals(Niveau.TROISTOUR)) {
			size = 16;
		} else if (niveau.equals(Niveau.HUITFINAL)) {
			size = 8;
		} else if (niveau.equals(Niveau.QUARTFINAL)) {
			size = 4;
		} else if (niveau.equals(Niveau.DEMIFINALE)) {
			size = 2;
		}
		return size;
	}

	/**
	 * fonction qui retourne la liste des joueurs qualifiés pour un tour
	 * 
	 * @param niveau
	 * @return
	 */
	private Map<Joueur, Boolean> getList(Niveau niveau) {
		Map<Joueur, Boolean> listJoueur = new HashMap<Joueur, Boolean>();
		if (niveau.equals(Niveau.UNTOUR)) {
			listJoueur = joueursQualifies;
		} else if (niveau.equals(Niveau.DEUXTOUR)) {
			listJoueur = joueurs2Tour;
		} else if (niveau.equals(Niveau.TROISTOUR)) {
			listJoueur = joueurs3Tour;
		} else if (niveau.equals(Niveau.HUITFINAL)) {
			listJoueur = joueursHuitFinal;
		} else if (niveau.equals(Niveau.QUARTFINAL)) {
			listJoueur = joueursQuartFinal;
		} else if (niveau.equals(Niveau.DEMIFINALE)) {
			listJoueur = joueursDemiFinal;
		}
		return listJoueur;
	}

	/**
	 * fonction qui retourne la liste des finalistes selon la categorie
	 * 
	 * @param genre
	 * @return
	 */
	private ArrayList<Joueur> getListFinalisteByCategorie(String genre) {
		ArrayList<Joueur> finalistesListe = new ArrayList<Joueur>();
		for (Joueur joueur : finalistes) {
			if (joueur.getGenre().equals(genre)) {
				finalistesListe.add(joueur);
			}
		}
		return finalistesListe;
	}

	/**
	 * Fonction qui retourne la liste des matchs par niveau et categorie
	 * 
	 * @param niveau
	 * @param categorie
	 * @return
	 */
	private ArrayList<Match> getMatchByNiveau(Niveau niveau, Categorie categorie) {
		ArrayList<Match> listMatchByNiveau = new ArrayList<Match>();
		for (Match match : Matchs) {
			if (match.getNiveau().equals(niveau) && match.getCategorie().equals(categorie)) {
				listMatchByNiveau.add(match);
			}
		}
		return listMatchByNiveau;
	}

	/**
	 * Fonction qui retourne le niveau suivant
	 * @param niveau
	 * @return
	 */
	private Niveau getNextTour(Niveau niveau) {
		Niveau nextTour = niveau;
		if (niveau.equals(Niveau.UNTOUR)) {
			nextTour = Niveau.DEUXTOUR;
		} else if (niveau.equals(Niveau.DEUXTOUR)) {
			nextTour = Niveau.TROISTOUR;
		} else if (niveau.equals(Niveau.TROISTOUR)) {
			nextTour = Niveau.HUITFINAL;
		} else if (niveau.equals(Niveau.HUITFINAL)) {
			nextTour = Niveau.QUARTFINAL;
		} else if (niveau.equals(Niveau.QUARTFINAL)) {
			nextTour = Niveau.DEMIFINALE;
		} else if (niveau.equals(Niveau.DEMIFINALE)) {
			nextTour = Niveau.FINALE;
		}
		return nextTour;
	}

	/**
	 * Fonction qui permet de lancer le Tournoi
	 * @param sc
	 */
	public void lancerTournoi(Scanner sc) {
		Niveau Tour = Niveau.UNTOUR;
		Boolean isFinished = false;
		String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("DDMMYYYY"));
		String timeStr = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmm"));
		String filePath = "./fileOut/Resultat_Tournoi_" + ville + "_" + annee + "_" + dateStr + "_" + timeStr + ".txt";
		try {
			PrintWriter writer = new PrintWriter(filePath, "UTF-8");
			do {
				isFinished = lancerTour(Tour, Categorie.SIMPLEH, sc);
				if (isFinished) {
					ecrireCompteRenduTour(Tour,Categorie.SIMPLEH,writer);
					isFinished = false;
					isFinished = lancerTour(Tour, Categorie.SIMPLEF, sc);
					if(isFinished) {
						ecrireCompteRenduTour(Tour,Categorie.SIMPLEF,writer);
						isFinished = false;
						Tour = getNextTour(Tour);
						initialiserMatchByNiveau(Tour);
						}
				}
			} while (!Tour.equals(Niveau.FINALE));
		
			isFinished = lancerTour(Tour, Categorie.SIMPLEH, sc);
			if (isFinished) {
				ecrireCompteRenduTour(Tour,Categorie.SIMPLEH,writer);
				isFinished = false;
				isFinished = lancerTour(Tour, Categorie.SIMPLEF, sc);
				ecrireCompteRenduTour(Tour,Categorie.SIMPLEF,writer);
			}
			
			writer.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fonction qui permet de lancer un tour par categorie
	 * @param niveau
	 * @param categorie
	 * @param sc
	 * @return
	 */
	private Boolean lancerTour(Niveau niveau, Categorie categorie, Scanner sc) {
		Boolean isFinished = false;
		Boolean autoFlag = false;
		Boolean detailFlag = false;
		System.out.println(
				"**************************************************************************************************");
		System.out.println(
				"************************************* Catégorie "+categorie.getDescription()+" *************************************");
		System.out.println(
				"**************************************** début du "+niveau.getDescription()+" ***************************************");
		System.out.println(
				"**************************************************************************************************");
		for (Match match : getMatchByNiveau(niveau, categorie)) {
			System.out.println(
					"**************************************************************************************************");
			System.out.println("************************ Match :" + match.getJoueur1().getNomNaissance() + " "
					+ match.getJoueur1().getPrenom() + " vs " + match.getJoueur2().getNomNaissance() + " "
					+ match.getJoueur2().getPrenom() + "************************");
			System.out.println(
					"**************************************************************************************************");
			
			//demander le type de gestion
			autoFlag = getTypeGestion(sc);
			//Affichage du détail oui ou nn
			detailFlag = afficherDetails(sc);
			
			match.LancerMatch(autoFlag, detailFlag);		
			isFinished = true;
		}
		System.out.println(
				"**************************************************************************************************");
		System.out.println(
				"**************************************** Fin du "+niveau.getDescription()+" ***************************************");
		System.out.println(
				"**************************************************************************************************");
		return isFinished;
	}


	/**
	 * Fonction qui renvoi le choix de l'utilisateur sur l'affichage 
	 * du détails du match 
	 * @param sc
	 * @return
	 */
	public Boolean afficherDetails(Scanner sc) {
		String afficheDetail = "";
		Boolean affichageDtflag = false;
		do {
			System.out.println("Voulez vous afficher le détail : ");
			System.out.println("0 : Quitter l'application");
			System.out.println("1: Oui");
			System.out.println("2: Non");
			afficheDetail = sc.nextLine();
		} while (!afficheDetail.equals("0") && !afficheDetail.equals("1") && !afficheDetail.equals("2"));

		switch (afficheDetail) {
		case "0":
			sortirApp();
		case "1":
			affichageDtflag = true;
			break;
		case "2":
			affichageDtflag = false;
			break;
		}
		
		return affichageDtflag;
	}
	/**
	 * Fonction qui demande à l'utilisateur de choisir le type
	 * de gestion manuel ou automatique
	 * @param sc
	 * @return
	 */
	public Boolean getTypeGestion(Scanner sc) {
		String gestionAuto = "";
		Boolean autoflag = false;
		
		do {
			System.out.println("Type de gestion : ");
			System.out.println("0 : Quitter l'application");
			System.out.println("1: Automatique");
			System.out.println("2: Manuel");
			gestionAuto = sc.nextLine();
		} while (!gestionAuto.equals("0") && !gestionAuto.equals("1") && !gestionAuto.equals("2"));

		switch (gestionAuto) {
		case "0":
			sortirApp();
		case "1":
			autoflag = true;
			break;
		case "2":
			autoflag = false;
			break;
		}
		
		return autoflag;
	}

	/**
	 * Fonction pour quitter l'application
	 */
	public static void sortirApp() {
		System.out.println(
				"**************************************************************************************************");
		System.out.println(
				"************************* Fin de l'application de gestion des tournois ***************************");
		System.out.println(
				"**************************************************************************************************");
		System.exit(0);
	}
	
	private void ecrireCompteRenduTour(Niveau niveau, Categorie categorie, PrintWriter writer) {
		int index = 1;
		writer.println(
				"****************************************************************************************************");
		writer.println(
				"******************************** " + categorie.getDescription() + " ***********************************");
		writer.println(
				"******************************** début du " + niveau.getDescription() + " ***********************************");
		writer.println(
				"****************************************************************************************************");
		for (Match match : getMatchByNiveau(niveau,categorie)) {
			writer.println("Match " + index++ + " : " + match.getJoueur1().getNomNaissance() + " "
					+ match.getJoueur1().getPrenom() + " vs " + match.getJoueur2().getNomNaissance() + " "
					+ match.getJoueur2().getPrenom());
			writer.println("L'arbitre du match est : " + match.getArbitre().getNomNaissance() + " "
					+ match.getArbitre().getPrenom());
			writer.println("Le gagnant est : " + match.getVainqueur().getNomNaissance() + " "
					+ match.getVainqueur().getPrenom());
			writer.println(
					"-----------------------------------------------------------------------------------------------");
		}
		
		writer.println(
				"****************************************************************************************************");
		writer.println(
				"******************************** " + categorie.getDescription() + " ***********************************");
		writer.println(
				"******************************** fin du " + niveau.getDescription() + " ***********************************");
		writer.println(
				"****************************************************************************************************");

	}
	
}
