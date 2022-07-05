package com.workshop;

import static com.workshop.departments.Department.FINANCE;
import static com.workshop.departments.Department.IT;
import static com.workshop.departments.Department.MARKETING;
import static com.workshop.departments.Department.OPERATIONS;
import static com.workshop.departments.Department.SALES;

import com.opencsv.exceptions.CsvValidationException;
import com.workshop.employees.EmployeesService;
import com.workshop.employees.EmployeesStorage;
import com.workshop.employees.Manager;
import com.workshop.employees.csv.EmployeesCsvService;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {
        System.out.println("1");
        addAndPrintEmployees();

        System.out.println("2");

        try {
            readEmployeesFromCsvAndPrint();
        } catch (CsvValidationException | IOException e) {
            System.out.println(e);
            LocalDateTime now = LocalDateTime.now();
        }
    }

    private static void readEmployeesFromCsvAndPrint() throws CsvValidationException, IOException {
        var service = new EmployeesService(new EmployeesStorage());
        var filePath = Path.of("src", "main", "resources", "employees.csv");

        System.out.println("=== Adding employees from csv file");

        // 1. read employees from csv file
        var employees = new EmployeesCsvService().readEmployeesCsv(filePath.toString());

        // 2. add employees to storage
        employees
            .forEach(e -> {
                if (e instanceof Manager) {
                    service.addManager(e.getFirstname(), e.getLastname(), e.getDepartment());
                } else {
                    service.addEmployee(e.getFirstname(), e.getLastname(), e.getDepartment());
                }
            });

        // 3. print employees
        System.out.println(service.printEmployees());
        System.out.println();
    }

    private static void addAndPrintEmployees() {
        System.out.println("=== Adding employees in Application class");
        var service = new EmployeesService(new EmployeesStorage());

        service.addEmployee("Victor", "Smith", MARKETING);
        service.addEmployee("John", "Moss", OPERATIONS);
        service.addEmployee("Jason", "Henson", SALES);
        service.addEmployee("Fred", "Martinez", FINANCE);
        service.addEmployee("Jeremy", "Mason", IT);

        service.addManager("Brian", "Martin", MARKETING);
        service.addManager("Walter", "Black", FINANCE);

        System.out.println(service.printEmployees());
        System.out.println();
    }

}
