package com.brainacad.oop.students.dao.collection;

import com.brainacad.oop.students.dao.Dao;
import com.brainacad.oop.students.model.Student;

import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Matcher;

public class StudentCollectionDao extends CollectionDao<Student> {

    public StudentCollectionDao() {
        super();
    }

    @Override
    public Student read(int id) {
        for (Student student : this.getCollection()) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
