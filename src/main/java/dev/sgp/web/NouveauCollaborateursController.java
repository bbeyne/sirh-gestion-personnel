package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class NouveauCollaborateursController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collab/nouveauCollaborateur.jsp")
		.forward(req, resp);
	}
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws

	ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String adresse = req.getParameter("adresse");
		LocalDate birthday = LocalDate.parse(req.getParameter("date"));
		String numSecuSoc = req.getParameter("numsecu");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		if(nom!=null && prenom!=null && adresse!=null && numSecuSoc.length()==15 && birthday!=null){
			resp.setStatus(201);
			String emailPro = prenom+"."+nom+"@societe.com";
			String matricule = UUID.randomUUID().toString();
			String photo = "tatronche.jpg";
			ZonedDateTime datecreation= ZonedDateTime.now();
			Collaborateur Collabo = new Collaborateur(matricule, prenom, nom, birthday, adresse, numSecuSoc, emailPro, photo,datecreation, true);
			Collabo.setDepartement(new Departement(1, "Comptabilité"));
			Collabo.setIntitulePoste("tappeur");
			List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
			collaborateurs.add(Collabo);
			resp.sendRedirect(req.getContextPath()+ "/collaborateurs/lister");
			
		}
		else{
			resp.setStatus(400);
			resp.getWriter().write("Erreur dans le formulaire");
		}
		
	}
}