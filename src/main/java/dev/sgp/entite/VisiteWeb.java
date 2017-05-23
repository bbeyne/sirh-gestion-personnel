package dev.sgp.entite;

public class VisiteWeb {

	private String chemin;
	private int tempsExecution;
	
	public VisiteWeb(String chemin, int tempsExecution) {
		super();
		this.chemin = chemin;
		this.tempsExecution = tempsExecution;
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin=chemin;
	}
	public int getTempsExecution() {
		return tempsExecution;
	}
	public void setTempsExecution(int tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
}

