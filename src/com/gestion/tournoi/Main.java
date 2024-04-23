package com.gestion.tournoi;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// variables
		Scanner sc = new Scanner(System.in);
		String indexVille = "";
		Ville villeTournoi = Ville.MELBOURNE;
		int anneeTournoi = 0;

		System.out.println(
				"**************************************************************************************************");
		System.out.println(
				"********************** Bienvenue dans l'application de gestion des tournois **********************");
		System.out.println(
				"**************************************************************************************************");

		// Séléctionner la ville du tournoi
		System.out.println("Séléctionner la Ville du tournoi : ");
		System.out.println("A : Melbourne");
		System.out.println("B : Paris");
		System.out.println("C : Londres");
		System.out.println("D : New York");
		System.out.println("Entrer A ou B ou C ou D : ");
		indexVille = sc.nextLine();
		while (!indexVille.equals("A") && !indexVille.equals("B") && !indexVille.equals("C")
				&& !indexVille.equals("D")) {
			System.out.println("Entrer A ou B ou C ou D : ");
			indexVille = sc.nextLine();
		}

		switch (indexVille) {
		case "A":
			villeTournoi = Ville.MELBOURNE;
			System.out.println("--> Vous avez choisi la surface " + villeTournoi.getSurface() + "\n");
			break;
		case "B":
			villeTournoi = Ville.PARIS;
			System.out.println("--> Vous avez choisi la surface " + villeTournoi.getSurface() + "\n");
			break;
		case "C":
			villeTournoi = Ville.LONDRES;
			System.out.println("--> Vous avez choisi la surface " + villeTournoi.getSurface() + "\n");
			break;
		case "D":
			villeTournoi = Ville.NEWYORK;
			System.out.println("--> Vous avez choisi la surface " + villeTournoi.getSurface() + "\n");
			break;
		}

		// Demander l'année de la tournoi
		System.out.println("*************** Année du tournoi ********************");
		System.out.println("Entrer l'année du tournoi (YYYY) : ");
		do {
			try {
				anneeTournoi = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Année non valide");
			}
		} while (anneeTournoi == 0);

		// Création du Tournoi
		Tournoi tournoi = new Tournoi(villeTournoi, anneeTournoi);

		lancerMenu(sc, tournoi);

		// Fermeture du scanner
		sc.close();
	}

	public static void lancerMenu(Scanner sc, Tournoi tournoi) {
		String action = "";
		do {
			System.out.println("*********************** Menu ************************");
			System.out.println("Séléctionner une action : ");
			System.out.println("0 : Quitter l'application");
			System.out.println("1 : Charger la liste des joueurs");
			System.out.println("2 : Initialiser la liste des joueurs automatiquement");
			action = sc.nextLine();
		} while (!action.equals("0") && !action.equals("1") && !action.equals("2"));

		switch (action) {
		case "0":
			sortirApp();
			break;
		case "1":
			chargerListeJoueur(sc, tournoi);
			tournoi.initialiserMatchByNiveau(Niveau.UNTOUR);
			tournoi.lancerTournoi(sc);
			break;
		case "2":
			tournoi.initialiserListJoueurs();
			tournoi.initialiserMatchByNiveau(Niveau.UNTOUR);
			tournoi.lancerTournoi(sc);
			break;
		}
	}

	public static void chargerListeJoueur(Scanner sc, Tournoi tournoi) {
		String fileName = "";
		int NbrJoueurHomme = 0;
		int NbrJoueurFemme = 0;
		File file;
		do {
			System.out.println("Entrer le nom du fichier de la liste des joueurs : ");
			fileName = sc.nextLine();
			file = new File("./fileInput/" + fileName);
			if (!file.exists()) {
				System.out.println(" --> Ce fichier n'existe pas dans le dossier fileInput");
			}
		} while (!file.exists());

		ReadFileInList readFile = new ReadFileInList("./fileInput/" + fileName);
		NbrJoueurHomme = readFile.listByCategory("homme");
		NbrJoueurFemme = readFile.listByCategory("femme");
		if(NbrJoueurHomme < 128 || NbrJoueurFemme < 128) {
			readFile.CompleterListeJoueur(NbrJoueurHomme, NbrJoueurFemme);
			tournoi.joueursQualifies = readFile.joueurs;
		}else if(NbrJoueurHomme > 128 || NbrJoueurFemme > 128) {
			System.out.println("Le fichier doit contenir 256 joueurs dont 128 Hommes et 128 Femmes");
			lancerMenu(sc,tournoi);
		}else if (NbrJoueurHomme == 128 && NbrJoueurFemme == 128) {
			tournoi.joueursQualifies = readFile.joueurs;
		}
		
	}
	
	public static void sortirApp() {
		System.out.println(
				"**************************************************************************************************");
		System.out.println(
				"************************* Fin de l'application de gestion des tournois ***************************");
		System.out.println(
				"**************************************************************************************************");
		System.exit(0);
	}

}
