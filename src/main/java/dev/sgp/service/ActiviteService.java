package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvt;

@Stateless
public class ActiviteService {
	@PersistenceContext(unitName="sgp-pu") EntityManager em;
	public void recevoirEvenementCollab(@Observes CollabEvt evt){

		em.persist(evt);
	}
	public List<CollabEvt> listerActivitesCollab(){
		TypedQuery<CollabEvt> query2 = em.createQuery("select collabevt from CollabEvt collabevt", CollabEvt.class);
		return query2.getResultList();
	}
}
