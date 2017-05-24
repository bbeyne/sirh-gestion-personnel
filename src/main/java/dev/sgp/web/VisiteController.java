package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.VisiteStat;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteService;

@WebServlet("/statistiques")
public class VisiteController extends HttpServlet {
	@Inject private VisiteService visiteService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<VisiteStat> visitestat = new ArrayList<>();
		visiteService.listerVisite().stream().collect(Collectors.groupingBy(VisiteWeb::getChemin))
			.forEach((chemin, visites)->{
				long compteur =  visites.stream().count();
				int maxtemps = visites.stream().max(Comparator.comparing(VisiteWeb::getTempsExecution)).get()
						.getTempsExecution();
				int mintemps = visites.stream().min(Comparator.comparing(VisiteWeb::getTempsExecution)).get()
						.getTempsExecution();
				OptionalDouble moytemps=visites.stream().mapToInt(person -> person.getTempsExecution()).average();
				visitestat.add(new VisiteStat(chemin, compteur, maxtemps, mintemps, moytemps.getAsDouble()));
		});
		req.setAttribute("listeVisites", visitestat);
		req.getRequestDispatcher("/WEB-INF/views/collab/visites.jsp").forward(req, resp);
	}
}
