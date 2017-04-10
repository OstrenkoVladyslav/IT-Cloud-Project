package com.brainacad.oop.students;

import com.brainacad.oop.students.dao.Dao;
import com.brainacad.oop.students.dao.collection.*;
import com.brainacad.oop.students.dao.database.CourseDbDao;
import com.brainacad.oop.students.dao.database.DbDao;
import com.brainacad.oop.students.dao.database.StudentDbDao;
import com.brainacad.oop.students.dao.database.TeacherDbDao;
import com.brainacad.oop.students.managers.CourseManager;
import com.brainacad.oop.students.managers.CourseStudentManager;
import com.brainacad.oop.students.managers.StudentManager;
import com.brainacad.oop.students.managers.TeacherManager;
import com.brainacad.oop.students.model.Course;
import com.brainacad.oop.students.model.CourseStudent;
import com.brainacad.oop.students.model.Student;
import com.brainacad.oop.students.model.Teacher;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        System.out.println("\"create student\": create new student");
        System.out.println("\"enroll student # (add|remove) #\": (un)enroll student #id to course #id");
        System.out.println("UNREALIZED YET Student info");
        System.out.println("UNREALIZED YET Sign in teacher");
        System.out.println("UNREALIZED YET Teacher info");
        System.out.println("UNREALIZED YET Create task");
        System.out.println("UNREALIZED YET All students list");
        System.out.println("UNREALIZED YET Grades journal");
        System.out.println("UNREALIZED YET Save journal to file");
        System.out.println("\"clear db\": clears database");
        System.out.println("\"quit\": quit program");
    }

    public static void fillTeachers(Dao<Teacher> teacherDao) {
        teacherDao.add(new Teacher("Sidor", "Kolobkov"));
        teacherDao.add(new Teacher("Mikhail", "Potapov"));
        teacherDao.add(new Teacher("Leopold", "Kotovsky"));
    }

    public static void fillCourses(Dao<Course> courseDao) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            courseDao.add(new Course("Java", "Java for beginners", 1, df.parse("2017-04-12"), df.parse("2017-04-12")));
            courseDao.add(new Course("C#", "C# for seniors", 2, df.parse("2017-01-30"), df.parse("2017-04-12")));
            courseDao.add(new Course("Scala", "All about Scala", 3, df.parse("2017-01-30"), df.parse("2017-04-12")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CourseManager courseManager = new CourseManager();
        StudentManager studentManager = new StudentManager();
        TeacherManager teacherManager = new TeacherManager();
        CourseStudentManager courseStudentManager = new CourseStudentManager();

        Dao<Student> studentDao = new StudentDbDao();
        Dao<Course> courseDao = new CourseDbDao();
        Dao<Teacher> teacherDao = new TeacherDbDao();
        Dao<CourseStudent> courseStudentDao = new CourseStudentCollectionDao();

//      for test purposes
//        fillTeachers(teacherDao);
//        fillCourses(courseDao);

        Scanner scanner = new Scanner(System.in);
        String commandString;

        Pattern ptrnCreateCourse = Pattern.compile("(create\\s+course)|(cc)", Pattern.CASE_INSENSITIVE);
        Pattern ptrnShowCourse = Pattern.compile("(show\\s+course)|(sc)\\s+(?<id>\\d+)", Pattern.CASE_INSENSITIVE);
        Pattern ptrnShowCourses = Pattern.compile("(show\\s+courses)|(ss)", Pattern.CASE_INSENSITIVE);
        Pattern ptrnHelp = Pattern.compile("help|[?]", Pattern.CASE_INSENSITIVE);
        Pattern ptrnExit = Pattern.compile("exit|quit|[q]", Pattern.CASE_INSENSITIVE);
        Pattern ptrnCreateStudent = Pattern.compile("(create\\s+student)|(cs)", Pattern.CASE_INSENSITIVE);
        Pattern ptrnEnrollStudent = Pattern.compile("(enroll\\s+student)|(es)\\s+(?<studentId>\\d+)\\s+(?<courseId>\\d+)", Pattern.CASE_INSENSITIVE);
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
            Matcher matcherEnrollStudent = ptrnEnrollStudent.matcher(commandString);
            Matcher matcherClearDv = ptrnClearDb.matcher(commandString);

            //List of available commands
            if (matcherHelp.matches()) {
                listCommands();
                continue;
            }

            //Create the course
            if (matcherCreateCourse.matches()) {
                Course newCourse = courseManager.create(scanner);
                courseDao.add(newCourse);
                System.out.printf("New course was succesfully created:\n%s\n", newCourse);
                continue;
            }

            //Show the course by id
            if (matcherShowCourse.matches()) {
                Course tempCourse = courseDao.read(Integer.parseInt(matcherShowCourse.group("id")));
                String report = (tempCourse == null) ? "No such course" : tempCourse.toString();
                System.out.println(report);
                continue;
            }

            //Show all courses
            if (matcherShowCourses.matches()) {
                Set<Course> tempCourse = courseDao.getCollection();
                courseManager.list(tempCourse);
                continue;
            }

            //Create the student
            if (matcherCreateStudent.matches()) {
                Student tempStudent = studentManager.create(scanner);
                studentDao.add(tempStudent);
                continue;
            }

            //Enroll student to course
            if (matcherEnrollStudent.matches()) {
                int studentId = Integer.parseInt(matcherEnrollStudent.group("studentId"));
                int courseId = Integer.parseInt(matcherEnrollStudent.group("courseId"));
                CourseStudent cs = courseStudentManager.create(courseId, studentId);
                courseStudentDao.add(cs);
                continue;
            }

            //Clear databases
            if (matcherClearDv.matches()) {
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
