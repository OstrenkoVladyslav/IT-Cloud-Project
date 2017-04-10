package com.brainacad.oop.students.dao.database;

import com.brainacad.oop.students.dao.Dao;

import java.util.Set;

public abstract class DbDao<T> implements Dao<T> {

    DbDao() {
    }

    @Override
    public abstract boolean add(T t);

    @Override
    public abstract T read(int id);

    @Override
    public void update(T t) {
    }

    @Override //TODO not realized
    public void delete(int id) {

    }

    @Override
    public abstract Set<T> getCollection();

    @Override
    public abstract int getSize();

    @Override
    public abstract void clearDb();
}
