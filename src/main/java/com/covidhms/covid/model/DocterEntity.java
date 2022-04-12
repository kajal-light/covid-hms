package com.covidhms.covid.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "docter")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class DocterEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String docterId;

    @Column
    private String name;

    @Column
    private String department;

    @Column
    private int age;

    @Column
    private char sex;

    @Column
    private String dayMark;
}
