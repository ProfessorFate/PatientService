package com.example.patientservice.application.usecase;

import com.example.patientservice.domain.Patient;

import java.util.List;

public interface PatientServiceUseCase {

    List<Patient> getPatients();

    Patient getPatientById(Long id);

    void savePatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(Patient patient);

    List<Patient> save100Patients();
}
