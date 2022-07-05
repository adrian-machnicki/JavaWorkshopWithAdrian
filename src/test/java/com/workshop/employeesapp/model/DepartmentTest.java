package com.workshop.employeesapp.model;

import static com.workshop.employeesapp.model.Department.FINANCE;
import static com.workshop.employeesapp.model.Department.IT;
import static com.workshop.employeesapp.model.Department.MARKETING;
import static com.workshop.employeesapp.model.Department.OPERATIONS;
import static com.workshop.employeesapp.model.Department.SALES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.workshop.employeesapp.exception.DepartmentIUnknownException;
import org.junit.jupiter.api.Test;

class DepartmentTest {

    @Test
    void shouldFindDepartmentByLabel() {
        assertEquals(MARKETING, Department.findByLabel("Marketing"));
        assertEquals(OPERATIONS, Department.findByLabel("Operations"));
        assertEquals(SALES, Department.findByLabel("Sales"));
        assertEquals(FINANCE, Department.findByLabel("Finance"));
        assertEquals(IT, Department.findByLabel("IT"));
    }

    @Test
    void shouldThrowExceptionWhenNotFoundByLabel() {
        assertThrows(DepartmentIUnknownException.class, () -> Department.findByLabel("???"));
    }

}