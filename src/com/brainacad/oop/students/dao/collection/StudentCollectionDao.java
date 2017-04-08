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
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(Student t) {
        //return null;
    }

    @Override
    public void delete(int t) {

    }

    @Override
    public Student getId(int id) {
        return null;
    }
}
