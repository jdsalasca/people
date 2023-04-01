package com.jdsk.people.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jdsk.people.entities.DailyRoutine;
import com.jdsk.people.entities.Person;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyRoutineDto {

    @NotNull(message = "User ID cannot be null")
    @JsonProperty(value = "userId")
    private Long userId;
    @NotNull(message = "Date cannot be null")
    @PastOrPresent(message = "Date cannot be in the future")
    private LocalDate date;

    @NotBlank(message = "Activity cannot be blank")
    @Size(max = 255, message = "Activity cannot be longer than {max} characters")
    private String activity;
    @NotNull(message = "durationMinutes cannot be null")
    private Integer durationMinutes;

}
