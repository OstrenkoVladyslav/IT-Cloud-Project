package com.brainacad.oop.students;

import com.brainacad.oop.students.dao.collection.CollectionDao;
import com.brainacad.oop.students.dao.collection.CourseCollectionDao;
import com.brainacad.oop.students.dao.collection.StudentCollectionDao;
import com.brainacad.oop.students.dao.database.CourseDbDao;
import com.brainacad.oop.students.dao.database.DbDao;
import com.brainacad.oop.students.dao.database.StudentDbDao;
import com.brainacad.oop.students.managers.CourseManager;
import com.brainacad.oop.students.managers.StudentManager;
import com.brainacad.oop.students.managers.TeacherManager;
import com.brainacad.oop.students.model.Course;
import com.brainacad.oop.students.model.Student;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static void listCommands() {
        System.out.println("List of available commands:");
        System.out.println("\"create course\": creates new course");
        System.out.println("\"show course #\": shows course detail by id");
        System.out.println("\"show courses\": shows all courses details");
        System.out.println("4.  Sign in student");
        System.out.println("5.  Move student");
        System.out.println("6.  Student info");
        System.out.println("7.  Sign in teacher");
        System.out.println("8.  Teacher info");
        System.out.println("9.  Create task");
        System.out.println("10. All students list");
        System.out.println("11. Grades journal");
        System.out.println("12. Save journal to file");
        System.out.println("\"clear db\": clears database");
        System.out.println("\"quit\": quit program");
    }

    //private static resolveCommand(){}

    public static void main(String[] args) {
        CourseManager courseManager = new CourseManager();
        StudentManager studentManager = new StudentManager();
        TeacherManager teacherManager = new TeacherManager();

        DbDao<Student> studentDao = new StudentDbDao();
        DbDao<Course> courseDao = new CourseDbDao();

        Scanner scanner = new Scanner(System.in);
        String commandString;

        Pattern ptrnCreateCourse = Pattern.compile("create\\s+course|cc", Pattern.CASE_INSENSITIVE);
        Pattern ptrnShowCourse = Pattern.compile("(show\\s+course)|(sc)\\s+(?<id>\\d+)", Pattern.CASE_INSENSITIVE);
        Pattern ptrnShowCourses = Pattern.compile("show\\s+courses|ss", Pattern.CASE_INSENSITIVE);
        Pattern ptrnHelp = Pattern.compile("help|[?]", Pattern.CASE_INSENSITIVE);
        Pattern ptrnExit = Pattern.compile("exit|quit|[q]", Pattern.CASE_INSENSITIVE);
        Pattern ptrnCreateStudent = Pattern.compile("create\\s+student|cs", Pattern.CASE_INSENSITIVE);
        Pattern ptrnClearDb = Pattern.compile("clear\\s+db|cdb", Pattern.CASE_INSENSITIVE);



        System.out.println("Starting project \"Student\" (by Ostrenko V.)");
        boolean exit = false;

        do {
            System.out.println("Please, enter command:");
            commandString = scanner.nextLine();
            Matcher matcherExit = ptrnExit.matcher(commandString);
            Matcher matcherHelp = ptrnHelp.matcher(commandString);
            Matcher matcherCreateCourse = ptrnCreateCourse.matcher(commandString);
            Matcher matcherShowCourse = ptrnShowCourse.matcher(commandString);
            Matcher matcherShowCourses = ptrnShowCourses.matcher(commandString);
            Matcher matcherCreateStudent = ptrnCreateStudent.matcher(commandString);
            Matcher matcherClearDv = ptrnClearDb.matcher(commandString);

            //List of available commands
            if (matcherHelp.matches()) {
                listCommands();
                continue;
            }

            //Create the course
            if (matcherCreateCourse.matches()) {
                System.out.println("CREATE COURSE");
                Course newCourse = courseManager.create(scanner);
                courseDao.create(newCourse);
                System.out.printf("New course was succesfully created:\n%s\n", newCourse);
                continue;
            }

            //Show the course by id
            if (matcherShowCourse.matches()) {
                System.out.println("SHOW COURSE");
                Course tempCourse = courseDao.read(Integer.parseInt(matcherShowCourse.group("id")));
                String report = (tempCourse == null) ? "No such course" : tempCourse.toString();
                System.out.println(report);
                continue;
            }

            //Show all courses
            if (matcherShowCourses.matches()) {
                System.out.println("SHOW ALL COURSES");
                Set<Course> tempCourse = courseDao.getCollection();
                int i = 1;
                for (Course c : tempCourse) {
                    System.out.println(i++ + ". " + c.getName());
                }
                continue;
            }

            //Create the student
            if (matcherCreateStudent.matches()) {
                Student tempStudent = studentManager.create(scanner);
                studentDao.create(tempStudent);
                continue;
            }

            //Clear databases
            if (matcherClearDv.matches()){
                courseDao.clearDb();
                studentDao.clearDb();
                continue;
            }

            //Exit the program
            if (matcherExit.matches()) {
                System.out.println("Exiting...");
                exit = true;
                continue;
            }

            System.out.println("Unknown command");

        } while (!exit);
    }
}
