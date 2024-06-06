package com.example.patientservice.webservice;

import com.example.patientservice.application.usecase.PatientServiceUseCase;
import com.example.patientservice.domain.Patient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.patientservice.constants.Constants.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PatientController {

    private final PatientServiceUseCase patientService;

    @Operation(summary = "Запрос на получение всех Пациентов")
    @GetMapping(ROOT_API_READ)
    @PreAuthorize("hasAnyAuthority('ROLE_PRACTITIONER')")
    List<Patient> getPatients() {

        return patientService.getPatients();
    }

    @Operation(summary = "Запрос на получение одного Пациента по id")
    @GetMapping(ROOT_API_READ_ONE)
    @PreAuthorize("hasAnyAuthority('ROLE_PATIENT')")
    Patient getPatientById(@PathVariable String id) {
        return patientService.getPatientById(id);

    }

    @Operation(summary = "Запрос на сохранение Пациента")
    @PostMapping(ROOT_API_SAVE)
    @PreAuthorize("hasAnyAuthority('ROLE_PRACTITIONER')")
    ResponseEntity<String> savePatient(
            @Parameter(description = "Patient",
                    content = @Content(mediaType = "application/json"),
                    schema = @Schema(implementation = Patient.class))
            @RequestBody Patient patient) {
        try {
            patientService.savePatient(patient);
            return new ResponseEntity<>("Пациент сохранен", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Пациент не сохранен", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(ROOT_API_UPDATE)
    @PreAuthorize("hasAnyAuthority('ROLE_PRACTITIONER')")
    ResponseEntity<String> updatePatient(
            @Parameter(description = "Patient",
                    content = @Content(mediaType = "application/json"),
                    schema = @Schema(implementation = Patient.class))
            @RequestBody Patient patient) {
        try {
            patientService.updatePatient(patient);
            return new ResponseEntity<>("Пациент обновлен", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Пациент не обнавлен", HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Запрос на удаление Пациента по id")
    @DeleteMapping(ROOT_API_DELETE)
    @PreAuthorize("hasAnyAuthority('ROLE_PRACTITIONER')")
    ResponseEntity<String> deletePatient(@PathVariable String id) {
        try {
            patientService.deletePatient(patientService.getPatientById(id));
            return new ResponseEntity<>("Пациент удален", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Пациент не удален", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/api/readTest")
    @PreAuthorize("hasAnyAuthority('ROLE_PRACTITIONER')")
    List<Patient> save100Patient() {

        return patientService.save100Patients();
    }


}
