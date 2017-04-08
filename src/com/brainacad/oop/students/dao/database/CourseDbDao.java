package com.brainacad.oop.students.dao.database;

import com.brainacad.oop.students.model.Course;

public class CourseDbDao extends DbDao<Course> {

    public CourseDbDao() {
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
