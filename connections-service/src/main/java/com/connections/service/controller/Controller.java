package com.connections.service.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.connections.service.models.entity.Connections;
import com.connections.service.models.entity.Metadates;
import com.connections.service.models.repository.MetadatesRepository;
import com.connections.service.service.ConnectionsService;
import com.connections.service.service.MetadatesService;


@RestController
public class Controller {

	
	@Autowired
	private ConnectionsService service;
	
	@CrossOrigin
	@GetMapping("/listar")
	public List<Connections> listar(Model model) {
		return ((Collection<Connections>) service.findAll()).stream().map(Meta ->{
			return Meta;
		}).collect(Collectors.toList());
	}
	
	@CrossOrigin
	@GetMapping("/verConnections/{id}")
	public Connections detalle(@PathVariable Long id) {
		Connections c = service.findById(id);
		return c;
	}
	
	
	@PostMapping("/crearConnections")
	public Connections crear(@RequestBody Connections c) {
		return service.save(c);
	}
	
	
	
	@PutMapping("/editarConnections/{id}")
	public Connections editar(@RequestBody Connections connec, @PathVariable Long id) {
		Connections c = service.findById(id);
		c.setAlias(connec.getAlias());
		c.setUser(connec.getUser());
		c.setHost(connec.getHost());
		c.setPort(connec.getPort());
		c.setPass(connec.getPass());
		c.setIdType(connec.getIdType());
		c.setCreatedData(connec.getCreatedData());
		c.setActive(connec.isActive());
		return c;
	}	
	
	@DeleteMapping("/eliminarConnections/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable long id) {
		service.deleteById(id);
	}
	
}