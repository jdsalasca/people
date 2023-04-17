package com.jdsk.people.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@Configuration
@OpenAPIDefinition(
        info =@io.swagger.v3.oas.annotations.info.Info(
                title = "Universidad El Bosque - REST API UB-SERV-PROGRAM-CONCEPT-PEOPLE",
                version = "v0.0.1",
                contact = @io.swagger.v3.oas.annotations.info.Contact(
                        name = "Juan Da C:", email = "jdsalasc@unal.edu.co", url = "https://www.unbosque.edu.co/"
                ),
                license = @io.swagger.v3.oas.annotations.info.License(
                        name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        )
)
public class SwaggerConfig {

}
