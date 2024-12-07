package org.dev.sbprac2;

import org.dev.sbprac2.dao.StudentDAO;
import org.dev.sbprac2.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SBprac2Application {

    public static void main(String[] args) {
        SpringApplication.run(SBprac2Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return args -> {
            //createStudent(studentDAO);
            //createMultipleStudents(studentDAO);
            crud(studentDAO);
        };
    }

    // This function for menu of action it will call functions accordingly
    private void crud(StudentDAO studentDAO) {
        System.out.println("\nSLECT OPTION");
        System.out.println("1. Create a new student" +
                "\n2.find student" +
                "\n3.Get students List");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1: createMultipleStudents(studentDAO); break;
            case 2: findStudent(studentDAO); break;
            case 3: getAllStudents(studentDAO); break;
            default: System.out.println("Invalid option!");
        }
    }

    // when we choose find all students crud will call this function
    private void getAllStudents(StudentDAO studentDAO) {
        System.out.println("\n----------- ALL STUDENTS -----------");
        List<Student> allStudents = studentDAO.findAll();
        for (Student tempStudent : allStudents) {
            System.out.println(tempStudent);
        }
    }

    // this is also for menu but for finding student according to need it will also call function accordingly
    private void findStudent(StudentDAO studentDAO) {
        System.out.println("\n----------- Search Student Details -----------");
        System.out.println("\n1. Find student by ID" +
                "\n2. Find student by First Name" +
                "\n3. Find student by Last Name" +
                "\n4. Find student by Email Address");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Choice : ");
        int option = sc.nextInt();
        switch (option) {
            case 1: findById(studentDAO); break;
            case 2: findByFirstName(studentDAO); break;
            case 3: findByLastName(studentDAO); break;
            case 4: findByEmail(studentDAO); break;
        }

    }

    //Function for Find by mail option
    private void findByEmail(StudentDAO studentDAO) {
        System.out.println("\n----------- FIND STUDENT BY Email -----------");
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Student Email : ");
        String Email = sc.next();
        List<Student> Result = studentDAO.findByEmail(Email);
        //it will check is List is empty or not
        if (Result.isEmpty()){
            System.out.println("Student not found!");
        }else {
            for (Student tempStudent : Result) {
                System.out.println(tempStudent);
            }
        }
    }

    private void findByLastName(StudentDAO studentDAO) {
        System.out.println("\n----------- FIND STUDENT BY Last Name -----------");
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Student Last Name: ");
        String Lname = sc.next();
        List<Student> Result = studentDAO.findByLastName(Lname);
        if (Result.isEmpty()){
            System.out.println("Student not found!");
        }else {
            for (Student tempStudent : Result) {
                System.out.println(tempStudent);
            }
        }
    }

    private void findByFirstName(StudentDAO studentDAO) {
        System.out.println("\n----------- FIND STUDENT BY FirstName -----------");
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Student First Name: ");
        String fname = sc.next();
        List<Student> Result = studentDAO.findByName(fname);
        if (Result.isEmpty()){
            System.out.println("Student not found!");
        }else {
            for (Student tempStudent : Result) {
                System.out.println(tempStudent);
            }
        }
    }

    private void findById(StudentDAO studentDAO) {
        System.out.println("\n----------- FIND STUDENT BY ID -----------");
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Student ID: ");
        int id = sc.nextInt();
        Student founStudent = studentDAO.findById(id);
        System.out.println(founStudent.toString());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        int noOfStud = 0;

        //Asking how many input they wants
        System.out.println("Creating new student object...");
        System.out.print("Enter how man you want to save: ");
        Scanner sc = new Scanner(System.in);
        noOfStud = sc.nextInt();
        String[] firstNames = new String[noOfStud];
        String[] lastNames = new String[noOfStud];
        String[] Email = new String[noOfStud];
        for (int i = 0; i < noOfStud; i++) {

            //getting the students input
            System.out.println("\n----------- Student "+(i+1)+" Details -----------");
            System.out.print("\nEnter First Name: ");
            firstNames[i] = sc.next();
            System.out.print("Enter Last Name: ");
            lastNames[i] = sc.next();
            System.out.print("Enter Email Address: ");
            Email[i] = sc.next();
            System.out.println("\nSaving Student...");
            Student tempStudent = new Student(firstNames[i],lastNames[i],Email[i]);

            //Saving the Student
            studentDAO.save(tempStudent);
            System.out.println("Student saved!");
            System.out.println("Student Generated ID: " + tempStudent.getId());
        }

    }

    private void createStudent(StudentDAO studentDAO) {

        //Create a student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Pratik","Khaire","sudarshan@gmail.com");

        //Saving Student
        System.out.println("Saving Student...");
        studentDAO.save(tempStudent);

        //Showing student ID
        System.out.println("Student saved!");
        System.out.println("Student Generated ID: " + tempStudent.getId());
    }

}
