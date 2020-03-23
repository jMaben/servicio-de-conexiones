package com.connections.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import app.commons.models.entity.Types;

public class TypesService implements ITypesService{

	@Autowired
	private TypesService repository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Types> findAll() {
		return (List<Types>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Types findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Types save(Types type) {
		return repository.save(type);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
