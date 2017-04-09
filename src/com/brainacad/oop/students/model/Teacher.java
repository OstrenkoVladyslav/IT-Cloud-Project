package com.brainacad.oop.students.model;

import java.io.Serializable;

public class Teacher implements Serializable, HasID {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String surname;

    public Teacher(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = ++idCounter;
    }

    @Override
    public String toString() {
        return (String.format("id: %d. %s %s", id, surname, name));
    }

    @Override
    public int getId() {
        return id;
    }
}
