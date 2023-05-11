package com.jdsk.people.servicies;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
public abstract class PersonServiceImpll implements IPersonService  {



}