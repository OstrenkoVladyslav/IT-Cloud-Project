package com.brainacad.oop.students.dao.collection;

import com.brainacad.oop.students.dao.Dao;
import com.brainacad.oop.students.model.HasID;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CollectionDao<T extends HasID> implements Dao<T> {
    private Collection<T> set;

    CollectionDao() {
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
    public Set<T> getCollection() {
        return new HashSet<>(set);
    }

    @Override
    public void clearDb() {
        System.out.println("Not applicable for collections");
    }

    public int getSize(){
        return set.size();
    }

    public boolean hasNext(){
        return set.iterator().hasNext();
    }

    public T next(){
        return set.iterator().next();
    }
}
