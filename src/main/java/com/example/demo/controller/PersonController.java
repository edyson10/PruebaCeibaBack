package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Person;
import com.example.demo.repository.PersonRepository;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/persona/listar")
	private List<Person> listarPersona(){
		return (List<Person>) personRepository.findAll();
	}
	
	@PostMapping("/persona/registrar")
	public Person guardar(@RequestBody Person person) {
		Person p = new Person();
		p.setNombre(person.getNombre());
		p.setApellido(person.getApellido());
		p.setCedula(person.getCedula());
		p.setFecha_nacimiento(person.getFecha_nacimiento());
		return personRepository.save(p);
	}
}
