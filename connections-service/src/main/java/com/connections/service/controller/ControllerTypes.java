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
	
	/*
	 * Es un metodo http el cual retorna una lista de objetos Types que previamente se han buscado
	 * y se han combertido a una lista tipo List.
	 * 
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/listarTypes")
	public List<Types> listar(){
		return ((Collection<Types>) serviceTypes.findAll()).stream().map(Type->{
			return Type;
		}).collect(Collectors.toList());
	}
	
	
	/*
	 * Es un metodo http el cual retorna un objeto Types, previamente se ha buscado por
	 * su id que este lo recive por la llamada http como parametro.
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@GetMapping("/verTypes/{id}")
	public Types detalle(@PathVariable Long id) {
		Types type = serviceTypes.findById(id).orElse(null);
		return type;
	}
	
	/*
	 * Este metodo añade un nuevo objeto Types. Recibe uno por por el http tipo POST
	 * y finalmente lo guarda.
	 * 
	 * @param type
	 * 
	 * @return
	 */
	@PostMapping("/crearTypes")
	public Types crear(@RequestBody Types type) {
		return serviceTypes.save(type);
	}
	
	
	/*
	 * Este metodo edita un objeto tipo Types ya registrado, revice un id mas un objecto. Se busca
	 * el objeto con el id y se edita con los datos del otro objeto previamente recibido.
	 * 
	 * @param type
	 * @param id
	 * 
	 * @return
	 */
	@PutMapping("/editarTypes/{id}")
	public Types editar(@RequestBody Types type, @PathVariable Long id) {
		Types typeDB = serviceTypes.findById(id).orElse(null);
		typeDB.setDescription(type.getDescription());
		typeDB.setDriver(type.getDriver());
		typeDB.setType(type.getType());
		return typeDB;
	}
	
	
	/*
	 * Este metodo elimina un objeto Types ya existente, recibiendo un id por la peticion http.
	 * 
	 * @param id
	 */
	@DeleteMapping("/eliminarTypes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable long id) {
		serviceTypes.deleteById(id);
	}
}
