package com.brainacad.oop.students.managers;

import com.brainacad.oop.students.dao.Dao;
import com.brainacad.oop.students.dao.collection.CollectionDao;
import com.brainacad.oop.students.model.Course;
import com.brainacad.oop.students.model.Student;
import com.brainacad.oop.students.model.Teacher;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;

public class CourseManager {

    public CourseManager() {
    }

    public Course create(Scanner scanner) {
        String name, description;
        int teacherId = 0;
        Date startDate = null, endDate = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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
                    startDate = df.parse(scanner.nextLine());
                } catch (DateTimeParseException|ParseException e) {
                    System.out.println("Wrong input. Try again.");
                    inputIsOk = false;
                }
            } while (!inputIsOk);
            do {
                System.out.println("Input course end date in format yyyy-mm-dd");
                inputIsOk = true;
                try {
                    endDate = df.parse(scanner.nextLine());
                } catch (DateTimeParseException|ParseException e) {
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

        do {
            inputIsOk = true;
            System.out.println("Input teacher id:");
            try {
                teacherId = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input. Try again.");
                inputIsOk = false;
                scanner.next();
            }
        } while (!inputIsOk);
        return new Course(name, description, teacherId, startDate, endDate);
    }

    public void list(Set<Course> courses) {
        if (courses.size() == 0) {
            System.out.println("Courses list is empty");
        } else {
            for (Course course : courses) {
                System.out.println(course.getId() + ". " + course.getName());
            }
        }
    }

    public void enrollStudent(int studentId, int courseId, Dao<Student> studentDao, Dao<Course> courseDao) {

    }
}
