package com.brainacad.oop.students;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Course> courses;

        fillStartMenu();
        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();
        do {
            try {
                choise = scanner.nextInt();
            } catch (InputMismatchException err) {
                System.out.println("Invalid input. Try again.");
                continue;
            }
            switch (choise) {
                case 1:
                    createCourse();
                    break;
                case 2:
                    showCourseDetails();
                    break;
                default: {
                    System.out.println("Wrong input. Try again.");
                }

            }
        } while (choise == 13);
    }

    public static void fillStartMenu() {
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

    public static void createCourse() {

    }

    public static void showCourseDetails() {

    }
}
