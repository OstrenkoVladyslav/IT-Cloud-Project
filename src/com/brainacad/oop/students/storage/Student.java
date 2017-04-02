package com.brainacad.oop.students.storage;

import java.util.Set;

public class Student {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String surname;
    private int age;
    private Set<Group> groups;
    private Set<Task> tasks;
    private Journal journal;
}
