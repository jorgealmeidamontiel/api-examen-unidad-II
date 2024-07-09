package edu.utvt.examen.persistence.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.examen.persistence.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, UUID> {
	
	List<Persona> findByNombre(String nombre); 

}
