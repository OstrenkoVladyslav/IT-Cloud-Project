package com.brainacad.oop.students.model;

import java.io.Serializable;
import java.util.HashMap;

public class Journal implements Serializable {
    private HashMap<Task, Integer> tasks;
}
