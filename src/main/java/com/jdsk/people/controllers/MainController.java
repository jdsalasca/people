package com.jdsk.people.controllers;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdsk.people.dtos.PersonDTO;
import com.jdsk.people.entities.Person;
import com.jdsk.people.interfaces.ICrudInterface;
import com.jdsk.people.interfaces.IPersonService;
import com.jdsk.people.repositories.PersonRepository;
import com.jdsk.people.utils.response.DefaultResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("")
public class MainController {
	
	   private final IPersonService ipersonService;



	    @GetMapping("")
	    @Cacheable("personCache")
	    public ResponseEntity<DefaultResponse<Person>> getAll() {
	    	log.info("finally");
	        return ipersonService.getAll();
	    }



}
