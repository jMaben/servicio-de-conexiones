package com.connections.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import app.commons.models.entity.Types;

public class TypesService implements ITypesService{

	@Autowired
	private TypesService repository;
	
	
	/*
	 * Este metodo busca todos los objetos de tipo Types en el repositorio, retornando
	 * el resultado en un objeto tipo List.
	 * 
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Types> findAll() {
		return (List<Types>) repository.findAll();
	}

	/*
	 * Recibe un parametro, en este caso uno numerico de tipo Long que se refiere al id del objeto que se desea buscar.
	 * Se realiza una busqueda en el repositorio por dicho id y se devuelve el objeto tipo Types
	 * que se deseaba buscar. 
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public Types findById(Long id) {
		return repository.findById(id);
	}

	/*
	 * Se envia un objeto tipo Types para que se guarde, este se guarda en el repositorio gracias al metodo save
	 * que hereda el cual extiende de PagingAndSortingRepository. 
	 * 
	 * @param type
	 * 
	 * @return
	 */
	@Override
	public Types save(Types type) {
		return repository.save(type);
	}

	/*
	 * Enviando un id se elimina del repositorio un objecto tipo Types.
	 * 
	 * @param id
	 */
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
