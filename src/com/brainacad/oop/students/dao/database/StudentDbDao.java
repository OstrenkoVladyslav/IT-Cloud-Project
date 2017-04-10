package com.brainacad.oop.students.dao.database;

import com.brainacad.oop.students.model.Student;

import java.sql.*;
import java.util.Set;

public class StudentDbDao extends DbDao<Student> {

    public StudentDbDao() {
        super();
    }

    @Override
    public boolean add(Student student) {
        String query = String.format("INSERT INTO students (name,surname,age) VALUES ('%s','%s','%d')", student.getName(), student.getSurname(), student.getAge());
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Student read(int id) {
        return null;
    }

    @Override
    public Set<Student> getCollection() {
        return null;
    }

    @Override
    public int getSize(){
        int size = 0;
        String query = "SELECT COUNT(*) FROM students";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            size = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }

    @Override
    public void clearDb() {

    }
}
