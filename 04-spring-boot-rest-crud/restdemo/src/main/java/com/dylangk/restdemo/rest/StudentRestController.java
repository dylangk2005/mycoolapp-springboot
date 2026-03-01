package com.dylangk.restdemo.rest;

import com.dylangk.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruct to load the student data .. only once!
    @PostConstruct
    public void init(){
        students = new ArrayList<>();
        students.add(new Student("John", "Doe"));
        students.add(new Student("Jane", "Doe"));
        students.add(new Student("Bob", "Smith"));
        students.add(new Student("Alice", "Johnson"));
        students.add(new Student("Charlie", "Williams"));
    }

    // define endpoint or "student/{studentid}" - return student at index
    @GetMapping("/students/{studentid}")
    public Student getStudent(@PathVariable int studentid){
        // check the studentId again list size
        if(studentid >= students.size() || studentid < 0){
            throw new StudentNotFoundException("Student not found");
        }
        return students.get(studentid);
    }


    //define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
}
