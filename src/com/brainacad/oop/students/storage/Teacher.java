package com.brainacad.oop.students.storage;

public class Teacher extends Man {
    private static int idCounter = 0;
    private int id;

    public Teacher(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = ++idCounter;
    }

    @Override
    public String toString() {
        return (String.format("id: %d. %s %s", id, surname, name));
    }
}
