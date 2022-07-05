package com.workshop.employeesapp.model;

public enum Department {
    MARKETING("Marketing"),
    OPERATIONS("Operations"),
    SALES("Sales"),
    FINANCE("Finance"),
    IT("IT");

    private final String label;

    Department(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
