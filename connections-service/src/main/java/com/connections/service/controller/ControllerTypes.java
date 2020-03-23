package com.connections.service.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.connections.service.models.repository.TypesRepository;

import app.commons.models.entity.Types;

@RestController
public class ControllerTypes {
	
	@Autowired
	private TypesRepository serviceTypes;
	
	@CrossOrigin
	@GetMapping("/listarTypes")
	public List<Types> listar(){
		return ((Collection<Types>) serviceTypes.findAll()).stream().map(Type->{
			return Type;
		}).collect(Collectors.toList());
	}
	
	
	@GetMapping("/verTypes/{id}")
	public Types detalle(@PathVariable Long id) {
		Types type = serviceTypes.findById(id).orElse(null);
		return type;
	}
	
	@PostMapping("/crearTypes")
	public Types crear(@RequestBody Types type) {
		return serviceTypes.save(type);
	}
	
	
	@PutMapping("/editarTypes/{id}")
	public Types editar(@RequestBody Types type, @PathVariable Long id) {
		Types typeDB = serviceTypes.findById(id).orElse(null);
		typeDB.setDescription(type.getDescription());
		typeDB.setDriver(type.getDriver());
		typeDB.setType(type.getType());
		return typeDB;
	}
	
	
	@DeleteMapping("/eliminarTypes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable long id) {
		serviceTypes.deleteById(id);
	}
}
