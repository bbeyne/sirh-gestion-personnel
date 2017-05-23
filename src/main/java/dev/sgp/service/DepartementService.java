package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {
	List<Departement> listeDepartement = new ArrayList<>();

	public DepartementService() {
		super();
		this.listeDepartement.add(new Departement(1, "Comptabilité"));
		this.listeDepartement.add(new Departement(2, "Ressources Humaines"));
		this.listeDepartement.add(new Departement(3, "Informatique"));
		this.listeDepartement.add(new Departement(4, "Administratif"));
	}

	public List<Departement> listerCollaborateurs() {

	return listeDepartement;

	}

	public void sauvegarderCollaborateur(Departement departement) {

	listeDepartement.add(departement);

	}
}

