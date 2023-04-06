package com.jdsk.people.controllers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;import com.jdsk.people.PeopleApplication;
import com.jdsk.people.dtos.PersonDTO;
import com.jdsk.people.entities.Person;
import com.jdsk.people.interfaces.IPersonService;
import com.jdsk.people.utils.response.DefaultResponse;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
	
	   private final IPersonService ipersonService;



	    @GetMapping("")
	    @Cacheable("personCache")
	    public ResponseEntity<DefaultResponse<Person>> getAll() {
	        return ipersonService.getAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<DefaultResponse<Person>> getById(@PathVariable Long id) {
	        return ipersonService.getById(id);
	    }

	    @PostMapping("")
	    public ResponseEntity<DefaultResponse<Person>> createPerson(@Validated @RequestBody PersonDTO personDTO,
	                                                                    BindingResult bindingResult) {
	        return ipersonService.save(personDTO, bindingResult, Person.class);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<DefaultResponse<Person>> updatePerson(@PathVariable Long id,
	                                                                    @Validated @RequestBody PersonDTO personDTO,
	                                                                    BindingResult bindingResult) {
	        return ipersonService.update(id, personDTO, bindingResult, Person.class);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
	    	ipersonService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

	

}
