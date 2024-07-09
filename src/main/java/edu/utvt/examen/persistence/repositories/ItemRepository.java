package edu.utvt.examen.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.examen.persistence.entities.Item;
import java.util.List;


public interface ItemRepository extends JpaRepository<Item, Long> {
	
	List<Item> findByNombre(String nombre);

}
