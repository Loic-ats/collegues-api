package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer>{

	@Query("select c.matricule from Collegue c ")
	List<String> findMatricule();

	

	List<Collegue>findAllBynom(String nom);


	@Query("select c from Collegue c where c.matricule=?1")
	Optional<Collegue> findByMatricule(String matricule);


	@Query("select c.matricule from Collegue c where c.id=?1")
	Optional<String> findMatriculeById(Integer id);


	@Query("select c.matricule from Collegue c where c.nom=?1")
	Optional<String> findMatriculeByNom(String nom);



	
	
}
