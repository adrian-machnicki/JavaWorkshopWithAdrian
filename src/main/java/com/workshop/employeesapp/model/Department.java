package com.workshop.employeesapp.model;

import com.workshop.employeesapp.exception.DepartmentIUnknownException;
import java.util.Arrays;

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

    public static Department findByLabel(String label) {
        return Arrays.stream(Department.values())
            .filter(d -> d.label.equals(label))
            .findFirst()
            .orElseThrow(() -> new DepartmentIUnknownException("Unknown department: %s".formatted(label)));
    }

    public String getLabel() {
        return label;
    }
}
