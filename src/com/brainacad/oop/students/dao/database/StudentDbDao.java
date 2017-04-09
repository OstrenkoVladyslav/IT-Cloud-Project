package com.brainacad.oop.students.dao.database;

import com.brainacad.oop.students.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

public class StudentDbDao extends DbDao<Student> {

    public StudentDbDao() {
        super();
    }

    @Override
    public void create(Student student) {
        String query = String.format("INSERT INTO students (name,surname,age) VALUES ('%s','%s','%d')", student.getName(), student.getSurname(), student.getAge());
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
