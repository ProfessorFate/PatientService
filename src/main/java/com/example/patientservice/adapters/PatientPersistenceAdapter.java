package com.example.patientservice.adapters;

import com.example.patientservice.annotation.PersistenceAdapter;
import com.example.patientservice.domain.Patient;
import com.example.patientservice.ports.DeletePatientPort;
import com.example.patientservice.ports.SavePatientPort;
import com.example.patientservice.ports.SearchPatientPort;
import com.example.patientservice.ports.UpdatePatientPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
@Slf4j
public class PatientPersistenceAdapter implements SearchPatientPort, SavePatientPort, UpdatePatientPort, DeletePatientPort {

    private final PatientRepository patientRepository;
    private final PatientJpaMapper mapper;

    @Override
    @Transactional
    public List<Patient> searchPatient() {
        List<PatientJpaEntity> patientJpaEntities = patientRepository.findAll();

        return (List<Patient>) mapper.toListDto(patientJpaEntities);

    }

    @Override
    @Transactional
    public Patient getPatientById(String id) {
        Optional<PatientJpaEntity> getOnePatient = patientRepository.findById(id);

        return mapper.toDto(getOnePatient.get());
    }

    @Override
    @Transactional
    public void savePatient(Patient patient) {
        PatientJpaEntity patientJpaEntity = mapper.toEntity(patient);

        patientRepository.save(patientJpaEntity);

    }

    @Override
    @Transactional
    public void updatePatient(Patient patient) {
        PatientJpaEntity patientJpaEntity = mapper.toEntity(patient);

        patientRepository.save(patientJpaEntity);

    }

    @Override
    @Transactional
    public void deletePatient(String id) {
        patientRepository.deleteById(id);

    }
}
