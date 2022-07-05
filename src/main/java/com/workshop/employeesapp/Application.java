package com.workshop.employeesapp;

import static com.workshop.employeesapp.model.Department.FINANCE;
import static com.workshop.employeesapp.model.Department.IT;
import static com.workshop.employeesapp.model.Department.MARKETING;
import static com.workshop.employeesapp.model.Department.OPERATIONS;
import static com.workshop.employeesapp.model.Department.SALES;

import com.opencsv.exceptions.CsvValidationException;
import com.workshop.employeesapp.repository.EmployeesStorage;
import com.workshop.employeesapp.service.SimpleEmployeesService;
import com.workshop.employeesapp.service.csv.EmployeesCsvService;
import java.io.IOException;
import java.nio.file.Path;

public class Application {

    public static void main(String[] args) {
        /*
        Playground
         */




        /*
        Add employees in code and print them
         */
        addAndPrintEmployees();

        /*
        Import employees from csv file and print them
         */
        try {
            readEmployeesFromCsvAndPrint();
        } catch (CsvValidationException | IOException e) {
            System.out.println(e);
        }
    }

    private static void addAndPrintEmployees() {
        System.out.println("===== Adding employees in Application class");
        var service = new SimpleEmployeesService(new EmployeesStorage());

        service.addEmployee("Victor", "Smith", MARKETING);
        service.addEmployee("John", "Moss", OPERATIONS);
        service.addEmployee("Jason", "Henson", SALES);
        service.addEmployee("Fred", "Martinez", FINANCE);
        service.addEmployee("Jeremy", "Mason", IT);

        service.addManager("Brian", "Martin", MARKETING);
        service.addManager("Walter", "Black", FINANCE);

        System.out.println(service.printEmployees());
        System.out.println("=====");
    }

    private static void readEmployeesFromCsvAndPrint() throws CsvValidationException, IOException {
        var filePath = Path.of("src", "main", "resources", "employees.csv");
        var service = new SimpleEmployeesService(new EmployeesStorage());
        var csvService = new EmployeesCsvService(service);

        System.out.println("=== Adding employees from csv file");

        // 1. import employees from csv file
        csvService.importEmployeesFromCsv(filePath.toString());

        // 2. print employees
        System.out.println(service.printEmployees());
        System.out.println();
    }

}
