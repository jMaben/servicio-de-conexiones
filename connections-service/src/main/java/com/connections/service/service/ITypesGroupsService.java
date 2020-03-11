package com.connections.service.service;

import java.util.List;

import com.connections.service.models.entity.TypesGroups;

public interface ITypesGroupsService {

	public List<TypesGroups> findAll();
	public TypesGroups findById(Long id);
	public TypesGroups save(TypesGroups typeGroups);
	public void deleteById(Long id);
}
