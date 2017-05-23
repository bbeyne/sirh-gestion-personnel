package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteService;
import dev.sgp.util.Constantes;

public class VisiteController extends HttpServlet {
	private VisiteService visiteService = Constantes.VISITE_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VisiteWeb> visites = visiteService.listerVisite();
		int a = (int) visites.stream()
				.filter(x -> x.getChemin().equals("/sgp/collaborateurs/nouveau")).count();
		int b = visites.stream().filter(x -> x.getChemin().equals("/sgp/collaborateurs/nouveau"))
				.max((p1, p2) -> Integer.compare(p1.getTempsExecution(), p2.getTempsExecution())).get()
				.getTempsExecution();
		int c = visites.stream().filter(x -> x.getChemin().equals("/sgp/collaborateurs/nouveau"))
				.min((p1, p2) -> Integer.compare(p1.getTempsExecution(), p2.getTempsExecution())).get()
				.getTempsExecution();
		int a2 = (int) visites.stream()
				.filter(x -> x.getChemin().equals("/sgp/collaborateurs/lister")).count();
		int b2 = visites.stream().filter(x -> x.getChemin().equals("/sgp/collaborateurs/lister"))
				.max((p1, p2) -> Integer.compare(p1.getTempsExecution(), p2.getTempsExecution())).get()
				.getTempsExecution();
		int c2 = visites.stream().filter(x -> x.getChemin().equals("/sgp/collaborateurs/lister"))
				.min((p1, p2) -> Integer.compare(p1.getTempsExecution(), p2.getTempsExecution())).get()
				.getTempsExecution();
		int[] visitenouveau = { a, b, c, a2, b2, c2};
		req.setAttribute("listeVisites", visitenouveau);
		req.getRequestDispatcher("/WEB-INF/views/collab/visites.jsp").forward(req, resp);
	}
}
