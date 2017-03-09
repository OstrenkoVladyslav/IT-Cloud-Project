package com.brainacad.oop.students;

import java.util.GregorianCalendar;
import java.util.Set;

public final class Course {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String description;
    private Teacher teacher;
    private Set<Student> students;
    private GregorianCalendar dateStart;
    private GregorianCalendar dateEnd;
    private daysOfWeek daysOfWeek;

    private enum daysOfWeek{
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public Course(String name, String description){
        this.id = ++idCounter;
        this.name = name;
        this.description = description;
    }

    public boolean setTeacher (Teacher teacher){
        this.teacher = teacher;
        return true;
    }


}
