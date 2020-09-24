package dev.web.collegue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.dto.CollegueDto;
import dev.entite.Collegue;
import dev.services.CollegueService;

import static java.util.stream.Collectors.*;


/**
 * controlleur de l'api Collegue
 * @version 0.1
 * @author cql-v2
 *
 */
@RestController
@RequestMapping("collegues") // ressource "collegues"
public class CollegueCtrl {

	private CollegueService colServ;

	public CollegueCtrl(CollegueService colServ) {
		this.colServ = colServ;
	}



	@GetMapping
	public List<String> listCollegue(@RequestParam String nom) {
		return colServ.getByNom(nom)
				.stream()
				.map(Collegue::getMatricule)
				.collect(toList());

	}

	/**
	 * url : [SERVER]/collegue/getMatricule?nom={nom}
	 * @return un json de tous les matricules en bdd 
	 */
	@GetMapping("{matricule}")
	public ResponseEntity<?> findByMatricule(@PathVariable String matricule) {
		Optional<Collegue> byMatricule = colServ.getByMatricule(matricule);

		if(byMatricule.isPresent()) {
			return ResponseEntity.ok(byMatricule.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	/**
	 * url : [SERVER]/collegue
	 * @param collegueDto un objet collegueDto au format json
	 * @return un objet collegueDto au format json
	 */
	@PostMapping
	public ResponseEntity<?> newCollegue(@RequestBody CollegueDto collegueDto) {
			Collegue newCollegue = colServ.addCollegue(
					collegueDto.getNom(),
					collegueDto.getPrenom(),
					collegueDto.getEmail(),
					collegueDto.getDateNaissance(),
					collegueDto.getPhotoUrl()
					);

			return ResponseEntity.ok(newCollegue);
	}
	
	/**
	 * 
	 * @param collegueDto un objet collegueDto au format json
	 * @return un objet collegueDto au format json
	 */
	@PutMapping
	public ResponseEntity<?> editUser(@RequestBody CollegueDto collegueDto) {
		Collegue editCollegue = colServ.updateCollegue(
				collegueDto.getId(),
				collegueDto.getMatricule(),
				collegueDto.getNom(),
				collegueDto.getPrenom(),
				collegueDto.getEmail(),
				collegueDto.getDateNaissance(),
				collegueDto.getPhotoUrl()
				);
		return ResponseEntity.ok(editCollegue);
	}
	/**
	 * 
	 * @param id id du collegue a remove
	 * @return une String 
	 */
	@DeleteMapping
	public ResponseEntity<?> remUser(@RequestParam Integer id) {
		return ResponseEntity.ok(colServ.remUser(id));
		
	}
	
	
	
}
