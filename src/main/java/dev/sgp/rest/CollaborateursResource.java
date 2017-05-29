package dev.sgp.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@Path("collaborateurs")
public class CollaborateursResource {
	@Inject private CollaborateurService CollabService;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> getCollabDep(@QueryParam("departement") Integer departementid) {
		if (departementid!=null){
		List<Collaborateur> result = CollabService.listerCollaborateursbyDep(departementid);
		return result; 
		}
		else{
			List<Collaborateur> collaborateurs = CollabService.listerCollaborateurs(); 
			return collaborateurs;
		}
	}
	@GET
	@Path("/{matricule}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur getCollabMatricule(@PathParam("matricule") String matricule) {
		return CollabService.CollaborateurbyMatricule(matricule); 
	}
	@PUT
	@Path("/{matricule}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putCollabMatricule(@PathParam("matricule") String matricule, Collaborateur collab){
		CollabService.collabmodif(matricule,collab);
	}
	@GET
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCoordBanc(@PathParam("matricule") String matricule){
		return CollabService.CollabCoordbanc(matricule);
	}
	@PUT
	@Path("/{matricule}/banque")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putCooordbancaire(@PathParam("matricule") String matricule, Collaborateur collab){
		CollabService.banqmodif(matricule,collab);
	}
}