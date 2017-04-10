package com.brainacad.oop.students.dao.collection;

import com.brainacad.oop.students.model.CourseStudent;

public class CourseStudentCollectionDao extends CollectionDao<CourseStudent>  {
    public CourseStudentCollectionDao() {
        super();
    }

    public boolean add(CourseStudent cs){
        return true;
    }

    @Override
    public CourseStudent read(int id) {
        return null;
    }
}
