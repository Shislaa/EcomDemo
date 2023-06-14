package com.nhmi.ecom.Student;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dob;

    public Student() {
    }

    public Student(long id,
                   String name,
                   String email,
                   Integer age,
                   LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
    }

    public Student(String name,
                   String email,
                   Integer age,
                   LocalDate dob) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
    }


}
