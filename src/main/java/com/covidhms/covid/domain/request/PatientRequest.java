package com.covidhms.covid.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString

public class PatientRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String patientId;


    private String name;


    private int age;

    private String sex;

    private String covidActiveStatus;

    private String mobile;

    private String city;

    private String district;




private LocalDate dateOfAdmission;




private LocalDate dateOfDischarge;

    private String travelHistory;


    private String contactHistory;


    private String coMorbidity;

    // list of selected outcomes -dropdown menu

    private String symptomStatus;
    // list of selected outcomes -dropdown menu

    private String actionTaken;


    private String bedAllotment;
    // list of selected outcomes -dropdown menu

    private String outcome;


    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate dateOfFirstTest;


    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate dateOfSecondTest;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate dateOfThirdTest;



    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate dateOfFirstTestResult;
    // list of selected outcomes -dropdown menu

    private String firstResult;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate dateOfSecondTestResult;

    // list of selected outcomes -dropdown menu

    private String secondResult;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate dateOfThirdTestResult;

    // list of selected outcomes -dropdown menu

    private String thirdResult;


    private String comment;

    private String srfNo;



    private Instant lastUpdatedOn;


}