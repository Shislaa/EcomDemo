package com.nhmi.ecom.Student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1,
                        "Mao Phac",
                        "mail@mail.mail",
                        18,
                        LocalDate.of(2005, Month.DECEMBER, 10)
                )
        );
    }
}
