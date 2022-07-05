package com.workshop.employeesapp.service.csv;

import com.workshop.employeesapp.model.Department;

// TODO convert to a record
class EmployeeLineDto {

    final String firstname;
    final String lastname;
    final Department department;
    final boolean isManager;

    public EmployeeLineDto(String firstname, String lastname, Department department, boolean isManager) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.isManager = isManager;
    }
}
