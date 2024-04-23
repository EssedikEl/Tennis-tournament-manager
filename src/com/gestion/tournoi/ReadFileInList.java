package com.gestion.tournoi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadFileInList {

	private String fileName;
	protected Map<Joueur, Boolean> joueurs;

	public ReadFileInList(String fileName) {
		this.fileName = fileName;
		joueurs = new HashMap<Joueur, Boolean>();
		joueurs = readFile();
	}

	/**
	 * fonction qui permet de décortiquer le fichier des joueurs qualifié qui va
	 * retourner la liste des joueurs du tournoi
	 */
	@SuppressWarnings("deprecation")
	public Map<Joueur, Boolean> readFile() {
		////////////////////////////////// Input
		Scanner sc1 = new Scanner(System.in);

		List<String> l = Collections.emptyList();
		String ligne = "";
		String[] champs;
		Map<Joueur, Boolean> listeJoueurs = new HashMap<Joueur, Boolean>();
		String nomNaissance = "";
		String nomCourant = "";
		String prenom = "";
		String nationalite = "";
		Date dateNaissance = new Date();
		String lieuNaissance = "";
		String main = "";
		String entraineur = "";
		int poids = 0;
		int taille = 0;
		int classement = 1;
		String genre = "";

		l = readFileInList(fileName);

		Iterator<String> itr = l.iterator();
		while (itr.hasNext()) {
			ligne = itr.next();
			champs = ligne.split(";");
			// Alimenter les champs d'un joueur
			nomNaissance = champs[0];
			nomCourant = champs[1];
			prenom = champs[2];
			nationalite = champs[3];
			try {
				dateNaissance = new Date(champs[4]);
			} catch (IllegalArgumentException e) {
				System.out
						.println("le date de naissance du Joueur " + nomNaissance + " " + prenom + " n'est pas valide");
			}
			lieuNaissance = champs[5];
			main = champs[6];
			entraineur = champs[7];
			try {
				poids = Integer.parseInt(champs[8]);
			} catch (NumberFormatException e) {
				System.out.println("le poids du Joueur " + nomNaissance + " " + prenom + " n'est pas valide");
			}
			try {
				taille = Integer.parseInt(champs[9]);
			} catch (NumberFormatException e) {
				System.out.println("la taille du Joueur " + nomNaissance + " " + prenom + " n'est pas valide");
			}
			genre = champs[10];

			listeJoueurs.put(
					new Joueur(nomNaissance, prenom, nomCourant, dateNaissance, lieuNaissance, nationalite, taille,
							poids, genre, main, Sponsor.getRandomSponsor().getDescription(), classement++, entraineur),
					false);
		}

		//sc1.close();
		return listeJoueurs;
	}

	/**
	 * Fonction qui permet de décortiquer le fichier sous forme d'une liste des
	 * lignes
	 * 
	 * @param fileName
	 * @return
	 */
	private List<String> readFileInList(String fileName) {

		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public int listByCategory(String genre){
		int sizeByCategory = 0;
		List<Joueur> joueursList = new ArrayList<Joueur>(joueurs.keySet());
		for (Joueur j : joueursList) {
			if(j.getGenre().equals(genre)) {
				sizeByCategory ++;
			}
		}
		return sizeByCategory;
	}
	
	@SuppressWarnings("deprecation")
	public void CompleterListeJoueur(int NbrJoueurHomme, int NbrJoueurFemme) {
		ArrayList<NameJoueurHomme> suiteJoueursQualifiesH = new ArrayList<NameJoueurHomme>();
		NameJoueurHomme joueurNameH;
		ArrayList<NameJoueurFemme> suiteJoueursQualifiesF = new ArrayList<NameJoueurFemme>();
		NameJoueurFemme joueurNameF;
		int classement = NbrJoueurHomme + 1;
		if(NbrJoueurHomme != 128) {
			for (int i = 0; i < (128-NbrJoueurHomme); i++) {
				do {
					joueurNameH = NameJoueurHomme.getRandomJoueurHomme();
				} while (suiteJoueursQualifiesH.contains(joueurNameH));
				suiteJoueursQualifiesH.add(joueurNameH);
			}
	
			for (NameJoueurHomme joueurHomme : suiteJoueursQualifiesH) {
				joueurs.put(new Joueur(joueurHomme.getNom(), joueurHomme.getPrenom(), null,
						new Date(joueurHomme.getDateNaissance()), joueurHomme.getLieuNaissance(),
						joueurHomme.getNationalite(), joueurHomme.getTaille(), joueurHomme.getPoids(), "homme",
						joueurHomme.getMain(), Sponsor.getRandomSponsor().getDescription(), classement++,
						joueurHomme.getEntraineur()), false);
			}
		}
		
		if(NbrJoueurFemme != 128) {
			classement = NbrJoueurFemme+1; // initialiser le classement pour les femmes
			for (int i = 0; i < (128-NbrJoueurFemme); i++) {
				do {
					joueurNameF = NameJoueurFemme.getRandomJoueurFemme();
				} while (suiteJoueursQualifiesF.contains(joueurNameF));
				suiteJoueursQualifiesF.add(joueurNameF);
			}
	
			for (NameJoueurFemme joueurFemme : suiteJoueursQualifiesF) {
				joueurs.put(new Joueur(joueurFemme.getNom(), joueurFemme.getPrenom(), joueurFemme.getNomCourant(),
						new Date(joueurFemme.getDateNaissance()), joueurFemme.getLieuNaissance(),
						joueurFemme.getNationalite(), joueurFemme.getTaille(), joueurFemme.getPoids(), "femme",
						joueurFemme.getMain(), Sponsor.getRandomSponsor().getDescription(), classement++,
						joueurFemme.getEntraineur()), false);
			}
		}
	}

}
