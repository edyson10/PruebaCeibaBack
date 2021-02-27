package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Persona;
import com.example.demo.repository.PersonaRepository;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/persona/listar")
	private List<Persona> listarPersona(){
		return (List<Persona>) personaRepository.findAll();
	}
}
