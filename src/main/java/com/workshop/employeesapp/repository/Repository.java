package com.workshop.employeesapp.repository;

import java.util.List;

public interface Repository<T> {

    T add(T entity);
    T get(int id);
    List<T> getAll();
    int count();

}
