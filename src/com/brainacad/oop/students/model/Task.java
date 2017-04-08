package com.brainacad.oop.students.model;

import java.io.Serializable;

public class Task implements Serializable {
    private String name;
    private String description;

    public Task(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getCourse (String name){
        return description;
    }
}
