package com.brainacad.oop.students;

import com.brainacad.oop.students.managers.*;
import com.brainacad.oop.students.model.Course;
import com.brainacad.oop.students.model.Student;
import com.brainacad.oop.students.model.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static void fillStartMenu() {
        System.out.println("1.  Create course");
        System.out.println("2.  Show course details");
        System.out.println("3.  All courses list");
        System.out.println("4.  Sign in student");
        System.out.println("5.  Move student");
        System.out.println("6.  Student info");
        System.out.println("7.  Sign in teacher");
        System.out.println("8.  Teacher info");
        System.out.println("9.  Create task");
        System.out.println("10. All students list");
        System.out.println("11. Grades journal");
        System.out.println("12. Save journal to file");
        System.out.println("13. Exit");
    }

    //private static resolveCommand

    public static void main(String[] args) {
        Set<Course> courses = new LinkedHashSet<>();
        Set<Teacher> teachers = new LinkedHashSet<>();
        Set<Student> students = new LinkedHashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Free memory: " + runtime.freeMemory());
        System.out.println("Processors: " + runtime.availableProcessors());

        System.out.println("Starting project \"Student\"");
        System.out.println("Please, make your choice:");
        int choice = 0;
        do {
            fillStartMenu();
            try {
                choice = Integer.parseInt(br.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }
            switch (choice) {
                case 1:
                    int id = CourseManager.add(courses);
                    CourseManager.details(courses, id);
                    break;
                case 2:
                    CourseManager.details(courses);
                    break;
                case 3:
                    CourseManager.list(courses);
                    break;
                case 4:
                    StudentManager.signIn();
                    break;
                case 5:
                    StudentManager.move();
                    break;
                case 6:
                    StudentManager.info();
                    break;
                case 7:
                    TeacherManager.signIn();
                    break;
                case 8:
                    TeacherManager.info();
                    break;
                case 9:
                    TaskManager.add();
                    break;
                case 10:
                    StudentManager.list();
                    break;
                case 11:
                    JournalManager.show();
                    break;
                case 12:
                    JournalManager.save();
                    break;
                case 13:
                    System.out.println("Exiting");
                    break;
                default: {
                    System.out.println("Wrong command. Try again.");
                }
            }
        } while (choice != 13);
    }
}
