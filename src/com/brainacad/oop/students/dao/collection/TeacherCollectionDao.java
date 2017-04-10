package com.brainacad.oop.students.dao.collection;

import com.brainacad.oop.students.model.Teacher;

public class TeacherCollectionDao extends CollectionDao<Teacher> {

    @Override
    public Teacher read(int id) {
        for (Teacher teacher : this.getCollection()) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }
}
