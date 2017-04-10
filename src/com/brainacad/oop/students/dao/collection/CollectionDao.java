package com.brainacad.oop.students.dao.collection;

import com.brainacad.oop.students.dao.Dao;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class CollectionDao<T> implements Dao<T> {
    private Collection<T> set;

    CollectionDao() {
        set = new LinkedHashSet<>();
    }

    @Override
    public boolean add(T t) {
        this.set.add(t);
        return true;
    }

    @Override
    public abstract T read(int id);

    @Override
    public void update(T t) {

    }

    @Override //TODO not realized
    public void delete(int id) {

    }

    @Override
    public Set<T> getCollection() {
        return new LinkedHashSet<>(set);
    }

    @Override
    public int getSize(){
        return set.size();
    }

    @Override
    public void clearDb() {
        System.out.println("Not applicable for collections");
    }
}
