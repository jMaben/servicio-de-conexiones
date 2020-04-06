package com.connections.service.service;

import java.util.List;

import app.commons.models.entity.Types;

/**
 * Esta interfaz es la que va a implementar el servicio de Types.
 */
public interface ITypesService {
	
	public List<Types> findAll();
	public Types findById(Long id);
	public Types save(Types type);
	public void deleteById(Long id);
}
