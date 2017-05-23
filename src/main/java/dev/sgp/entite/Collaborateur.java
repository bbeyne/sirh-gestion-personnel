package dev.sgp.entite;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Collaborateur {
	public Collaborateur(String matricule, String prenom, String nom, LocalDate date_de_naissance, String adresse,
			String num_SecuSoc, String emailPro, String photo, boolean actif) {
		super();
		this.matricule = matricule;
		this.prenom = prenom;
		this.nom = nom;
		Date_de_naissance = date_de_naissance;
		this.adresse = adresse;
		Num_SecuSoc = num_SecuSoc;
		this.emailPro = emailPro;
		this.photo = photo;
		this.actif = actif;
	}
	@Id
	private String matricule;
	private String prenom;
	private String nom;
	private LocalDate Date_de_naissance;
	private String adresse;
	private String Num_SecuSoc;
	private String emailPro;
	private String photo;
	private boolean actif;
	
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
		return Date_de_naissance;
	}
	public void setDate_de_naissance(LocalDate date_de_naissance) {
		Date_de_naissance = date_de_naissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNum_SecuSoc() {
		return Num_SecuSoc;
	}
	public void setNum_SecuSoc(String num_SecuSoc) {
		Num_SecuSoc = num_SecuSoc;
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
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
}
