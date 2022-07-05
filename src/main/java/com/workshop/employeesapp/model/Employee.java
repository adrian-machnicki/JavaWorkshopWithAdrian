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

    @Override
    public String toString() {
        return "Employee{" + id + ", " + firstname + ' ' + lastname + ", " + department + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmploymentLevel() {
        return this.getClass().toString();
    }
}
