package com.covidhms.covid.domain.response;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PatientResponse implements Serializable {

    private static final long serialVersionUID = 1L;



    private String patientId;


    private String name;


    private int age;


    private String sex;


    private Boolean covidActiveStatus;

    private String mobile;


    private String city;

    private String district;



    private LocalDate dateOfAdmission;


    private LocalDate dateOfDischarge;


    private Boolean travelHistory;


    private Boolean contactHistory;

    private Boolean coMorbidity;

    // list of selected outcomes -dropdown menu

    private String symptomStatus;
    // list of selected outcomes -dropdown menu

    private String actionTaken;

    private String bedAllotment;
    // list of selected outcomes -dropdown menu

    private String outcome;


    private LocalDate dateOfFirstTest;


    private LocalDate dateOfSecondTest;


    private LocalDate dateOfThirdTest;


    private LocalDate dateOfFirstTestResult;
    // list of selected outcomes -dropdown menu

    private String firstResult;


    private LocalDate dateOfSecondTestResult;

    // list of selected outcomes -dropdown menu

    private String secondResult;


    private LocalDate dateOfThirdTestResult;
    // list of selected outcomes -dropdown menu

    private String thirdResult;

    // additional comment

    private String comment;

    private String srfNo;


    private Instant lastUpdatedOn;

}


