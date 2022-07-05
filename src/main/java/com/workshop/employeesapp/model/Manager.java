package com.workshop.employeesapp.model;

public class Manager extends Employee {

    public Manager(String firstname, String lastname, Department department) {
        super(firstname, lastname, department);
    }

    public Manager(int id, String firstname, String lastname, Department department) {
        super(id, firstname, lastname, department);
    }

    @Override
    public String toString() {
        return "Manager{" + id + ", " + firstname + ' ' + lastname + ", " + department.getLabel() + '}';
    }
}
