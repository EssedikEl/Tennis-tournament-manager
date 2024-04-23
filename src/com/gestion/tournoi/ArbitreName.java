package com.gestion.tournoi;

import java.util.Random;

public enum ArbitreName {

	Nili("Nili","Ali","Iranien","14/12/1982","Téhéran",185,90,"homme"),
	Bernardes("Bernardes","Carlos","Brésilien","29/03/1976","Campinas",189,84,"homme"),
	Ramos("Ramos","Carlos","Portugais","05/09/1971","Faro",191,90,"homme"),
	Dumusois("Dumusois","Damien","Français","06/08/1989","Paris",180,75,"homme"),
	Joseph("Joseph","Emmanuel","Français","17/01/1987","Lyon",175,65,"homme"),
	Murphy("Murphy","Fergus","Irelandais","20/04/1985","Dublin",195,84,"homme"),
	Moscarella("Moscarella","Gianluca","Italien","25/07/1990","Turin",175,69,"homme"),
	Keothavong("Keothavong","James","Britannique","29/01/1989","Dunblane",198,90,"homme"),
	Blom("Blom","John","Australien","30/06/1986","Jajce",178,70,"homme"),
	Nouni("Nouni","Kader","Français","09/11/1987","Les Abymes",186,88,"homme"),
	Messina("Messina","Manuel","Italien","02/10/1985","San Marino",191,87,"homme"),
	Jennati("El Jennati","Mohamed","Marocain","12/07/1984","Fes",186,78,"homme"),
	Lahyani("Lahyani","Mohamed","Marocain","05/08/1972","Casablanca",192,87,"homme"),
	Bacchi("Bacchi","Pierre","Français","03/12/1988","Dax",184,85,"homme"),
	Lichtenstein("Lichtenstein","Renaud","Français","16/11/1987","Paris",197,87,"homme"),
	Herfel("Herfel","Roland","Allemand","14/03/1987","Dachau",194,91,"homme"),
	Campistol("Campistol","Jaume","Espagnol","28/04/1991","Madrid",187,76,"homme"),
	Nour("Nour","Abdel","Egyptian","25/09/1992","Cairo",195,89,"homme"),
	Helwerth("Helwerth","Nico","Allemand","24/03/1990","Sieverodonetsk",190,86,"homme"),
	Forcadell("Forcadell","Nacho","Espanol","27/04/1993","Madrid",177,65,"homme"),
	Hughes("Lang","Alison","Britannique","06/11/1976","Londres",177,75,"femme","Hughes"),
	AsderakiMoore("Asderaki","Eva","Grèque","25/12/1980","Athènes",175,65,"femme","Asderaki-Moore"),
	Zhang("Zhang","Juan","Chinoise","14/07/1984","Hu Bei",169,64,"femme"),
	Alves("Alves","Mariana","Portugaise","27/12/1990","Faro",179,77,"femme"),
	Cicak("Cicak","Marija","Croatia","28/05/1984","Mali Losinj",170,65,"femme"),
	Veljovic("Veljovic","Marijana","Serbia","02/06/1988","Belgrade",171,70,"femme"),
	Kjendlie("Kjendlie","Julie","Norway","05/07/1991","Oslo",180,76,"femme"),
	Tourte("Tourte","Aurélie","Française","18/03/1992","Paris",176,68,"femme"),
	Bley("Bley","Miriam","Allemande","14/06/1990","Sieverodonetsk",181,75,"femme")
	;

	ArbitreName(String nom, String prenom, String nationalite,String dateNaissance, String lieuNaissance, int taille, int poids, String genre) {
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.taille = taille;
		this.poids = poids;
		this.genre = genre;
	}
	
	ArbitreName(String nom, String prenom, String nationalite,String dateNaissance, String lieuNaissance, int taille, int poids, String genre, String nomCourant) {
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.taille = taille;
		this.poids = poids;
		this.genre = genre;
		this.nomCourant = nomCourant;
	}

	private String nom;
	private String prenom;
	private String nationalite;
	private String dateNaissance;
	private String lieuNaissance;
	private int taille;
	private int poids;
	private String genre;
	private String nomCourant;

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public String getNationalite() {
		return nationalite;
	}
	
	public String getDateNaissance() {
		return dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public int getTaille() {
		return taille;
	}

	public int getPoids() {
		return poids;
	}
	
	public String getGenre() {
		return genre;
	}
	public String getNomCourant() {
		return nomCourant;
	}
	
	public static ArbitreName getRandomArbitre() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
