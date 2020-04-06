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

import com.connections.service.models.repository.MetadatesRepository;

import app.commons.models.entity.Metadates;

@RestController
public class ControllerMetadates {
	
	@Autowired
	private MetadatesRepository serviceMetadates;
	
	
	/*
	 * Es un metodo http el cual retorna una lista de objetos Metadates que previamente se han buscado
	 * y se han combertido a una lista tipo List.
	 * 
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/listarMetadates")
	public List<Metadates> listar(){
		return ((Collection<Metadates>) serviceMetadates.findAll()).stream().map(Meta ->{
			return Meta;
		}).collect(Collectors.toList());
	}
	
	
	/*
	 * Es un metodo http el cual retorna un objeto Metadates, previamente se ha buscado por
	 * su id que este lo recive por la llamada http como parametro.
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@GetMapping("/verMetadates/{id}")
	public Metadates detalle(@PathVariable Long id) {
		Metadates meta = serviceMetadates.findById(id).orElse(null);
		return meta;
	}
	
	/*
	 * Este metodo añade un nuevo objeto Metadates. Recibe uno por por el http tipo POST
	 * y finalmente lo guarda.
	 * 
	 * @param meta
	 * 
	 * @return
	 */
	@PostMapping("/crearMetadates")
	public Metadates crear(@RequestBody Metadates meta) {
		return serviceMetadates.save(meta);
	}
	
	/*
	 * Este metodo edita un objeto tipo Metadates ya registrado, revice un id mas un objecto. Se busca
	 * el objeto con el id y se edita con los datos del otro objeto previamente recibido.
	 * 
	 * @param meta
	 * @param id
	 * 
	 * @return
	 */
	@PutMapping("/editarMetadates/{id}")
	public Metadates editar(@RequestBody Metadates meta, @PathVariable Long id) {
		Metadates metadate = serviceMetadates.findById(id).orElse(null);
		metadate.setMetadate(meta.getMetadate());
		metadate.setActive(meta.isActive());
		metadate.setDescription(meta.getDescription());
		metadate.setIdParent(meta.getIdParent());
		metadate.setLevel(meta.getLevel());
		return metadate;
	}
	
	/*
	 * Este metodo elimina un objeto Metadates ya existente, recibiendo un id por la peticion http.
	 * 
	 * @param id
	 */
	@DeleteMapping("/eliminarMetadates/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable long id) {
		serviceMetadates.deleteById(id);
	}
	
}
