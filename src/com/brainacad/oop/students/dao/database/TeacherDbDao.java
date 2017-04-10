package com.brainacad.oop.students.dao.database;

import com.brainacad.oop.students.model.Teacher;

import java.sql.*;
import java.util.Set;

public class TeacherDbDao extends DbDao<Teacher>{

    @Override
    public boolean add(Teacher teacher) {
        String query = String.format("INSERT INTO teachers (name,surname) VALUES ('%s','%s')",
                teacher.getName(), teacher.getSurname());
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

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

    @Override
    public Set<Teacher> getCollection() {
        return null;
    }

    @Override
    public int getSize(){
        int size = 0;
        String query = "SELECT COUNT(*) FROM teachers";
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
