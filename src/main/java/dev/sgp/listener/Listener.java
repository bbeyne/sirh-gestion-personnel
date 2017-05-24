package dev.sgp.listener;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@WebListener
public class Listener implements ServletContextListener{
@Inject private CollaborateurService collabService;
@Override
public void contextInitialized(ServletContextEvent sce) {
	// TODO Auto-generated method stub
	Collaborateur collabo = new Collaborateur("mfzeho", "Pierre", "Paul", LocalDate.of(0, 1, 25), "Jacques", "000000000000000", "Pierre.Paul@societe.com", "tatronche.jpg", ZonedDateTime.now(), true);
	List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
	collaborateurs.add(collabo);

}

@Override
public void contextDestroyed(ServletContextEvent sce) {
	// TODO Auto-generated method stub
	
}

}
