package com.nhmi.ecom.controller;

import com.nhmi.ecom.student.Student;
import com.nhmi.ecom.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(path="v2/api/student")
@Api(value = "Operations related to students", tags = {"Students"})
@SwaggerDefinition(tags = {@Tag(name = "Student Apis", description = "Operations related to student") })
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @ApiOperation(
            value="Retrieve all student",
            notes = "Used to fetch all students from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @ApiOperation(
            value="Add a student to database",
            notes = "Will refactor later for role-based access")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @PostMapping("/addStudent")
    public String addStudent(@RequestParam(value = "name", required = true) String name,
                           @RequestParam(value = "email", required = true) String email,
                           @RequestParam(value = "dob", required = true) String dob) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dob,fmt);
        Student student = new Student(name,email, dateOfBirth);

        return studentService.addStudent(student);
    }
}
