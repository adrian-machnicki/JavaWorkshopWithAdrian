package com.workshop.employeesapp.repository;

import com.workshop.employeesapp.model.Employee;
import com.workshop.employeesapp.model.Manager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class EmployeesStorage implements Repository<Employee> {

    private final List<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    @Override
    public Employee add(Employee employee) {
        Employee newEmployee;
        if (employee instanceof Manager) {
            newEmployee = new Manager(nextId++, employee.getFirstname(), employee.getLastname(), employee.getDepartment());
        } else {
            newEmployee = new Employee(nextId++, employee.getFirstname(), employee.getLastname(), employee.getDepartment());
        }

        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee get(int id) {
        try {
            return employees.get(id - 1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public List<Employee> getAll() {
        return employees.stream()
            .filter(Objects::nonNull)
            .sorted(Comparator.comparingInt(Employee::getId))
            .toList();
    }

    @Override
    public int count() {
        return (int) employees.stream()
            .filter(Objects::nonNull)
            .count();
    }

}
