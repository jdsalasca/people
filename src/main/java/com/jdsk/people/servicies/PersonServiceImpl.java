package com.jdsk.people.servicies;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jdsk.people.dtos.PersonDTO;
import com.jdsk.people.entities.DailyRoutine;
import com.jdsk.people.entities.Person;
import com.jdsk.people.events.PaymentPlacedEvent;
import com.jdsk.people.interfaces.IDailyRoutineService;
import com.jdsk.people.interfaces.IPersonService;
import com.jdsk.people.repositories.PersonRepository;
import com.jdsk.people.utils.response.DefaultResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl extends CrudServiceImpl<Person, PersonDTO, Long, PersonRepository>
implements IPersonService  {
	private final PersonRepository personRepository;
	private final ModelMapper modalMapper;
	private final KafkaTemplate<String, PaymentPlacedEvent> kafkaTemplate;
	
	private  final IDailyRoutineService iDailyRoutineService;

	@Override
	public ResponseEntity<DefaultResponse<Person>> save(PersonDTO dto, BindingResult bindingResult,
			Class<Person> entityClass) {
		
		 ResponseEntity<DefaultResponse<DailyRoutine>> response= iDailyRoutineService.getById(1);
		 
		 DailyRoutine found =  response.getBody().getData().get(0);
		
		return super.save(dto, bindingResult, entityClass);
	}
	@Override
	public ResponseEntity<DefaultResponse<Person>> getById(Long id) {
		try {
			Thread.sleep(1000);
			kafkaTemplate.send("notificationTopic", new PaymentPlacedEvent(id));
			log.info("Orden placed");
			
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); //bad ending xD
		}
		
		
		
		return super.getById(id);
	}
    
    
	
	
    



}