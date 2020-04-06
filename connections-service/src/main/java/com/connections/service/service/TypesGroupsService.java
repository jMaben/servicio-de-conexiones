package com.connections.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.connections.service.models.repository.TypesGroupsRepository;

import app.commons.models.entity.TypesGroups;

public class TypesGroupsService implements ITypesGroupsService{

	@Autowired
	private TypesGroupsRepository repository;
	
	
	/*
	 * Este metodo busca todos los objetos de tipo TypesGroups en el repositorio, retornando
	 * el resultado en un objeto tipo List.
	 * 
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public List<TypesGroups> findAll() {
		return (List<TypesGroups>) repository.findAll();
	}

	/*
	 * Recibe un parametro, en este caso uno numerico de tipo Long que se refiere al id del objeto que se desea buscar.
	 * Se realiza una busqueda en el repositorio por dicho id y se devuelve el objeto tipo TypesGroups
	 * que se deseaba buscar. 
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public TypesGroups findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	/*
	 * Se envia un objeto tipo TypesGroups para que se guarde, este se guarda en el repositorio gracias al metodo save
	 * que hereda el cual extiende de PagingAndSortingRepository. 
	 * 
	 * @param typeGroups
	 * 
	 * @return
	 */
	@Override
	public TypesGroups save(TypesGroups typeGroups) {
		return repository.save(typeGroups);
	}

	/*
	 * Enviando un id se elimina del repositorio un objecto tipo TypesGroups.
	 * 
	 * @param id
	 */
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
