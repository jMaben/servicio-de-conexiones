package com.connections.service.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.connections.service.models.entity.TypesGroups;
import com.connections.service.models.repository.TypesGroupsRepository;

@RestController
public class ControllerTypesGroups {

	@Autowired
	private TypesGroupsRepository serviceTypesGroups;
	
	@GetMapping("/listarTypesGroups")
	public List<TypesGroups> listar(){
		return ((Collection<TypesGroups>) serviceTypesGroups.findAll()).stream().map(Meta ->{
			return Meta;
		}).collect(Collectors.toList());
	}
	
	
	@GetMapping("/verTypesGroups/{id}")
	public TypesGroups detalle(@PathVariable Long id) {
		TypesGroups meta = serviceTypesGroups.findById(id).orElse(null);
		return meta;
	}
	
	@PostMapping("/crearTypesGroups")
	public TypesGroups crear(@RequestBody TypesGroups meta) {
		return serviceTypesGroups.save(meta);
	}
	
	
	@PutMapping("/editarTypesGroups/{id}")
	public TypesGroups editar(@RequestBody TypesGroups type, @PathVariable Long id) {
		TypesGroups typesGroups = serviceTypesGroups.findById(id).orElse(null);
		typesGroups.setDescription(type.getDescription());
		typesGroups.setTypeGroup(type.getTypeGroup());
		return typesGroups;
	}
	
	
	@DeleteMapping("/eliminarTypesGroups/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable long id) {
		serviceTypesGroups.deleteById(id);
	}
}
