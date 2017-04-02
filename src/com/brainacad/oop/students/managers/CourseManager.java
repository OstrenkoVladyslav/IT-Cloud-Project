package com.brainacad.oop.students.managers;

import com.brainacad.oop.students.storage.Course;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class CourseManager {

    private CourseManager() {
    }

    public static int addCourse(Set<Course> courses) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        String description = null;
        System.out.println("Creating new course");
        boolean inputIsOK;

        do {
            System.out.print("Please input course name: ");
            inputIsOK = true;
            try {
                name = br.readLine();
            } catch (IOException e) {
                System.out.println("IOException. Try again.");
                inputIsOK = false;
                continue;
            }
            for (Course course : courses) {
                if (name.equals(course.getName())) {
                    System.out.println("Course name should be unique. Please, enter another name.");
                    inputIsOK = false;
                    break;
                }
            }
        } while (!inputIsOK);

        do {
            System.out.print("Please input course description: ");
            inputIsOK = true;
            try {
                description = br.readLine();
            } catch (IOException e) {
                System.out.println("IOException. Try again.");
                inputIsOK = false;
            }
        } while (!inputIsOK || name == null || description == null);
        Course course = new Course(name, description);
        courses.add(course);
        System.out.println("Course created OK");
        return course.getId();
    }

    public static void showCourseDetails(Set<Course> courses, int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                System.out.println(course);
                break;
            }
        }

    }

    public static void showCourseDetails(Set<Course> courses) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int id = -1;
        boolean inputIsOK;
        do {
            System.out.print("Enter course ID: ");
            inputIsOK = false;
            try {
                id = Integer.valueOf(br.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input error. Try again.");
                inputIsOK = false;
                continue;
            }
            for (Course course : courses) {
                if (course.getId() == id) {
                    showCourseDetails(courses, id);
                    inputIsOK = true;
                    break;
                }
            }
            if (!inputIsOK) {
                System.out.println("No such course. Try once more.");
            }
        } while (!inputIsOK || id == -1);
    }

    public static void showCourseList(Set<Course> courses){
        if (courses.size()==0){
            System.out.println("Courses list is empty");
        } else {
            for (Course course: courses){
                System.out.println(course.getId()+". "+course.getName());
            }
        }
    }
}
