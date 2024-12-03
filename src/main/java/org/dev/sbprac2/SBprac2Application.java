package org.dev.sbprac2;

import org.dev.sbprac2.dao.StudentDAO;
import org.dev.sbprac2.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

    private void crud(StudentDAO studentDAO) {
        System.out.println("\nSLECT OPTION");
        System.out.println("1. Create a new student" +
                "\n2.find student");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1: createMultipleStudents(studentDAO); break;
            case 2: findStudent(studentDAO); break;
            default: System.out.println("Invalid option!");
        }
    }

    private void findStudent(StudentDAO studentDAO) {
        System.out.println("\n----------- Search Student Details -----------");
        System.out.println("\nEnter Student ID: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Student founStudent = studentDAO.findById(id);
        System.out.println("\nFound Student ID: " + founStudent.toString());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        int noOfStud = 0;
        System.out.println("Creating new student object...");
        System.out.print("Enter how man you want to save: ");
        Scanner sc = new Scanner(System.in);
        noOfStud = sc.nextInt();
        String[] firstNames = new String[noOfStud];
        String[] lastNames = new String[noOfStud];
        String[] Email = new String[noOfStud];
        for (int i = 0; i < noOfStud; i++) {
            System.out.println("\n----------- Student "+(i+1)+" Details -----------");
            System.out.print("\nEnter First Name: ");
            firstNames[i] = sc.next();
            System.out.print("Enter Last Name: ");
            lastNames[i] = sc.next();
            System.out.print("Enter Email Address: ");
            Email[i] = sc.next();
            System.out.println("\nSaving Student...");
            Student tempStudent = new Student(firstNames[i],lastNames[i],Email[i]);
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
