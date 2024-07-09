package edu.utvt.examen.persistence.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

import edu.utvt.examen.persistence.entities.Item;
import edu.utvt.examen.persistence.entities.Persona;

public interface PersonaService {
	
	public Persona save(Persona persona);
	
	public Persona update(UUID id, Persona persona);
	
	public List<Persona> findAll();
	
	public Optional<Persona> findById(UUID id);
	
	public void deleteById(UUID id);
	
	public Page<Persona> findAll(Integer page, Integer size);

}
