package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.interfaceService.InterfacePersonaService;
import com.spring.demo.interfaces.InterfacePersona;
import com.spring.demo.modelo.Persona;

@Service
public class PersonaService implements InterfacePersonaService {

	@Autowired
	private InterfacePersona data;
	
	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return (List<Persona>) data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Persona p) {
		int resp = 0;
		Persona persona = data.save(p);
		if(!persona.equals(null)) {
			resp = 1;
		}
		return resp;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
		
	}

}
