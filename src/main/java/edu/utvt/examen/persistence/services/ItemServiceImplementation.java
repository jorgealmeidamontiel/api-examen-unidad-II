package edu.utvt.examen.persistence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.utvt.examen.persistence.entities.Item;
import edu.utvt.examen.persistence.repositories.ItemRepository;

@Service
@Transactional
public class ItemServiceImplementation implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;

	@Transactional(readOnly = false)
	public Item save(Item item) {
		return this.itemRepository.save(item);
	}

	@Transactional(readOnly = false)
	public Item update(Long id, Item item) {
		
		Optional<Item> optionalItem = null;
		optionalItem = this.findById(id);
		
		
		if (optionalItem.isPresent()) {
			optionalItem.get().setNombre(item.getNombre());
			optionalItem.get().setPrecio(item.getPrecio());
			this.itemRepository.save(optionalItem.get());
		}
		
		return optionalItem.orElseThrow();
	}

	@Override
	public List<Item> findAll() {
		return this.itemRepository.findAll();
	}

	@Override
	public Optional<Item> findById(Long id) {
		return this.itemRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		this.itemRepository.deleteById(id);
	}

	@Override
	public Page<Item> findAll(Integer page, Integer size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("nombre"));
		return this.itemRepository.findAll(pageRequest);
	}

}
