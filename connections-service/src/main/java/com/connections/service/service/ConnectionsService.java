package com.connections.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.connections.service.app.commons.models.entity.Connections;
import com.connections.service.models.repository.ConnectionsRepository;

@Service
public class ConnectionsService implements IConnectionsService{

	@Autowired
	private ConnectionsRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Connections> findAll() {
		return (List<Connections>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Connections findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Connections save(Connections c) {
		return repository.save(c);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}