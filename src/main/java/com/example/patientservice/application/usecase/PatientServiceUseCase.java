package com.example.patientservice.application.usecase;

import com.example.patientservice.domain.Patient;

import java.util.List;

public interface PatientServiceUseCase {

    List<Patient> getPatients();

    Patient getPatientById(String id);

    void savePatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(Patient patient);

    List<Patient> createOneHundredPatient();
}
