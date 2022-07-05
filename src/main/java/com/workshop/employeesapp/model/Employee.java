package com.workshop.employeesapp.model;


public class Employee {

    protected int id;
    protected final String firstname;
    protected final String lastname;
    protected final Department department;

    public Employee(String firstname, String lastname, Department department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
    }

    public Employee(int id, String firstname, String lastname, Department department) {
        this(firstname, lastname, department);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" + id + ", " + firstname + ' ' + lastname + ", " + department.getLabel() + '}';
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Department getDepartment() {
        return department;
    }
}
