package com.brainacad.oop.students.dao.database;

import com.brainacad.oop.students.dao.Dao;
import com.brainacad.oop.students.model.HasID;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DbDao<T extends HasID> implements Dao<T> {
    private Collection<T> set;

    DbDao() {
        set = new HashSet<>();
    }

    @Override
    public void create(T t) {
        this.set.add(t);
    }

    @Override
    public T read(int id) {
        for (T t : set) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public T getId(int id) {
        return null;
    }

    @Override
    public Set<T> getCollection() {
        return null;
    }
}
