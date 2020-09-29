package dev.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.dto.CreerCollegueRequestDto;
import dev.entite.Collegue;
import dev.repository.CollegueRepo;

@Service
public class CollegueService {

	private CollegueRepo collegueRepo;

	public CollegueService(CollegueRepo collegueRepo) {
		super();
		this.collegueRepo = collegueRepo;
	}

	public List<String> rechercherParNom(String nom) {
		return collegueRepo.findByNom(nom);
	}

	public Collegue creerCollegue(CreerCollegueRequestDto dto) {

		Collegue collegue = new Collegue();
		collegue.setNom(dto.getNom());
		collegue.setPrenom(dto.getPrenoms());
		collegue.setDateNaissance(dto.getDateDeNaissance());
		collegue.setPhotoUrl(dto.getPhotoUrl());

		// logique métier (génération du matricule)
		collegue.setMatricule(UUID.randomUUID().toString());
		collegue.setEmail(dto.getPrenoms() + "." + dto.getNom() + "@dev.fr");

		// => envoyer un email aux RHs
		// ...

		return this.collegueRepo.save(collegue);// insert into collegue

	}

	public Optional<Collegue> rechercherParMat(String matricule) {

		return this.collegueRepo.findByMatricule(matricule);
	}

	public List<Collegue> ListAllCollegue() {
		return collegueRepo.findAll();
	}

	public void supprimerCollegueService(String matricule) {
		collegueRepo.supprimerCollegueParMatricule(matricule);
	}

}
