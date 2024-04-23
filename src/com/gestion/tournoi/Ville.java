package com.gestion.tournoi;

public enum Ville {

	MELBOURNE("Melbourne", "Plexicushion"), PARIS("Paris", "Terre Battue"), LONDRES("Londres", "Gazon"),
	NEWYORK("New York", "Decoturf");

	Ville(String name, String surface) {
		this.name = name;
		this.surface = surface;
	}

	private String name;
	private String surface;

	public String getName() {
		return this.name;
	}

	public String getSurface() {
		return this.surface;
	}

}
