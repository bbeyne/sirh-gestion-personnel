package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VisiteWeb {

	@Id
	private int Id;
	private String chemin;
	private int tempsExecution;
	
	public VisiteWeb(int id, String chemin, int tempsExecution) {
		super();
		Id = id;
		this.chemin = chemin;
		this.tempsExecution = tempsExecution;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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

