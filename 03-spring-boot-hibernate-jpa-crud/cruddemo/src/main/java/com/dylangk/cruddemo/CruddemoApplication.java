package com.dylangk.cruddemo;

import com.dylangk.cruddemo.dao.StudentDAO;
import com.dylangk.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO
    ){
        return runner ->{
           createMultipleStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object....");
        Student tempStudent = new Student("Dylann", "Kim", "dylan@gmail.com");
        // save the student object
        studentDAO.save(tempStudent);

    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        // create multiple students
        System.out.println("Creating 3 students....");
        Student tempStudent1 = new Student("John", "Cena", "john@gmail.com");
        Student tempStudent2 = new Student("Dean", "Ambrose", "dean@gmail.com");
        Student tempStudent3 = new Student("Roman", "Reigns", "roman@gmail.com");

        // save the student object
        System.out.println("Saving students....");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }
}
