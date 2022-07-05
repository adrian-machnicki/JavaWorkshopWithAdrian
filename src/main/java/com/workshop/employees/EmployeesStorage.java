package com.workshop.employees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class EmployeesStorage {

    private final List<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    public Employee add(Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
        return employee;
    }

    public Employee get(int id) {
        try {
            return employees.get(id - 1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public List<Employee> getAll() {
        return employees.stream()
            .filter(Objects::nonNull)
            .sorted(Comparator.comparingInt(Employee::getId))
            .toList();
    }

    public int count() {
        return (int) employees.stream()
            .filter(Objects::nonNull)
            .count();
    }

}
