package dev.sgp.service;


import java.util.List;
import java.util.Map;

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
	public List<Collaborateur> listerCollaborateursbyDep(Integer depId) {
		TypedQuery<Collaborateur> query2 = em.createQuery("SELECT c FROM Collaborateur c WHERE c.departement.id=:depId", Collaborateur.class)
				.setParameter("depId", depId);
		return query2.getResultList();
	}
	public Collaborateur CollaborateurbyMatricule(String matricule) {
		TypedQuery<Collaborateur> query2 = em.createQuery("SELECT c FROM Collaborateur c WHERE c.matricule=:matricule", Collaborateur.class)
				.setParameter("matricule", matricule);
		return query2.getResultList().get(0);
	}

	public void collabmodif(String matricule, Collaborateur collab) {
		Collaborateur collabo=CollaborateurbyMatricule(matricule);
		if(collab.getDateCreation()!=null) collabo.setDateCreation(collab.getDateCreation());
		if(collab.getIntitulePoste()!=null) collabo.setIntitulePoste(collab.getIntitulePoste());
		if(collab.getDate_de_naissance()!=null) collabo.setDate_de_naissance(collab.getDate_de_naissance());
		if(collab.getDepartement()!=null) collabo.setDepartement(collab.getDepartement());
		if(collab.getPhoto()!=null) collabo.setPhoto(collab.getPhoto());
		if(collab.getEmailPro()!=null) collabo.setEmailPro(collab.getEmailPro());
	}

	public String CollabCoordbanc(String matricule) {
		Collaborateur collabo=CollaborateurbyMatricule(matricule);
		return "Banque : " + collabo.getBanque()+ "\n IBAN : " + collabo.getIBAN()+"\n BIC : "+ collabo.getBic();
	}

	public void banqmodif(String matricule, Map<String, String> banqueWrap) {
		Collaborateur collabo=CollaborateurbyMatricule(matricule);
		collabo.setBanque(banqueWrap.get("Banque"));
		collabo.setBic(banqueWrap.get("Bic"));
		collabo.setIBAN(banqueWrap.get("Iban"));
	}
	
	
}
