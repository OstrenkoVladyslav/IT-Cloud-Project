package com.brainacad.oop.students.managers;

import com.brainacad.oop.students.model.Course;
import com.brainacad.oop.students.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.Set;

public class StudentManager {

    public StudentManager(){
    }

    public Student create(Scanner scanner) {
        String name, surname;
        LocalDate startDate, endDate;
        System.out.println("Enter student name:");
        name = scanner.nextLine();
        System.out.println("Enter student surname:");
        surname = scanner.nextLine();
        Boolean inputIsOk;
        System.out.println("DATA INPUT IS OK");

        return new Student(name, surname, 15);
    }

    public static int add(Set<Student> students){
        return 0;
    }

    public static void signIn(){

    }

    public static void move(){

    }

    public static void info(){

    }

    public static void list(){

    }
}
