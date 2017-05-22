package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws

	ServletException, IOException {
		
		// récupère la valeur d'un paramètre dont le nom est matricule

		String matriculeParam = req.getParameter("matricule");

		resp.setContentType("text/html");

		// code HTML écrit dans le corps de la réponse
		if(matriculeParam!=null){
		resp.getWriter().write("<h1>Edition des collaborateurs</h1>"

		+ "<ul>"

		+ "<li>matricule: "+ matriculeParam + "</li>"

		+ "</ul>");
		}
		else{
			resp.setStatus(400);
			resp.getWriter().write("Un matricule est attendu");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws

	ServletException, IOException {
		String matriculeParam = req.getParameter("matricule");
		String titreParam = req.getParameter("titre");
		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("prenom");
		resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
		if(matriculeParam!=null && titreParam!=null && nomParam!=null && prenomParam!=null){
			resp.setStatus(201);
			resp.getWriter().write("Création d'un collaborateur avec les informations suivantes : <br> matricule= "+matriculeParam 
					+",titre= "+titreParam+",nom= "+ nomParam+ ",prenom= "+prenomParam);
			}
		else{
			resp.setStatus(400);
			resp.getWriter().write("Les paramètres suivants sont incorrects : ");
			if (matriculeParam==null) resp.getWriter().write("matricule, ");
			if (titreParam==null) resp.getWriter().write("titre, ");
			if (nomParam==null) resp.getWriter().write("nom, ");
			if (prenomParam==null) resp.getWriter().write("prenom.");
		}
		
	}

}
