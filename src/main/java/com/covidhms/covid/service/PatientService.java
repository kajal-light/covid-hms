package com.covidhms.covid.service;

import com.covidhms.covid.domain.request.PatientRequest;
import com.covidhms.covid.domain.response.PatientResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PatientService {
    public String createObject(PatientRequest patientRequest);

    PatientResponse getPatientDetails(String id);

    public String  updateInPatient(PatientRequest patientRequest);

    String deletePatient(String patientId);

    List<PatientResponse> getAllPatient();
}
