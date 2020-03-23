package com.connections.service.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.connections.service.service.ConnectionsService;

import app.commons.models.entity.Connections;


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
	
	@CrossOrigin
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/crearConnections")
	public Connections crear(@RequestBody Connections c) {
		//CreatedData opcion de fecha
		if (c.getCreatedData() == null) {
			LocalDate localDate = LocalDate.now();
			Date date = new Date(localDate.atStartOfDay(ZoneId.of("Europe/Paris")).toEpochSecond() * 1000);
			c.setCreatedData(date);
		}
		return service.save(c);
	}
	
	
	@CrossOrigin
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/editarConnections/{id}")
	public void editar(@RequestBody Connections connec, @PathVariable Long id) {
		Connections c = service.findById(id);
		c.setAlias(connec.getAlias());
		c.setUser(connec.getUser());
		c.setHost(connec.getHost());
		c.setPort(connec.getPort());
		c.setPass(connec.getPass());
		c.setTypes(connec.getTypes());
		c.setActive(connec.isActive());
		service.save(c);
	}	
	
	@CrossOrigin
	@DeleteMapping("/eliminarConnections/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable long id) {
		service.deleteById(id);
	}
	
}