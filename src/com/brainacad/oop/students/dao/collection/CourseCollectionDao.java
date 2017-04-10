package com.brainacad.oop.students.dao.collection;

import com.brainacad.oop.students.model.Course;

import java.util.Set;

public class CourseCollectionDao extends CollectionDao<Course> {

    public CourseCollectionDao() {
        super();
    }

    @Override
    public Course read(int id) {
        for (Course course : this.getCollection()) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }
}
