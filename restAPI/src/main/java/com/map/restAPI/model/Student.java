package com.map.restAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "age")
    private String age;

    @Column(name = "standard")
    private String standard;

    @Column(name = "mobile_no")
    private String mobileNo;
}
