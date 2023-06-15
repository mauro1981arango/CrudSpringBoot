package com.spring.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.spring.demo.modelo.Persona;

public interface InterfacePersonaService {

	public List<Persona>listar();
	public Optional<Persona>listarId(int id);
	public int save(Persona p);
	public void delete(int id);
}
