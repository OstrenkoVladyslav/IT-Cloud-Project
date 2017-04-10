package com.brainacad.oop.students.dao.database;

import com.brainacad.oop.students.model.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class CourseDbDao extends DbDao<Course> {

    public CourseDbDao() {
        super();
    }

    @Override
    public Course read(int id) {
        String query = String.format("SELECT * FROM courses WHERE id=%s", id);
        Course course = null;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int teacherId = resultSet.getInt("teacher");
                String startDate_String = resultSet.getString("startdate");
                String endDate_String = resultSet.getString("enddate");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = df.parse(startDate_String);
                Date endDate = df.parse(endDate_String);
                course = new Course(id, name, description, teacherId, startDate, endDate);
            }
        } catch (SQLException|ParseException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public boolean add(Course course) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = df.format(course.getStartDate());
        String endDate = df.format(course.getEndDate());
        String query = String.format("INSERT INTO courses (name,description,startdate,enddate) VALUES ('%s','%s','%s','%s')",
                course.getName(), course.getDescription(), startDate, endDate);
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void update(Course course) {
        //return null;
    }

    @Override
    public Set<Course> getCollection() {
        Set<Course> collection = new LinkedHashSet<>();
        String query = "SELECT * FROM courses ORDER BY id";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int teacherId = resultSet.getInt("teacher");
                String startDate_String = resultSet.getString("startdate");
                String enddate_String = resultSet.getString("enddate");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = df.parse(startDate_String);
                Date endDate = df.parse(enddate_String);
                collection.add(new Course(id, name, description, teacherId, startDate, endDate));
            }
        } catch (SQLException|ParseException e) {
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

    @Override
    public int getSize(){
        int size = 0;
        String query = "SELECT COUNT(*) FROM courses";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./database.db");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            size = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }

    @Override //TODO not realized
    public void delete(int id) {
    }
}
