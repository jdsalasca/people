package com.sena.inventarioback.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sena.inventarioback.dto.PersonDTO;
import com.sena.inventarioback.interfaces.IPersonService;
import com.sena.inventarioback.models.Person;
import com.sena.inventarioback.repositories.PersonRepository;
import com.sena.inventarioback.utils.crud.CrudServiceImpl;
import com.sena.inventarioback.utils.response.DefaultResponse;

@Service
@Component
public class PersonServiceImpl   extends CrudServiceImpl<Person, PersonDTO, Integer, PersonRepository>  implements IPersonService {

	@Autowired
	private PersonRepository personRepository;
	@Override
	public ResponseEntity<DefaultResponse<Person>> save(PersonDTO dto, BindingResult bindingResult,
			Class<Person> entityClass) {
		dto.setCreatedAt(LocalDateTime.now());
		dto.setPassword(BCrypt.hashpw(dto.getPassword(),BCrypt.gensalt()));
		return super.save(dto, bindingResult, entityClass);
	}
	
	@Override
	public ResponseEntity<DefaultResponse<Person>> update(Integer id, PersonDTO dto, BindingResult bindigResult,
			Class<Person> entityClass) {
		dto.setPassword(BCrypt.hashpw(dto.getPassword(),BCrypt.gensalt()));
		dto.setCreatedAt(LocalDateTime.now());
		dto.setUpdatedAt(LocalDateTime.now());
		return super.update(id, dto, bindigResult, entityClass);
	}
	@Override
	public Boolean login(String  userName, String password) throws AccountNotFoundException {
		Optional<Person> person = personRepository.findByUserName(userName);
		if (person.isEmpty()) {
			throw new AccountNotFoundException("User Not found");
		}
		return BCrypt.checkpw(password, person.get().getPassword());
	}
	@Override
	public List<Person> findByDocumentTypeId(Integer documentTypeId) {
		return personRepository.findAllByDocumentType(documentTypeId);
	}



}
