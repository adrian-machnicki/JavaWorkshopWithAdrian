package com.workshop.employeesapp.service;

import com.workshop.employeesapp.model.Employee;
import com.workshop.employeesapp.repository.EmployeesStorage;
import com.workshop.employeesapp.model.Manager;
import com.workshop.employeesapp.model.Department;
import java.util.stream.Collectors;

public class EmployeesService {

    private final EmployeesStorage storage;

    public EmployeesService(EmployeesStorage storage) {
        this.storage = storage;
    }

    public Employee addEmployee(String firstname, String lastname, Department department) {
        var employee = new Employee(firstname, lastname, department);
        return storage.add(employee);
    }

    public Employee addManager(String firstname, String lastname, Department department) {
        var manager = new Manager(firstname, lastname, department);
        return storage.add(manager);
    }

    public Employee get(int id) {
        return storage.get(id);
    }

    public String printEmployees() {
        return storage.getAll().stream().map("* %s"::formatted).collect(Collectors.joining("\n"));
    }
}
