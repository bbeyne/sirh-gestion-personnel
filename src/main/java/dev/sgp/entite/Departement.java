package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departement {

	public Departement() {
		super();
	}
	@Id
	private int Id;
	private String nom;
	public Departement(int id, String nom) {
		super();
		Id = id;
		this.nom = nom;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
