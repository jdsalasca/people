package com.jdsk.people.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.jdsk.people.utils.response.DefaultResponse;
import com.jdsk.people.utils.response.DefaultResponse.DEFAULTMESSAGES;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
/**

This interface defines a CRUD (Create, Read, Update, Delete) contract for generic entities using Spring Data JPA.

@param <T> the type of the entity

@param <K> the type of the DTO (Data Transfer Object) used to create or update the entity

@param <ID> the type of the entity identifier

@param <L> the type of the Spring Data JPA repository interface used to interact with the database

@author jdsalasca
*/
@Slf4j
public abstract class ICrudInterfaceii<T, K , ID extends Serializable, L extends JpaRepository<T, ID>>  {
	private L repository;
	public static final ModelMapper modelMapper = new ModelMapper();
	/**

    Retrieves all the entities of type T.
    @return a ResponseEntity with a DefaultResponse containing the list of entities, or an error message if an exception occurs
    */

    /**

    Retrieves the entity of type T identified by the given ID.
    @param id the identifier of the entity
    @return a ResponseEntity with a DefaultResponse containing the entity, or an error message if an exception occurs
    */
    ResponseEntity<DefaultResponse<T>> getById(ID id) {
    	Optional<T> entity  = repository.findById(id);
    	if (entity.isEmpty()) {
    		return DefaultResponse.onThrow404Response(DEFAULTMESSAGES.NOT_INFO_FOUND_MESSAGE.value());
    	}else {
    		
    		return DefaultResponse.onThrow200Response(List.of(entity.get()));
    	}	
	}
    /**

    Saves a new entity of type T using the data contained in the provided DTO.
    @param dto the DTO containing the data for the new entity
    @param bindingResult the result of the data validation process
    @param entityClass the class of the entity being created
    @return a ResponseEntity with a DefaultResponse containing the newly created entity, or an error message if an exception occurs
    */
    ResponseEntity<DefaultResponse<T>> save(K dto, BindingResult bindingResult, Class<T> entityClass) {
    	if (bindingResult.hasErrors()) {
            return DefaultResponse.onThrow400ResponseBindingResult(bindingResult);
        }
        try {
            T entity = modelMapper.map(dto, entityClass);
            
            
            return DefaultResponse.onThrow200Response( List.of(repository.save(entity)));
		} catch (DataIntegrityViolationException e) {
			log.info("error creating entity for {} because ofe " + e.getLocalizedMessage(), entityClass);
			return DefaultResponse.onThrow400ResponseTypeInfo(e.getMostSpecificCause().getMessage());
			
		}catch (ConstraintViolationException constraintViolationException) {
	            return DefaultResponse.onThrow400ResponseTypeError(List.of(constraintViolationException.getMessage()).toString());
	        
		}catch (Exception e) {
			log.info("IMPORTANT unhandle exception {}", e.getLocalizedMessage());
			log.info("error creating entity for {} because of " + e.getLocalizedMessage(), entityClass);
			return DefaultResponse.onThrow400ResponseTypeInfo(e.getLocalizedMessage());
		}
	}
    /**

    Updates the entity of type T identified by the given ID using the data contained in the provided DTO.
    @param id the identifier of the entity being updated
    @param dto the DTO containing the updated data for the entity
    @param bindingResult the result of the data validation process
    @param entityClass the class of the entity being updated
    @return a ResponseEntity with a DefaultResponse containing the updated entity, or an error message if an exception occurs
    */
    ResponseEntity<DefaultResponse<T>> update( ID id, K dto, BindingResult bindigResult,  Class<T> entityClass) {
    	 if (bindigResult.hasErrors()) {
             return DefaultResponse.onThrow400ResponseBindingResult(bindigResult);
         }
         try {
         	T entity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException(DEFAULTMESSAGES.NOT_INFO_FOUND_MESSAGE.value()));
         	modelMapper.map(dto, entity);
         	
         	
             
             return DefaultResponse.onThrow200Response( List.of(repository.save(entity)));
 		} catch (DataIntegrityViolationException e) {
 			log.info("error creating entity for {} because of {}", entityClass ,e.getLocalizedMessage());
 			return DefaultResponse.onThrow400ResponseTypeInfo(e.getMostSpecificCause().getLocalizedMessage());
 		}catch (ConstraintViolationException constraintViolationException) {
             return DefaultResponse.onThrow400ResponseTypeError(List.of(constraintViolationException.getMessage()).toString());
 	        
 		}catch (EntityNotFoundException e) {
 			return DefaultResponse.onThrow400ResponseTypeInfo(e.getLocalizedMessage());
 	        
 		}catch (Exception e) {
 			log.info("IMPORTANT unhandle exception {}", e.getLocalizedMessage());
 			log.info("error creating entity for {} because of " + e.getLocalizedMessage(), entityClass);
 			return DefaultResponse.onThrow400ResponseTypeInfo(e.getLocalizedMessage());
 		}
	}
    /**

    Deletes the entity of type T identified by the given ID.
    @param id the identifier of the entity being deleted
    */
    void deleteById(ID id) {
    	log.info("Not Implemented yet");
	}
    

    

    
}
