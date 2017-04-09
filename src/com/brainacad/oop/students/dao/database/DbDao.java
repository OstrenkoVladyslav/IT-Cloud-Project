package com.brainacad.oop.students.dao.database;

import com.brainacad.oop.students.dao.Dao;
import com.brainacad.oop.students.model.HasID;

import java.sql.*;
import java.util.Collection;
import java.util.Set;

public class DbDao<T extends HasID> implements Dao<T> {
    private Collection<T> set;
    private ResultSet resultSet;

    DbDao() {
    }

    @Override
    public void create(T t) {
        //this.set.add(t);
    }

    @Override
    public T read(int id) {
        return null;
    }

    @Override
    public void update(T t) {

    }

    @Override //TODO not realized
    public void delete(int id) {

    }

    @Override
    public Set<T> getCollection() {
        return null;
    }

    @Override
    public void clearDb() {
    }
}
