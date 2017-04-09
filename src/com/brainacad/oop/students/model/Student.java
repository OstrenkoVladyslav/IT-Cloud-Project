package com.brainacad.oop.students.model;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable, HasID {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String surname;
    private int age;
    private Set<Group> groups;
    private Set<Task> tasks;
    private Journal journal;

    public Student(String name, String surname, int age){
        this.id = ++idCounter;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getId(){
        return id;
    }
}
