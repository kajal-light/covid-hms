package com.covidhms.covid.domain.response;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DocterResponse {
    private String docterId;
    private String name;
    private String department;
    private int age;
    private char sex;
    private String dayMark;


}
