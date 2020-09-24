package dev.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * entite Collegue
 * genere la table collegue
 * @author cql-v2
 *
 */
@Entity
@Table(name = "collegue")
public class Collegue extends GenelarEntity {

	private String matricule;
	private String nom;
	private String prenom;
	private String email;
	@Column(name = "date_naissance")
    private LocalDate dateNaissance;
	@Column(name = "photo_url")
	private String photoUrl;

	public Collegue() {

	}

	public Collegue(String matricule, String nom, String prenom, String email, LocalDate dateNaissance, String photoUrl) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.photoUrl = photoUrl;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
