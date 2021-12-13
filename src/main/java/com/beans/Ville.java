package main.java.com.beans;

public class Ville {
	private String codeCommune;
	private String nom_commune;
	private String code_postal;
	private String libelle_acheminement;
	private String ligne_5;
	private Coordonnees coordonnees;
	
	
	public Ville(String codeCommune, String nom_commune, String code_postal, String libelle_acheminement,
			String ligne_5, Coordonnees coordonnees) {
		super();
		this.codeCommune = codeCommune;
		this.nom_commune = nom_commune;
		this.code_postal = code_postal;
		this.libelle_acheminement = libelle_acheminement;
		this.ligne_5 = ligne_5;
		this.coordonnees = coordonnees;
	}
	
	public Ville() {
	}

	public String getNom_commune() {
		return nom_commune;
	}

	public void setNom_commune(String nom_commune) {
		this.nom_commune = nom_commune;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getLibelle_acheminement() {
		return libelle_acheminement;
	}

	public void setLibelle_acheminement(String libelle_acheminement) {
		this.libelle_acheminement = libelle_acheminement;
	}

	public String getLigne_5() {
		return ligne_5;
	}

	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}


	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Ville(String codeCommune) {
		super();
		this.codeCommune = codeCommune;
	}

	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}
	
	public double distanceAvec(Ville ville) {
		double latA = Double.parseDouble(this.getCoordonnees().getLatitude())*Math.PI/180;
		double longA = Double.parseDouble(this.getCoordonnees().getLongitude())*Math.PI/180;
		double latB = Double.parseDouble(ville.getCoordonnees().getLatitude())*Math.PI/180;
		double longB = Double.parseDouble(ville.getCoordonnees().getLongitude())*Math.PI/180;
		double a = Math.pow(Math.sin((latB-latA)/2), 2) + Math.cos(latA)*Math.cos(latB)*Math.pow(Math.sin((longB-longA)/2), 2);
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = 6371*c;
		return (double) Math.round(d * 100) / 100;
	}
}
