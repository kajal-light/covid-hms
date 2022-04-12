package com.covidhms.covid.utild;

public class HMSConstants {

//public static final String PATIENT_COUNT_QUERY="select count(*) from patientdetail";
//public static  final String SINGLE_PATIENT_QUERY="select * from patient_detail WHERE patient_id = ?0";
//name = "select * from patient_detail WHERE patient_id = ?0" , nativeQuery = true
 public static final String SINGLE_DAY_COUNT="select count(*) from PatientEntity a where a.dateOfAdmission =:dateOfAdmission";
 //public static final String DELETE_PATIENT_QUERY ="delete from patient_detail WHERE patient_id = ?0";
 //public static final String GET_ALL_PATIENT_QUERY="select * from patient_detail";

}
