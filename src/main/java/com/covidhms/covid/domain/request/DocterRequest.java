package com.covidhms.covid.domain.request;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DocterRequest {
    private String docterId;
   private String name;
    private String department;
    private int age;
    private char sex;
    private String dayMark;


}
