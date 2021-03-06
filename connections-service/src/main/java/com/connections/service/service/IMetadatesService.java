package com.connections.service.service;

import java.util.List;

import app.commons.models.entity.Metadates;

public interface IMetadatesService {

	/**
	 * Esta interfaz es la que va a implementar el servicio de Metadates.
	 */
	public List<Metadates> findAll();
	public Metadates findById(Long id);
	public Metadates save(Metadates metadates);
	public void deleteById(Long id);
	public List<Metadates> findAllConnectionMetadates(Long id);

}
