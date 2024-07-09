package edu.utvt.examen.persistence.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.utvt.examen.persistence.entities.Persona;
import edu.utvt.examen.persistence.repositories.PersonaRepository;

@Service
@Transactional
public class PersonaServiceImplementation implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;

	@Transactional(readOnly = false)
	public Persona update(UUID id, Persona persona) {
		
		Optional<Persona> optionalPersona = null;
		optionalPersona = this.personaRepository.findById(id);
		
		if (optionalPersona.isPresent()) {
			optionalPersona.get().setNombre(persona.getNombre());
			optionalPersona.get().setEdad(persona.getEdad());
			optionalPersona.get().setUniversidad(persona.getUniversidad());
			optionalPersona.get().setEmail(persona.getEmail());
			optionalPersona.get().setBirthDate(persona.getBirthDate());
			
			this.personaRepository.save(optionalPersona.get());
		}
		
		return optionalPersona.orElseThrow();
	}

	@Override
	public List<Persona> findAll() {
		return this.personaRepository.findAll();
	}

	@Override
	public Optional<Persona> findById(UUID id) {
		return this.personaRepository.findById(id);
	}

	@Transactional(readOnly = false)
	public void deleteById(UUID id) {
		this.personaRepository.deleteById(id);
	}

	@Override
	public Page<Persona> findAll(Integer page, Integer size) {
		PageRequest pageRequest =  PageRequest.of(page, size, Sort.by("nombre"));
		return this.personaRepository.findAll(pageRequest);
	}

	@Transactional(readOnly = false)
	public Persona save(Persona persona) {
		this.personaRepository.save(persona);
		return persona;
	}

}
