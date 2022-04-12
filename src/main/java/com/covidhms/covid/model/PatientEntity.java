package com.covidhms.covid.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Table(name = "patient_detail")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class PatientEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String patientId;

    @Column
    private String dailyPatientCounter;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String sex;

    @Column
    private Boolean covidActiveStatus;

    @Column
    private String mobile;

    @Column
    private String city;

    @Column
    private String district;

    @Column
    private LocalDate dateOfAdmission;

    @Column
    private LocalDate dateOfDischarge;

    @Column
    private Boolean travelHistory;

    @Column
    private Boolean contactHistory;

    @Column
    private Boolean coMorbidity;
    // list of selected outcomes -dropdown menu
    @Column
    private String symptomStatus;
    // list of selected outcomes -dropdown menu
    @Column
    private String actionTaken;

    @Column
    private String bedAllotment;
    // list of selected outcomes -dropdown menu
    @Column
    private String outcome;

    @Column
    private LocalDate dateOfFirstTest;

    @Column
    private LocalDate dateOfSecondTest;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfThirdTest;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfFirstTestResult;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfSecondTestResult;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfThirdTestResult;

    // list of selected outcomes -dropdown menu
    @Column
    private String firstResult;

    // list of selected outcomes -dropdown menu
    @Column
    private String secondResult;

    // list of selected outcomes -dropdown menu
    @Column
    private String thirdResult;

    // additional comment
    @Column
    private String comment;

    @Column
    private Boolean srfNo;

    @Column
    private Instant lastUpdatedOn;


}


