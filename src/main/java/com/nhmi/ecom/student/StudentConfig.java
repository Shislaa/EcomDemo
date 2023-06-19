package com.nhmi.ecom.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student student = new Student(
                    "Student Nguyen",
                    "student@nguyen.com",
                    LocalDate.of(2005, Month.DECEMBER, 10)
            );
            Student student_1 = new Student(
                    "Student Nguyen",
                    "nguyen@student.mail",
                    LocalDate.of(2003, Month.DECEMBER, 10)
            );

            repository.saveAll(
                    List.of(student, student_1)
            );
        };
    }
}
