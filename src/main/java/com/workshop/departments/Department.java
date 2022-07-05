package com.workshop.departments;

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
}
