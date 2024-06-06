package com.example.patientservice.ports;

import com.example.patientservice.domain.Patient;

public interface SavePatientPort {

    void savePatient(Patient patient);
}
