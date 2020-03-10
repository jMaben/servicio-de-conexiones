package com.connections.service.service;

import java.util.List;
import java.util.Optional;

import com.connections.service.models.entity.Connections;

public interface IConnectionsService {
	public List<Connections>listar();
	public Optional<Connections>listarId(int id);
	public int save(Connections c);
	public void delete(int id);
	
	
}
