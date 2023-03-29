package com.jdsk.people.servicies;


import java.util.concurrent.Executor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.jdsk.people.dtos.PersonDTO;
import com.jdsk.people.entities.Person;
import com.jdsk.people.interfaces.IPersonService;
import com.jdsk.people.repositories.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonService extends CrudServiceImpl<Person, PersonDTO, Long, PersonRepository>
implements IPersonService  {
//	private final PersonRepository personRepository;
//	private final ModelMapper modalMapper;
	

    @Autowired
    @Qualifier("taskExecutor")
    private ThreadPoolTaskExecutor  executor;
    //private Executor executor;
	
	
    public PersonService(PersonRepository repository, ModelMapper modelMapper) {
		super(repository, modelMapper);
//		this.personRepository = repository;
//		this.modalMapper = modelMapper;
	}

	@Override
	@Cacheable("heavyTask")
	public void onExecuteMultipleTasks() {
		int i;
		for (i = 0; i <10; i++) {
			 final int index = i;
			 executor.submit(() -> task_heavy(index));
			//task_heavy();
		}
		
	}
	
	public void task_heavy (int i) {
		try {
			log.info("executing {}", i);
			Thread.sleep(5000);
			log.info("DONE!!");
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
   
}