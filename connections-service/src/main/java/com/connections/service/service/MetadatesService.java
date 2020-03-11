package com.connections.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.connections.service.models.entity.Metadates;
import com.connections.service.models.repository.MetadatesRepository;

public class MetadatesService implements IMetadatesService{

	@Autowired
	private MetadatesRepository repository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Metadates> findAll() {
		return (List<Metadates>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Metadates findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Metadates save(Metadates metadates) {
		return repository.save(metadates);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
