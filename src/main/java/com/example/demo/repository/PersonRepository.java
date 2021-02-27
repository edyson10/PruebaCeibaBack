package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
