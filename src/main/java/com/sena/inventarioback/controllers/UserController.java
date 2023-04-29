package com.sena.inventarioback.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.inventarioback.dto.PersonDTO;
import com.sena.inventarioback.interfaces.IPersonService;
import com.sena.inventarioback.models.Person;
import com.sena.inventarioback.utils.response.DefaultResponse;

import lombok.extern.slf4j.Slf4j;

//Api-RestFul
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

	@Autowired
	IPersonService iPersonService;

	@GetMapping
	public ResponseEntity<DefaultResponse<Person>> findAll() {
		return iPersonService.findAll();
	}

	// EndPoint
	@GetMapping("{id}")
	public ResponseEntity<DefaultResponse<Person>> findById(@PathVariable Integer id) {
		return iPersonService.findById(id);
	}

	// EndPoint
	@GetMapping("/document-type/{documentTypeId}")
	public List<Person> findByDocumentTypeId(@PathVariable Integer documentTypeId) {
		return iPersonService.findByDocumentTypeId(documentTypeId);
	}
    @PostMapping("")
    public ResponseEntity<DefaultResponse<Person>> createPerson(@Validated @RequestBody PersonDTO personDTO,
                                                                    BindingResult bindingResult) {
    	log.info("user which is performing the operation {}", "not implement yet");
        return iPersonService.save(personDTO, bindingResult, Person.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse<Person>> updatePerson(@PathVariable Integer id,
                                                                    @Validated @RequestBody PersonDTO personDTO,
                                                                    BindingResult bindingResult) {
    	log.info("user which is performing the operation {}", "not implement yet");
        return iPersonService.update(id, personDTO, bindingResult, Person.class);
    }

	

}
