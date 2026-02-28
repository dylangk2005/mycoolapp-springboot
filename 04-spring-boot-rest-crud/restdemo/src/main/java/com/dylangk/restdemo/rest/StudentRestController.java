package com.dylangk.restdemo.rest;

import com.dylangk.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruc to load the student data .. only once!
    @PostConstruct
    public void init(){
        students = new ArrayList<>();
        students.add(new Student("John", "Doe"));
        students.add(new Student("Jane", "Doe"));
        students.add(new Student("Bob", "Smith"));
        students.add(new Student("Alice", "Johnson"));
        students.add(new Student("Charlie", "Williams"));
    }

    //define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
}
