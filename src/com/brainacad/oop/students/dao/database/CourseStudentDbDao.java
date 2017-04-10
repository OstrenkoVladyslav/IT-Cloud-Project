package com.brainacad.oop.students.dao.database;

import com.brainacad.oop.students.model.CourseStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.LinkedHashSet;
import java.util.Set;

public class CourseStudentDbDao extends DbDao<CourseStudent> {

    @Override
    public boolean add(CourseStudent courseStudent) {
        String query = String.format("INSERT INTO coursestudent (courseid,studentid) VALUES ('%s','%s')",
                courseStudent.getCourseId(), courseStudent.getStudentId());
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public CourseStudent read(int id) {
        String query = String.format("SELECT * FROM coursestudent WHERE id=%s", id);
        CourseStudent courseStudent = null;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int courseId = resultSet.getInt("courseid");
                int studentId = resultSet.getInt("studentid");
                courseStudent = new CourseStudent(courseId, studentId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseStudent;
    }

    @Override
    public Set<CourseStudent> getCollection() {
        Set<CourseStudent> collection = new LinkedHashSet<>();
        String query = "SELECT * FROM coursestudent";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int courseId = resultSet.getInt("courseId");
                int studentId = resultSet.getInt("studentId");
                collection.add(new CourseStudent(courseId, studentId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collection;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void clearDb() {

    }
}
