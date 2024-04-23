package com.gestion.tournoi;

import java.util.Random;

public enum Sponsor {
	Fila("Fila"),
	Lotto("Lotto"),
	Wilson("Wilson"),
	Nike("Nike"),
	Babolat("Babolat"),
	Uniqlo("Uniqlo"),
	Adidas("Adidas"),
	Topper("Topper"),
	Yonex("Yonex"),
	LiNing("Li Ning"),
	Myzuno("Myzuno"),
	Dunlop("Dunlop"),
	Head("Head"),
	Prince("Prince"),
	Joma("Joma"),
	Rolex("Rolex"),
	Peugeot("Peugeot"),
	Paribas("BNP Paribas"),
	Alain("Alain Afflelou"),
	;
	
	Sponsor(String description){
		this.description = description;
	}
	
	private String description;

	public String getDescription() {
		return description;
	}
	
	public static Sponsor getRandomSponsor() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
	
	
}
