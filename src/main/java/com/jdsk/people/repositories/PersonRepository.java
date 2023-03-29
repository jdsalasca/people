package com.jdsk.people.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jdsk.people.entities.Person;

@Component
public interface PersonRepository extends JpaRepository<Person, Long> {

    
}