package com.connections.service.service;

import java.util.List;
import java.util.Optional;

import com.connections.service.models.entity.Connections;
import com.connections.service.models.entity.Metadates;

public interface IConnectionsService {
	public List<Connections>findAll();
	public Connections findById(Long id);
	public Connections save(Connections c);
	public void deleteById(Long id);
	
}
