package dev.sgp.entite;


import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Collaborateur {
	public Collaborateur(){
		
	}
	public Collaborateur(String matricule, String prenom, String nom, LocalDate birthday, String adresse,
			String numSecuSoc, String emailPro, String photo, ZonedDateTime dateCreation, boolean actif, String intitulePoste, Departement departement) {
		super();
		this.matricule = matricule;
		this.prenom = prenom;
		this.nom = nom;
		this.birthday = birthday;
		this.adresse = adresse;
		this.numSecuSoc = numSecuSoc;
		this.emailPro = emailPro;
		this.photo = photo;
		this.actif = actif;
		this.dateCreation=dateCreation;
		this.departement=departement;
		this.intitulePoste=intitulePoste;
		
	}
	
	@Id
	private String matricule;
	private String prenom;
	private String nom;
	private LocalDate birthday;
	private String adresse;
	private String numSecuSoc;
	private String emailPro;
	private String photo;
	private ZonedDateTime dateCreation;
	private boolean actif;
	private String intitulePoste;
	@ManyToOne
	private Departement departement;
	private String Banque="BNP";
	private String Bic="4354254";
	private String IBAN="30004";
	
	
	public String getBanque() {
		return Banque;
	}
	public void setBanque(String banque) {
		Banque = banque;
	}
	public String getBic() {
		return Bic;
	}
	public void setBic(String bic) {
		Bic = bic;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public LocalDate getDate_de_naissance() {
		return birthday;
	}
	public void setDate_de_naissance(LocalDate date_de_naissance) {
		birthday = date_de_naissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNum_SecuSoc() {
		return numSecuSoc;
	}
	public void setNum_SecuSoc(String numSecuSoc) {
		this.numSecuSoc = numSecuSoc;
	}
	public String getEmailPro() {
		return emailPro;
	}
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public ZonedDateTime getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(ZonedDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public String getIntitulePoste() {
		return intitulePoste;
	}
	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}
