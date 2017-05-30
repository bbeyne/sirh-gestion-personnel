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
	Departement dep = new Departement(1, "Comptabilité");
	depService.sauvegarderDepartement(dep);
	depService.sauvegarderDepartement(new Departement(2, "Ressources Humaines"));
	depService.sauvegarderDepartement(new Departement(3, "Informatique"));
	depService.sauvegarderDepartement(new Departement(4, "Administratif"));
	Collaborateur collabo = new Collaborateur("mfzeho", "Pierre", "Paul", LocalDate.of(0, 1, 25), "Jacques", "000000000000000", "Pierre.Paul@societe.com", "tatronche.jpg", ZonedDateTime.now(), true,"chef",dep);
	collabo.setBanque("BNP"); collabo.setBic("5446876876"); collabo.setIBAN("30004...");
	collabService.sauvegarderCollaborateur(collabo);
	Collaborateur collabo2 = new Collaborateur("bbb", "Pierre", "Paul", LocalDate.of(0, 1, 25), "Jacques", "000000000000000", "Pierre.Paul@societe.com", "tatronche.jpg", ZonedDateTime.now(), true,"chef",new Departement(3, "Informatique"));
	collabo2.setBanque("CIC"); collabo2.setBic("5446876876"); collabo2.setIBAN("30002...");
	collabService.sauvegarderCollaborateur(collabo2);


}

@Override
public void contextDestroyed(ServletContextEvent sce) {
	// TODO Auto-generated method stub
	
}

}
