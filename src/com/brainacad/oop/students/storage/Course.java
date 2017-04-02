package com.brainacad.oop.students.storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Set;

public final class Course {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String description;
    private Teacher teacher;
    private Set<Student> students;
//    private GregorianCalendar dateStart;
//    private GregorianCalendar dateEnd;
//    private daysOfWeek daysOfWeek;
//
//    private enum daysOfWeek {
//        MONDAY,
//        TUESDAY,
//        WEDNESDAY,
//        THURSDAY,
//        FRIDAY,
//        SATURDAY,
//        SUNDAY
//    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

//    public GregorianCalendar getDateStart() {
//        return dateStart;
//    }
//
//    public GregorianCalendar getDateEnd() {
//        return dateEnd;
//    }
//
//    public Course.daysOfWeek getDaysOfWeek() {
//        return daysOfWeek;
//    }

    public boolean setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return true;
    }

    @Override
    public String toString() {
        return ("Course ID: " + id
                + "\nCourse name: " + this.getName()
                + "\nCourse description: " + this.getDescription()
                + "\nStart date: "
                + "\nEnd date: "
                + "\nDays: "
                + "\nTrainer: " + this.getTeacher());
    }

//    public int compareTo(Course other) {
//        return (id-other.getId());
//    }
}
