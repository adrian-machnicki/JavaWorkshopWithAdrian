package com.workshop.employeesapp.service;

import com.workshop.employeesapp.model.Department;
import com.workshop.employeesapp.model.Employee;
import com.workshop.employeesapp.model.Manager;
import com.workshop.employeesapp.repository.Repository;
import java.util.stream.Collectors;

public class SimpleEmployeesService implements EmployeeService {

    private final Repository<Employee> repository;

    public SimpleEmployeesService(Repository<Employee> repository) {
        this.repository = repository;
    }

    public Employee addEmployee(String firstname, String lastname, Department department) {
        var employee = new Employee(firstname, lastname, department);
        return repository.add(employee);
    }

    public Employee addManager(String firstname, String lastname, Department department) {
        var manager = new Manager(firstname, lastname, department);
        return repository.add(manager);
    }

    public Employee get(int id) {
        return repository.get(id);
    }

    public String printEmployees() {
        return repository.getAll().stream()
            .map("* %s"::formatted)
            .collect(Collectors.joining("\n"));
    }

    @Override
    public int count() {
        return repository.count();
    }
}
