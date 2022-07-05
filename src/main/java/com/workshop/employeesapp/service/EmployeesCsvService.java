package com.workshop.employeesapp.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.workshop.employeesapp.model.Department;
import com.workshop.employeesapp.model.Employee;
import com.workshop.employeesapp.model.Manager;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeesCsvService {

    public List<Employee> readEmployeesCsv(String path) throws IOException, CsvValidationException {
        var employeesLines = readLines(path);
        return employeesLines.stream()
            .map(this::readEmployeeFromLine)
            .toList();
    }

    private Employee readEmployeeFromLine(List<String> line) {
        var firstname = line.get(0);
        var lastname = line.get(1);
        var department = Department.valueOf(Department.class, line.get(2));
        var isManager = line.size() == 4 && line.get(3).equals("Manager");

        if (isManager) {
            return new Manager(firstname, lastname, department);
        } else {
            return new Employee(firstname, lastname, department);
        }
    }

    private List<List<String>> readLines(String path) throws IOException, CsvValidationException {
        List<List<String>> lines = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(path));) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                lines.add(Arrays.asList(values));
            }
        }
        return lines;
    }

}
