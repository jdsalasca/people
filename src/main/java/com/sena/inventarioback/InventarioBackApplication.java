package com.sena.inventarioback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class InventarioBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioBackApplication.class, args);
	}

}
