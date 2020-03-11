package com.connections.service.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<Connections> listarId(int id) {
		return repository.findById((long) id);
	}

	@Override
	public int save(Connections c) {
		int res=0;
		Connections connec =repository.save(c);
		if (!connec.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		//Connections connec = repository.findById((long) id);
		//repository.delete(connec);
	}

}
