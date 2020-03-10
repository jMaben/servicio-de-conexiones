package com.connections.service.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.connections.service.models.entity.Connections;
import com.connections.service.service.ConnectionsService;


@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {

	
	@Autowired
	private ConnectionsService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Connections>conexiones=service.listar();
		model.addAttribute("conexiones", conexiones);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("connections", new Connections());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Valid Connections c, Model model) {
		service.save(c);
		return "redirect:/listar";
	}
	
	public String editar(@PathVariable int id, Model model) {
		Optional<Connections>conexiones=service.listarId(id);
		model.addAttribute("conexiones",conexiones);
		return "form";
	}
}
