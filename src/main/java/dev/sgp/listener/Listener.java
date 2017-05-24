package dev.sgp.listener;

import java.time.LocalDate;
import java.time.ZonedDateTime;


import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebListener
public class Listener implements ServletContextListener{
@Inject private CollaborateurService collabService;
@Inject private DepartementService depService;
@Override
public void contextInitialized(ServletContextEvent sce) {
	// TODO Auto-generated method stub
	Collaborateur collabo = new Collaborateur("mfzeho", "Pierre", "Paul", LocalDate.of(0, 1, 25), "Jacques", "000000000000000", "Pierre.Paul@societe.com", "tatronche.jpg", ZonedDateTime.now(), true);
	collabService.sauvegarderCollaborateur(collabo);
	depService.sauvegarderDepartement(new Departement(1, "Comptabilité"));
	depService.sauvegarderDepartement(new Departement(2, "Ressources Humaines"));
	depService.sauvegarderDepartement(new Departement(3, "Informatique"));
	depService.sauvegarderDepartement(new Departement(4, "Administratif"));
}

@Override
public void contextDestroyed(ServletContextEvent sce) {
	// TODO Auto-generated method stub
	
}

}
