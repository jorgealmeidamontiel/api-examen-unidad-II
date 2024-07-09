package edu.utvt.examen.persistence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import edu.utvt.examen.persistence.entities.Item;

public interface ItemService {

	public Item save(Item item);

	public Item update(Long id, Item item);

	public List<Item> findAll();

	public Optional<Item> findById(Long id);

	public void deleteById(Long id);

	public Page<Item> findAll(Integer page, Integer size);

}
