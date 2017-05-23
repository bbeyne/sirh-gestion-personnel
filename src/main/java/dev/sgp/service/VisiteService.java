package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.VisiteWeb;

public class VisiteService {

	List<VisiteWeb> listevisite = new ArrayList<>();

	public List<VisiteWeb> listerVisite() {

		return listevisite;

	}

	public void sauvegarderVisite(VisiteWeb visite) {

		listevisite.add(visite);

	}
}
