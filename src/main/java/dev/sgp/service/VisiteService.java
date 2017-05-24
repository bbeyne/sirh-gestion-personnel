package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.VisiteWeb;

@Stateless
public class VisiteService {
	@PersistenceContext(unitName="sgp-pu") EntityManager em;

	public List<VisiteWeb> listerVisite() {
		TypedQuery<VisiteWeb> query2 = em.createQuery("select visiteweb from VisiteWeb visiteweb", VisiteWeb.class);
		return query2.getResultList();

	}

	public void sauvegarderVisite(VisiteWeb visite) {

		em.persist(visite);

	}
}
