package com.workshop.employees;

import com.workshop.departments.Department;

public class Manager extends Employee {

    public Manager(String firstname, String lastname, Department department) {
        super(firstname, lastname, department);
    }

    @Override
    public String toString() {
        return "Manager{" + id + ", " + firstname + ' ' + lastname + ", " + department + '}';
    }
}
