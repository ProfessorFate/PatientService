package com.example.patientservice.application;

import com.example.patientservice.annotation.UseCase;
import com.example.patientservice.application.usecase.PatientServiceUseCase;
import com.example.patientservice.domain.Patient;
import com.example.patientservice.ports.DeletePatientPort;
import com.example.patientservice.ports.SavePatientPort;
import com.example.patientservice.ports.SearchPatientPort;
import com.example.patientservice.ports.UpdatePatientPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@UseCase
@RequiredArgsConstructor
@Slf4j
public class PatientService implements PatientServiceUseCase {

    private final SearchPatientPort searchPatientPort;
    private final SavePatientPort savePatientPort;
    private final UpdatePatientPort updatePatientPort;
    private final DeletePatientPort deletePatientPort;

    @Override
    public List<Patient> getPatients() {
        return searchPatientPort.searchPatient();

    }

    @Override
    public Patient getPatientById(Long id) {
        return searchPatientPort.getPatientById(id);
    }

    @Override
    public void savePatient(Patient patient) {
        savePatientPort.savePatient(patient);

    }

    @Override
    public void updatePatient(Patient patient) {
        Patient findPatient = searchPatientPort.getPatientById(patient.getId());

        findPatient.setId(patient.getId());
        findPatient.setName(patient.getName());
        findPatient.setGender(patient.getGender());
        findPatient.setBirthDate(patient.getBirthDate());

        updatePatientPort.updatePatient(findPatient);

    }

    @Override
    public void deletePatient(Patient patient) {
        deletePatientPort.deletePatient(patient.getId());

    }

    @Override
    public List<Patient> save100Patients() {
        List<Patient> patientList = null;
//
//
////         for (int i = 0; i < 100; i++) {
////
////             Patient patient = new Patient();
////             patient.setId();
////             patient.setName();
////             patient.setGender("Male");
////             patient.setBirthDate();
////             System.out.println(patient);
////         }
//
//
//        Faker faker = new Faker();
//
//        Patient patient = new Patient();
//        patient.setGender(faker.s);
//
//        patientList = (List<Patient>) LongStream.rangeClosed(1, 100)
//                .mapToObj(i ->Patient.builder()
//                        .id(i)
//                        .name(faker.app().name())
//                        .birthDate(LocalDate.parse((CharSequence) faker.date()).atStartOfDay())
//                        .build());
//
//
//        log.info("100  {}", patientList);

        return patientList;
    }

}
