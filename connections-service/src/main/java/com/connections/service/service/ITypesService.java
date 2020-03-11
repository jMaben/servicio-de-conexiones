package com.connections.service.service;

import java.util.List;

import com.connections.service.models.entity.Types;;

public interface ITypesService {

	public List<Types> findAll();
	public Types findById(Long id);
	public Types save(Types type);
	public void deleteById(Long id);
}
