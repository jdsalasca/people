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
import com.jdsk.people.dtos.DailyRoutineDto;
import com.jdsk.people.dtos.PersonDTO;
import com.jdsk.people.entities.DailyRoutine;
import com.jdsk.people.entities.Person;
import com.jdsk.people.interfaces.IDailyRoutineService;
import com.jdsk.people.interfaces.IPersonService;
import com.jdsk.people.utils.response.DefaultResponse;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/daily-routine")
@RequiredArgsConstructor
public class DailyRoutineController {
	
	   private final IDailyRoutineService iDailyRoutineService;



	    @GetMapping("")
	    @Cacheable("personCache")
	    public ResponseEntity<DefaultResponse<DailyRoutine>> getAll() {
	        return iDailyRoutineService.getAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<DefaultResponse<DailyRoutine>> getById(@PathVariable Integer id) {
	        return iDailyRoutineService.getById(id);
	    }

	    @PostMapping("")
	    public ResponseEntity<DefaultResponse<DailyRoutine>> createPerson(@Validated @RequestBody DailyRoutineDto entityDTO,
	                                                                    BindingResult bindingResult) {
	        return iDailyRoutineService.save(entityDTO, bindingResult, DailyRoutine.class);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<DefaultResponse<DailyRoutine>> updatePerson(@PathVariable Integer id,
	                                                                    @Validated @RequestBody DailyRoutineDto entityDTO,
	                                                                    BindingResult bindingResult) {
	        return iDailyRoutineService.update(id, entityDTO, bindingResult, DailyRoutine.class);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
	    	iDailyRoutineService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

	

}
