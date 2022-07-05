package com.workshop.employeesapp.service;

import com.workshop.employeesapp.model.Department;
import com.workshop.employeesapp.model.Employee;

public interface EmployeeService {

    Employee addEmployee(String firstname, String lastname, Department department);
    Employee addManager(String firstname, String lastname, Department department);
    Employee get(int id);
    String printEmployees();
    int count();

}
