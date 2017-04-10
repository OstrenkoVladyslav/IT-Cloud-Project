package com.brainacad.oop.students.managers;

import com.brainacad.oop.students.model.Course;
import com.brainacad.oop.students.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class StudentManager {

    public StudentManager() {
    }

    public Student create(Scanner scanner) {
        String name, surname;
        int age = 0;
        System.out.println("Enter student's name:");
        name = scanner.nextLine();
        System.out.println("Enter student's surname:");
        surname = scanner.nextLine();
        boolean inputIsOk;
        do {
            inputIsOk = true;
            try {
                System.out.println("Enter student's age:");
                age = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input. Try again.");
                inputIsOk = false;
                scanner.next();
                continue;
            }
            if (age < 16 || age > 99) {
                System.out.println("Check the age. Should be 16..99");
                inputIsOk = false;
            }
        } while (!inputIsOk);
        return new Student(name, surname, age);
    }

    public static void signIn() {

    }

    public static void move() {

    }

    public static void info() {

    }

    public static void list() {

    }
}
