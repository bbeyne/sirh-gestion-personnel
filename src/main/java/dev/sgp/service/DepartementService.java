package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.Departement;

@Stateless
public class DepartementService {
	@PersistenceContext(unitName="sgp-pu") EntityManager em;

	public DepartementService() {
	}

	public List<Departement> listerDepartement() {

		TypedQuery<Departement> query2 = em.createQuery("select departement from Departement departement", Departement.class);
		return query2.getResultList();

	}

	public void sauvegarderDepartement(Departement departement) {


		em.persist(departement);

	}
}

