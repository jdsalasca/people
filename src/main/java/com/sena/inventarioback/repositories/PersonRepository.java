package com.sena.inventarioback.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.inventarioback.models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	Optional<Person> findByUserName(String userName);

	List<Person> findAllByDocumentType(Integer documentTypeId);

}
