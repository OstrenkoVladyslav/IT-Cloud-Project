package com.brainacad.oop.students.managers;

import com.brainacad.oop.students.model.CourseStudent;

public class CourseStudentManager {
    public CourseStudentManager(){

    }

    public CourseStudent create(int courseId, int studentId){
        return new CourseStudent(courseId, studentId);
    }
}
