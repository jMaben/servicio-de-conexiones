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
	
	/**
	 * Es un metodo http el cual retorna una lista de objetos Connections que previamente se han buscado
	 * y se han combertido a una lista tipo List.
	 * 
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/listar")
	public List<Connections> listar(Model model) {
		return ((Collection<Connections>) service.findAll()).stream().map(Meta ->{
			return Meta;
		}).collect(Collectors.toList());
	}
	
	/**
	 * Es un metodo http el cual retorna un objeto Connections, previamente se ha buscado por
	 * su id que este lo recive por la llamada http como parametro.
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/verConnections/{id}")
	public Connections detalle(@PathVariable Long id) {
		Connections c = service.findById(id);
		return c;
	}
	
	/**
	 * Este metodo añade un nuevo objeto Connections. Recibe uno por por el http tipo POST, 
	 * si no tiene fecha se la añade y finalmente lo guarda.
	 * 
	 * @param c
	 * 
	 * @return
	 */
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
	
	/**
	 * Este metodo edita un objeto tipo Connections ya registrado, revice un id mas un objecto. Se busca
	 * el objeto con el id y se edita con los datos del otro objeto previamente recibido.
	 * 
	 * @param connec
	 * @param id
	 * 
	 * @return
	 */
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
	
	/**
	 * Este metodo elimina un objeto Connections ya existente, recibiendo un id por la peticion http.
	 * 
	 * @param id
	 */
	@CrossOrigin
	@DeleteMapping("/eliminarConnections/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable long id) {
		service.deleteById(id);
	}
	
}