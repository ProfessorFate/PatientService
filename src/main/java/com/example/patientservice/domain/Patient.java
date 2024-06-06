package com.example.patientservice.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Объект Пациент")
public class Patient {

    @Schema(description = "Идентификационный номер Пациента", name = "id", type ="Long", example = "3232fdf34")
    private Long id;

    @Schema(description = "ФИО Пациента", name = "name", type ="String", example = "Иванов Иван Иванович")
    private String name;

    @Schema(description = "Пол Пациента", name = "gender", type ="String", example = "male")
    private String gender;

    @Schema(description = "Идентификационный номер Пациента", name = "birthDate", type ="LocalDateTime", example = "2024-01-13 18:25:43")
    private LocalDateTime birthDate;
}
