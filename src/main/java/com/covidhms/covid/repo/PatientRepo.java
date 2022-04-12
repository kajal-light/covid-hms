package com.covidhms.covid.repo;

import com.covidhms.covid.model.PatientEntity;
import com.covidhms.covid.utild.HMSConstants;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PatientRepo extends CrudRepository<PatientEntity,Integer> {

    @Query(name = "select * from patient_detail WHERE patient_id = ?0" , nativeQuery = true)
    PatientEntity getByPatientId(String patientId);


    @Query(HMSConstants.SINGLE_DAY_COUNT)
    int getTotalPatientByDay(LocalDate dateOfAdmission);


    @Query(name="delete from patient_detail WHERE patient_id = ?0",nativeQuery = true)
    void deleteByPatientId(String patientId);




}
