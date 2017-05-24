package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.sgp.entite.VisiteWeb;

@ApplicationScoped
public class VisiteService {

	static List<VisiteWeb> listevisite = new ArrayList<>();

	public List<VisiteWeb> listerVisite() {

		return listevisite;
	}

	public void sauvegarderVisite(VisiteWeb visite) {

		listevisite.add(visite);

	}
}
