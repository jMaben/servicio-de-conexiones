package com.connections.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.connections.service.models.entity.TypesGroups;
import com.connections.service.models.repository.TypesGroupsRepository;

public class TypesGroupsService implements ITypesGroupsService{

	@Autowired
	private TypesGroupsRepository repository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<TypesGroups> findAll() {
		return (List<TypesGroups>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TypesGroups findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public TypesGroups save(TypesGroups typeGroups) {
		return repository.save(typeGroups);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
