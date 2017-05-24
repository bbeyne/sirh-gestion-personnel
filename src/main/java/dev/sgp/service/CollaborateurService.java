package dev.sgp.service;


import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
public class CollaborateurService {
	@PersistenceContext(unitName="sgp-pu") EntityManager em;
	@Inject Event<CollabEvt> collabEvt;
	public List<Collaborateur> listerCollaborateurs() {
		TypedQuery<Collaborateur> query2 = em.createQuery("select collaborateur from Collaborateur collaborateur", Collaborateur.class);
		return query2.getResultList();
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {

		em.persist(collab);
		CollabEvt nouveauCollabEvt = new CollabEvt(collab.getDateCreation(), TypeCollabEvt.valueOf("CREATION_COLLAB"), collab.getMatricule());
		collabEvt.fire(nouveauCollabEvt);
	}
}
