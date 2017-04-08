package com.brainacad.oop.students.managers;

import com.brainacad.oop.students.model.Course;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.Set;

public class CourseManager {

    public CourseManager() {
    }

    public Course create(Scanner scanner) {
        String name, description;
        LocalDate startDate = null, endDate = null;
        System.out.println("Enter course name:");
        name = scanner.nextLine();
        System.out.println("Enter course description:");
        description = scanner.nextLine();
        Boolean inputIsOk;
        Boolean rangeIsOk;
        do {
            do {
                System.out.println("Input course start date in format yyyy-mm-dd");
                inputIsOk = true;
                try {
                    startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
                } catch (DateTimeParseException e) {
                    System.out.println("Wrong input. Try again.");
                    inputIsOk = false;
                }
            } while (!inputIsOk);
            do {
                System.out.println("Input course end date in format yyyy-mm-dd");
                inputIsOk = true;
                try {
                    endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
                } catch (DateTimeParseException e) {
                    System.out.println("Wrong input. Try again.");
                    inputIsOk = false;
                }
            } while (!inputIsOk);

            if (startDate.compareTo(endDate) > 0) {
                rangeIsOk = false;
                System.out.println("Date range is wrong. Try again.");
            } else {
                rangeIsOk = true;
            }
        } while (!rangeIsOk);

        return new Course(name, description, startDate, endDate);
    }

    public static void list(Set<Course> courses){
        if (courses.size()==0){
            System.out.println("Courses list is empty");
        } else {
            for (Course course: courses){
                System.out.println(course.getId()+". "+course.getName());
            }
        }
    }
}
