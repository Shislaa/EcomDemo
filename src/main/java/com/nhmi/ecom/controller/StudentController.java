package com.nhmi.ecom.controller;

import com.nhmi.ecom.student.Student;
import com.nhmi.ecom.student.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/addStudent")
//    public void addStudent(@RequestParam()) {
//
//    }
}
