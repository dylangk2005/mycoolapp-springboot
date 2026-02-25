package com.dylangk.cruddemo;

import com.dylangk.cruddemo.dao.StudentDAO;
import com.dylangk.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO
    ){
        return runner ->{
            //createStudent(studentDAO);

            createMultipleStudent(studentDAO);

            // readStudent(studentDAO);

            //queryForStudents(studentDAO);

            // queryForStudentsByLastName(studentDAO);

            //updateStudent(studentDAO);

            //deleteStudent(studentDAO);

            //deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students....");
        int deletedRow = studentDAO.deleteAll();
        System.out.println("Deleted " + deletedRow + " rows :^)");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Student id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // get student id
            int studentId = 1;
            System.out.println("Student id: " + studentId);

        // find the student with id
            Student theStudent = studentDAO.findById(studentId);

        // update the student with new information
            theStudent.setFirstName("Jonn");
            theStudent.setLastName("Cena");

        // update database
            System.out.println("Updating student....");
            studentDAO.update(theStudent);

        // printing update successfully
            System.out.println("Student updated successfully.");
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Ambrose");

        // display list of students
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> students = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : students){
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating student object....");
        Student tempStudent = new Student("Daffy","Duck","daffy@gmail.com");

        //save the student
        System.out.println("Saving student....");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int studentId = tempStudent.getId();
        System.out.println("Student saved with id: " + studentId);

        // retrieve student base on the id: primary key
        Student retrievedStudent = studentDAO.findById(studentId);

        // display student
        System.out.println(retrievedStudent);
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
