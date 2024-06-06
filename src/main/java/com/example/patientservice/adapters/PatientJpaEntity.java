package com.example.patientservice.adapters;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "patient", schema ="public" )
public class PatientJpaEntity implements Serializable {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BIRTHDATE")
    private LocalDateTime birthDate;
}
