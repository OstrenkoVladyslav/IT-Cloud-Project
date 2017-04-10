package com.brainacad.oop.students.model;

public class CourseStudent {
    private int courseId;
    private int studentId;

    public CourseStudent(int courseId, int studentId){
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
    }
}
