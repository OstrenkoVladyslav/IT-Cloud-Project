package com.brainacad.oop.students.dao.database;

import com.brainacad.oop.students.model.Course;
import com.brainacad.oop.students.model.Teacher;

import java.sql.*;

public class TeacherDbDao extends DbDao<Teacher>{

    @Override
    public Teacher read(int id) {
        String query = String.format("SELECT FROM teachers WHERE id=%d", id);
        Teacher teacher = null;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                teacher = new Teacher(name, surname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}
