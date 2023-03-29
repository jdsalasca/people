package com.jdsk.people.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.*;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;
    
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Cellphone cannot be blank")
    private String cellphone;

    @NotNull(message = "dateOfBirthh cannot be null")
    @Past(message = "dateOfBirth must be in the past")
    private LocalDate dateOfBirth;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotNull(message = "Gender cannot be null")
    private Integer gender;

    @NotNull(message = "Document type cannot be null")
    private Integer documentType;

    @NotNull(message = "Status cannot be null")
    private Integer status;

    @NotBlank(message = "Document number cannot be blank")
    private String documentNumber;
}
