package com.nhmi.ecom.service;

import com.nhmi.ecom.student.Student;
import com.nhmi.ecom.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public String addStudent(Student student) {
        try {
            studentRepository.save(student);
        } catch (Exception e ){
           throw e;
        }
        return "Successfully added a student";
    }

    public String remove(long id) {
        studentRepository.deleteById(id);
        return "Successfully removed a student";
    }
}
