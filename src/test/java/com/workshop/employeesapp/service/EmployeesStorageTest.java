package com.workshop.employeesapp.service;

import static com.workshop.employeesapp.model.Department.FINANCE;
import static com.workshop.employeesapp.model.Department.IT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.workshop.employeesapp.model.Employee;
import com.workshop.employeesapp.repository.EmployeesStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeesStorageTest {

    EmployeesStorage storage;

    @BeforeEach
    void setup() {
        storage = new EmployeesStorage();
    }

    @Test
    void shouldAddEmployeeAndSetId() {
        // given
        var employee = new Employee("John", "Smith", FINANCE);

        // when
        var addedEmployee = storage.add(employee);

        // then
        assertEquals(1, addedEmployee.getId());
        assertEquals(employee.getFirstname(), addedEmployee.getFirstname());
        assertEquals(employee.getLastname(), addedEmployee.getLastname());
        assertEquals(1, storage.count());
    }

    @Test
    void shouldGetEmployee() {
        // given employee exists
        var employee = storage.add(new Employee("John", "Smith", IT));

        // when fetching employee
        var fetchedEmployee = storage.get(employee.getId());

        // then
        assertNotNull(fetchedEmployee);
    }

    @Test
    void shouldReturnNullIfDoesNotExist() {
        // when fetching non-existent employee
        var nonExistentEmployee = storage.get(5);
        assertNull(nonExistentEmployee);
    }

    @Test
    void shouldCountEmployeesCorrectly() {
        // given 5 employees where added
        for (int i = 0; i < 5; i++) {
            storage.add(new Employee("Employee", "No. " + i, IT));
        }

        // when counting employees
        var count = storage.count();

        // then
        assertEquals(5, count);
    }

}