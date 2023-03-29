package com.jdsk.people.interfaces;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.jdsk.people.utils.response.DefaultResponse;

public interface ICrudInterface<T, K , ID extends Serializable, L extends JpaRepository<T, ID>>  {
	
    
    ResponseEntity<DefaultResponse<T>> getAll();
    
    ResponseEntity<DefaultResponse<T>> getById(ID id);
    
    //ResponseEntity<DefaultResponse<T>> save(K entity, BindingResult bindigResult);
    ResponseEntity<DefaultResponse<T>> update( ID id, K entity, BindingResult bindigResult,  Class<T> entityClass);
    void deleteById(ID id);

	ResponseEntity<DefaultResponse<T>> save(K dto, BindingResult bindingResult, Class<T> entityClass);

}
