package dev.sgp.entite;


public class VisiteStat {	
	

	private String chemin;
	private long compteur;
	private long maxtemps;
	private long mintemps;
	private double moytemps;
	public VisiteStat(String chemin, long compteur, long maxtemps, long mintemps, double moytemps) {
		super();
		this.chemin = chemin;
		this.compteur = compteur;
		this.maxtemps = maxtemps;
		this.mintemps = mintemps;
		this.setMoytemps(moytemps);
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	public long getCompteur() {
		return compteur;
	}
	public void setCompteur(long compteur) {
		this.compteur = compteur;
	}
	public long getMaxtemps() {
		return maxtemps;
	}
	public void setMaxtemps(long maxtemps) {
		this.maxtemps = maxtemps;
	}
	public long getMintemps() {
		return mintemps;
	}
	public void setMintemps(long mintemps) {
		this.mintemps = mintemps;
	}
	public double getMoytemps() {
		return moytemps;
	}
	public void setMoytemps(double moytemps) {
		this.moytemps = moytemps;
	}
}
