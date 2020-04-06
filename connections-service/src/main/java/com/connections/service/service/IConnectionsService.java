package com.connections.service.service;

import java.util.List;

import app.commons.models.entity.Connections;

public interface IConnectionsService {
	
	/*
	 * Esta interfaz es la que va a implementar el servicio de Connections.
	 */
	public List<Connections>findAll();
	public Connections findById(Long id);
	public Connections save(Connections c);
	public void deleteById(Long id);
	
}
