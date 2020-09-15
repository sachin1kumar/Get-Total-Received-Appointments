package com.patient.registration.Patient.registration.microservice.controllers;

import com.patient.registration.Patient.registration.microservice.model.PatientRegistration;
import com.patient.registration.Patient.registration.microservice.model.RegistrationResponse;
import com.patient.registration.Patient.registration.microservice.repositories.PatientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/patient-registration")
public class PatientRegistrationRepository {

    @Autowired
    private PatientDetailsRepository patientDetailsRepository;

    @RequestMapping(value = "/registerPatient", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> registerPatient(@RequestBody PatientRegistration patientRegistration) {
        patientDetailsRepository.save(patientRegistration);
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setPatientId(patientRegistration.getPatient_id());
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
    }
}
