package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;

@WebServlet("/collaborateurs/nouveau")
public class NouveauCollaborateursController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collab/nouveauCollaborateur.jsp")
		.forward(req, resp);
	}
	@Inject private CollaborateurService collabService;
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
			Collaborateur Collabo = new Collaborateur(matricule, prenom, nom, birthday, adresse, numSecuSoc, emailPro, photo,datecreation, true, "glandeur", new Departement(1,"Comptabilité"));
			collabService.sauvegarderCollaborateur(Collabo);
			resp.sendRedirect(req.getContextPath()+ "/collaborateurs/lister");
			
		}
		else{
			resp.setStatus(400);
			resp.getWriter().write("Erreur dans le formulaire");
		}
		
	}
}