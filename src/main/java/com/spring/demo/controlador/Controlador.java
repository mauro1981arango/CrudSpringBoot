package com.spring.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

import com.spring.demo.interfaceService.InterfacePersonaService;
import com.spring.demo.modelo.Persona;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private InterfacePersonaService service;

	@GetMapping("/listar")
	public String listar(Model modelo) {
		List<Persona> personas = service.listar();
		modelo.addAttribute("personas", personas);
		return "index";
	}

	@GetMapping("/new")
	public String agregar(Model modelo) {
		modelo.addAttribute("persona", new Persona());
		return "form";
	}

	@PostMapping("/save")
	public String save(@Validated Persona p, Model modelo) {
		service.save(p);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model modelo) {
		Optional<Persona> persona = service.listarId(id);
		modelo.addAttribute("persona", persona); 
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model modelo, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
		
	}
}
