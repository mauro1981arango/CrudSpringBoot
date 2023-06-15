package com.spring.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.modelo.Persona;

@Repository
public interface InterfacePersona extends CrudRepository<Persona, Integer> {

}
