package com.connections.service.service;

import java.util.List;

import app.commons.models.entity.TypesGroups;

public interface ITypesGroupsService {

	/*
	 * Esta interfaz es la que va a implementar el servicio de TypesGroups.
	 */
	public List<TypesGroups> findAll();
	public TypesGroups findById(Long id);
	public TypesGroups save(TypesGroups typeGroups);
	public void deleteById(Long id);
}
