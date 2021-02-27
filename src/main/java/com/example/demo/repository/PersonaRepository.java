package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}
