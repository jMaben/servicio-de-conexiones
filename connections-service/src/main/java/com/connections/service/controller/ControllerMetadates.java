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

import com.connections.service.models.entity.Metadates;
import com.connections.service.models.repository.MetadatesRepository;

@RestController
public class ControllerMetadates {
	
	@Autowired
	private MetadatesRepository serviceMetadates;
	
	@GetMapping("/listarMetadates")
	public List<Metadates> listar(){
		return ((Collection<Metadates>) serviceMetadates.findAll()).stream().map(Meta ->{
			return Meta;
		}).collect(Collectors.toList());
	}
	
	
	@GetMapping("/verMetadates/{id}")
	public Metadates detalle(@PathVariable Long id) {
		Metadates meta = serviceMetadates.findById(id).orElse(null);
		return meta;
	}
	
	@PostMapping("/crearMetadates")
	public Metadates crear(@RequestBody Metadates meta) {
		return serviceMetadates.save(meta);
	}
	
	
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
	
	
	@DeleteMapping("/eliminarMetadates/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable long id) {
		serviceMetadates.deleteById(id);
	}
	
}
