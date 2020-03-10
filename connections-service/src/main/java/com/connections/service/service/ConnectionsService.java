package com.connections.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connections.service.models.entity.Connections;
import com.connections.service.models.repository.ConnectionsRepository;

@Service
public class ConnectionsService implements IConnectionsService{

	@Autowired
	private ConnectionsRepository repository;
	
	@Override
	public List<Connections> listar() {
		return (List<Connections>) repository.findAll();
	}

}
