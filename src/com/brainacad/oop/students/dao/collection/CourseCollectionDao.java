package com.brainacad.oop.students.dao.collection;

import com.brainacad.oop.students.model.Course;

import java.util.Set;

public class CourseCollectionDao extends CollectionDao<Course> {

    public CourseCollectionDao() {
        super();
    }

    @Override
    public Course read(int id) {
        return super.read(id);
    }

    //@Override
    public void update(Course t) {
        //return null;
    }

    @Override
    public void delete(int t) {

    }

    @Override
    public Course getId(int id) {
        return null;
    }
}
