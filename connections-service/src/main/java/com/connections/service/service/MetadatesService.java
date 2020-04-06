package com.connections.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.connections.service.models.repository.MetadatesRepository;

import app.commons.models.entity.Metadates;

public class MetadatesService implements IMetadatesService{

	@Autowired
	private MetadatesRepository repository;
	
	/**
	 * Este metodo busca todos los objetos de tipo Metadates en el repositorio, retornando
	 * el resultado en un objeto tipo List.
	 * 
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Metadates> findAll() {
		return (List<Metadates>) repository.findAll();
	}

	/**
	 * Recibe un parametro, en este caso uno numerico de tipo Long que se refiere al id del objeto que se desea buscar.
	 * Se realiza una busqueda en el repositorio por dicho id y se devuelve el objeto tipo Metadates
	 * que se deseaba buscar. 
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public Metadates findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	/**
	 * Se envia un objeto tipo Metadates para que se guarde, este se guarda en el repositorio gracias al metodo save
	 * que hereda el cual extiende de PagingAndSortingRepository. 
	 * 
	 * @param metadates
	 * 
	 * @return
	 */
	@Override
	public Metadates save(Metadates metadates) {
		return repository.save(metadates);
	}

	/**
	 * Enviando un id se elimina del repositorio un objecto tipo Metadates.
	 * 
	 * @param id
	 */
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
