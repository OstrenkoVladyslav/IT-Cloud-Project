package com.brainacad.oop.students.dao.collection;

import com.brainacad.oop.students.dao.Dao;
import com.brainacad.oop.students.model.Student;

import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Matcher;

public class StudentCollectionDao extends CollectionDao<Student> {
    private Collection<Student> students;

    public StudentCollectionDao() {
        super();
    }

    public void add(Scanner s, Matcher m) {

    }

    @Override
    public Student read(int id) {
        return super.read(id);
    }

    @Override
    public void update(Student t) {
        //return null;
    }

    @Override
    public void delete(int t) {

    }
}
