package com.example.patientservice.adapters;

import com.example.patientservice.domain.Patient;
import com.example.patientservice.mapper.CommonMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PatientJpaMapper.class)
public interface PatientJpaMapper extends CommonMapper<Patient, PatientJpaEntity> {
}
