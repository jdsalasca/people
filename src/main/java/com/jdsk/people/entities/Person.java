package com.jdsk.people.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "cellphone", nullable = false, unique = true)
    private String cellphone;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

   
    @Column(name = "gender_id", nullable = false)
    private Integer gender;

    @Column(name = "document_type_id", nullable = false)
    private Integer documentType;
    @Column(name = "status_id", nullable = false)
    private Integer status;

    @Column(name = "document_number", nullable = false)
    private String documentNumber;
    
//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "gender_id", nullable = false)
//  private Gender gender;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "document_type_id", nullable = false)
//    private DocumentType documentType;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "status_id", nullable = false)
//    private Status status;

    // Constructors, getters, and setters omitted for brevity
}