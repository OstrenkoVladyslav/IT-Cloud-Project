package com.brainacad.oop.students.dao.database;

import com.brainacad.oop.students.model.Course;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CourseDbDao extends DbDao<Course> {

    public CourseDbDao() {
        super();
    }

    @Override
    public Course read(int id) {
        String query = String.format("SELECT FROM courses WHERE id=%d", id);
        Course course = null;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int teacher = resultSet.getInt("teacher");
                String startDate_String = resultSet.getString("startdate");
                String enddate_String = resultSet.getString("enddate");
                LocalDate startDate = LocalDate.parse(startDate_String, DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate endDate = LocalDate.parse(enddate_String, DateTimeFormatter.ISO_LOCAL_DATE);
                course = new Course(name, description, teacher, startDate, endDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public void create(Course course) {
        String query = String.format("INSERT INTO courses (name,description,startdate,enddate) VALUES ('%s','%s','%s','%s')", course.getName(), course.getDescription(), course.getStartDate().format(DateTimeFormatter.ISO_LOCAL_DATE), course.getEndDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //@Override
    public void update(Course course) {
        //return null;
    }

    @Override
    public Set<Course> getCollection() {
        Set<Course> collection = new HashSet<>();
        String query = "SELECT * FROM courses";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int teacher = resultSet.getInt("teacher");
                String startDate_String = resultSet.getString("startdate");
                String enddate_String = resultSet.getString("enddate");
                LocalDate startDate = LocalDate.parse(startDate_String, DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate endDate = LocalDate.parse(enddate_String, DateTimeFormatter.ISO_LOCAL_DATE);
                collection.add(new Course(name, description, teacher, startDate, endDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collection;
    }

    @Override
    public void clearDb() {
        String query = "DELETE FROM courses;";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to clear database? y/n");
        String answer = scanner.nextLine();
        if (answer.equals("Y") || answer.equals("y")) {
            try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Database Courses cleared");
        }
    }

    @Override //TODO not realized
    public void delete(int id) {
    }
}
