package com.connections.service.service;

import java.util.List;

import app.commons.models.entity.Metadates;

public interface IMetadatesService {

	public List<Metadates> findAll();
	public Metadates findById(Long id);
	public Metadates save(Metadates metadates);
	public void deleteById(Long id);

}
