package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/persona/listar")
	private List<Person> listarPersona() {
		return (List<Person>) personRepository.findAll();
	}

	@PostMapping("/persona/registrar")
	public Person guardar(@RequestBody Person person) {
		Person p = new Person();
		Calendar fecha = new GregorianCalendar();
		int año = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		p.setNombre(person.getNombre());
		p.setApellido(person.getApellido());
		p.setCedula(person.getCedula());
		p.setFecha_nacimiento(person.getFecha_nacimiento());
		/*
		String[] añoNacimiento = person.getFecha_nacimiento().split("-");
		int edad = año - Integer.parseInt(añoNacimiento[0]);
		String res = "";
		if (edad > 18) {
			personRepository.save(person);
			res = "exito";
		} else {
			res = "error";
		}*/
		
		return personRepository.save(person);
	}
}
