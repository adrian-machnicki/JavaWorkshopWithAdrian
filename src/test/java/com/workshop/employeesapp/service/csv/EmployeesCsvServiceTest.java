package com.workshop.employeesapp.service.csv;

import static com.workshop.employeesapp.model.Department.MARKETING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.workshop.employeesapp.model.Employee;
import com.workshop.employeesapp.model.Manager;
import com.workshop.employeesapp.repository.EmployeesStorage;
import com.workshop.employeesapp.repository.Repository;
import com.workshop.employeesapp.service.EmployeeService;
import com.workshop.employeesapp.service.SimpleEmployeesService;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeesCsvServiceTest {

    EmployeesCsvService csvService;
    EmployeeService employeeService;

    @BeforeEach
    void setup() {
        Repository<Employee> employeeRepository = new EmployeesStorage();
        employeeService = new SimpleEmployeesService(employeeRepository);
        csvService = new EmployeesCsvService(employeeService);
    }

    @Test
    void shouldImportEmployeesFromCsv() throws Exception {
        // given a csv path containing 2 employees (1 regular employee + 1 manager)
        var csvPath = Path.of("src", "test", "resources", "test-employees.csv");

        // when importing employees
        csvService.importEmployeesFromCsv(csvPath.toString());

        // then employees are added to the employees service
        var employeesCount = employeeService.count();
        assertEquals(2, employeesCount);

        // and manager is correctly added
        var manager = employeeService.get(1);
        assertInstanceOf(Manager.class, manager);
        assertEquals("Larry", manager.getFirstname());
        assertEquals("Rose", manager.getLastname());
        assertEquals(MARKETING, manager.getDepartment());

        // and regular employee is correctly added
        var employee = employeeService.get(2);
        assertInstanceOf(Employee.class, employee);
        assertEquals("Christopher", employee.getFirstname());
        assertEquals("Carrillo", employee.getLastname());
        assertEquals(MARKETING, employee.getDepartment());
    }

    @Test
    void shouldThrowExceptionWhenFileNotFound() {
        // given a file doesn't exist
        var nonExistentFilePath = "nosuchfile";

        // when trying to import employees
        // then the exception is thrown
        assertThrows(FileNotFoundException.class, () -> csvService.importEmployeesFromCsv(nonExistentFilePath));
    }

}