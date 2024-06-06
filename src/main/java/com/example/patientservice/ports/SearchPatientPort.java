package com.example.patientservice.ports;

import com.example.patientservice.domain.Patient;

import java.util.List;

public interface SearchPatientPort {

    List<Patient> searchPatient();

    Patient getPatientById(String id);
}
