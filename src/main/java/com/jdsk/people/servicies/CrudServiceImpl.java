package com.jdsk.people.servicies;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.jdsk.people.entities.Person;
import com.jdsk.people.interfaces.ICrudInterface;
import com.jdsk.people.utils.response.DefaultResponse;
import com.jdsk.people.utils.response.DefaultResponse.DEFAULTMESSAGES;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public abstract class CrudServiceImpl<T, K, ID extends Serializable, R extends JpaRepository<T, ID>>
implements ICrudInterface<T, K, ID, R> {


    private final R repository;
    private final ModelMapper modelMapper;
    @Override 
    public ResponseEntity<DefaultResponse<T>> getAll() {
    	List<T> entities  = repository.findAll();
    	if (entities.size() == 0) {
    		return DefaultResponse.onThrow404Response(DEFAULTMESSAGES.NOT_INFO_FOUND_MESSAGE.value());
    	}else {
    		return DefaultResponse.onThrow200Response(entities);
    	}
        
    }
    @Override
    public ResponseEntity<DefaultResponse<T>> getById(ID id) {
    	Optional<T> entity  = repository.findById(id);
    	if (entity.isEmpty()) {
    		return DefaultResponse.onThrow404Response(DEFAULTMESSAGES.NOT_INFO_FOUND_MESSAGE.value());
    	}else {
    		
    		return DefaultResponse.onThrow200Response(List.of(entity.get()));
    	}	
    }
    @Override
    public ResponseEntity<DefaultResponse<T>> save(K dto, BindingResult bindingResult,  Class<T> entityClass) {
        if (bindingResult.hasErrors()) {
            return DefaultResponse.onThrow400ResponseBindingResult(bindingResult);
        }
        try {
            T entity = modelMapper.map(dto, entityClass);
            
            
            return DefaultResponse.onThrow200Response( List.of(repository.save(entity)));
		} catch (DataIntegrityViolationException e) {
			log.info("error creating entity for {} because of " + e.getLocalizedMessage(), entityClass);
			return DefaultResponse.onThrow400ResponseTypeInfo(e.getLocalizedMessage());
		}catch (Exception e) {
			log.info("IMPORTANT unhandle exception {}", e.getLocalizedMessage());
			log.info("error creating entity for {} because of " + e.getLocalizedMessage(), entityClass);
			return DefaultResponse.onThrow400ResponseTypeInfo(e.getLocalizedMessage());
		}

    }
	@Override
	public ResponseEntity<DefaultResponse<T>> update(  ID id, K entity, BindingResult bindigResult,  Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteById(ID id) {
		repository.deleteById(id);
	}
    }
