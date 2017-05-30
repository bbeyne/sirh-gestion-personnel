package dev.sgp.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


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
	@Produces(MediaType.APPLICATION_JSON)
	public Response modifyBanque(Map<String, String> banqueWrap, @PathParam("matricule") String matricule) {

		List<String> manquant = new ArrayList<String>();
		ResponseBuilder builder;
		if (banqueWrap.get("Banque") == null || banqueWrap.get("Banque").isEmpty() ) {
			manquant.add("Banque");
		}
		if ((banqueWrap.get("Bic") == null || banqueWrap.get("Bic").isEmpty()) ) {
			manquant.add("Bic");
		}
		if ((banqueWrap.get("Iban") == null || banqueWrap.get("Iban").isEmpty())) {
			manquant.add("Iban");
		}
		if(manquant.size() == 0) {
			CollabService.banqmodif(matricule, banqueWrap);
			builder = Response.ok("texte");
			builder.language("fr")
			.header("Content-type", "text/html");
			return builder.build();	
		} 
		else {
			builder = Response.status(Response.Status.EXPECTATION_FAILED);
			builder.language("fr")
			.entity("champs menquant : " + manquant);
			return builder.build();
		}
	}
}