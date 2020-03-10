package com.connections.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		List<Connections>connec=service.listar();
		model.addAttribute("conexiones", connec);
		return "index";
	}
}
