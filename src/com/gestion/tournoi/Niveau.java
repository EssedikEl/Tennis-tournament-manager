package com.gestion.tournoi;

public enum Niveau {
	UNTOUR("1er tour"), DEUXTOUR("2 eme tour"), TROISTOUR("3 eme tour"), HUITFINAL("Huitième de finale"),
	QUARTFINAL("Quart de finale"), DEMIFINALE("Demi finale"), FINALE("Finale");

	Niveau(String description) {
		this.description = description;
	}

	private String description;

	public String getDescription() {
		return this.description;
	}
}
