package com.jdsk.people.interfaces;


import com.jdsk.people.dtos.PersonDTO;
import com.jdsk.people.entities.Person;
import com.jdsk.people.repositories.PersonRepository;

public interface IPersonService  extends ICrudInterface<Person, PersonDTO,  Long, PersonRepository> {
	
	String test();
	String test2();
	

}
