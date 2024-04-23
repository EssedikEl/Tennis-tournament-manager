package com.gestion.tournoi;

public enum Categorie {

	SIMPLEH("simple homme"), SIMPLEF("simple femme"), DOUBLEH("double homme"), DOUBLEF("double femme"),
	DOUBLEM("double mixte"), JUNIOR("junior");
	
	Categorie(String description){
		this.description = description;
	}
	
	private String description;
	
	public String getDescription() {
		return this.description;
	}
}
