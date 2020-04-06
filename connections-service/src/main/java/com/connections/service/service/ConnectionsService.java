package com.connections.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.connections.service.models.repository.ConnectionsRepository;

import app.commons.models.entity.Connections;

@Service
public class ConnectionsService implements IConnectionsService{


	@Autowired
	private ConnectionsRepository repository;

	/*
	 * Este metodo busca todos los objetos de tipo Connections en el repositorio, retornando
	 * el resultado en un objeto tipo List.
	 * 
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Connections> findAll() {
		return (List<Connections>) repository.findAll();
	}

	/*
	 * Recibe un parametro, en este caso uno numerico de tipo Long que se refiere al id del objeto que se desea buscar.
	 * Se realiza una busqueda en el repositorio por dicho id y se devuelve el objeto tipo Connections
	 * que se deseaba buscar. 
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public Connections findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	/*
	 * Se envia un objeto tipo Connections para que se guarde, este se guarda en el repositorio gracias al metodo save
	 * que hereda el cual extiende de PagingAndSortingRepository. 
	 * 
	 * @param c
	 * 
	 * @return
	 */
	@Override
	@Transactional
	public Connections save(Connections c) {
		return repository.save(c);
	}

	/*
	 * Enviando un id se elimina del repositorio un objecto tipo Connections.
	 * 
	 * @param id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}