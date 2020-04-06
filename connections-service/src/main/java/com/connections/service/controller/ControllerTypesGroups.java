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

import com.connections.service.models.repository.TypesGroupsRepository;

import app.commons.models.entity.TypesGroups;

@RestController
public class ControllerTypesGroups {

	@Autowired
	private TypesGroupsRepository serviceTypesGroups;
	
	/*
	 * Es un metodo http el cual retorna una lista de objetos TypesGroups que previamente se han buscado
	 * y se han combertido a una lista tipo List.
	 * 
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/listarTypesGroupsGroups")
	public List<TypesGroups> listar(){
		return ((Collection<TypesGroups>) serviceTypesGroups.findAll()).stream().map(Meta ->{
			return Meta;
		}).collect(Collectors.toList());
	}
	
	/*
	 * Es un metodo http el cual retorna un objeto TypesGroups, previamente se ha buscado por
	 * su id que este lo recive por la llamada http como parametro.
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@GetMapping("/verTypesGroups/{id}")
	public TypesGroups detalle(@PathVariable Long id) {
		TypesGroups meta = serviceTypesGroups.findById(id).orElse(null);
		return meta;
	}
	
	/*
	 * Este metodo añade un nuevo objeto TypesGroups. Recibe uno por por el http tipo POST
	 * y finalmente lo guarda.
	 * 
	 * @param meta
	 * 
	 * @return
	 */
	@PostMapping("/crearTypesGroups")
	public TypesGroups crear(@RequestBody TypesGroups meta) {
		return serviceTypesGroups.save(meta);
	}
	
	/*
	 * Este metodo edita un objeto tipo TypesGroups ya registrado, revice un id mas un objecto. Se busca
	 * el objeto con el id y se edita con los datos del otro objeto previamente recibido.
	 * 
	 * @param type
	 * @param id
	 * 
	 * @return
	 */
	@PutMapping("/editarTypesGroups/{id}")
	public TypesGroups editar(@RequestBody TypesGroups type, @PathVariable Long id) {
		TypesGroups typesGroups = serviceTypesGroups.findById(id).orElse(null);
		typesGroups.setDescription(type.getDescription());
		typesGroups.setTypeGroup(type.getTypeGroup());
		return typesGroups;
	}
	
	
	/*
	 * Este metodo elimina un objeto TypesGroups ya existente, recibiendo un id por la peticion http.
	 * 
	 * @param id
	 */
	@DeleteMapping("/eliminarTypesGroups/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable long id) {
		serviceTypesGroups.deleteById(id);
	}
}
