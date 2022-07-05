package com.workshop.employeesapp.service.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.workshop.employeesapp.model.Department;
import com.workshop.employeesapp.model.Employee;
import com.workshop.employeesapp.model.Manager;
import com.workshop.employeesapp.service.EmployeeService;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeesCsvService {

    private EmployeeService employeeService;

    public EmployeesCsvService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public boolean importEmployeesFromCsv(String path) throws CsvValidationException, IOException {
        var employeesList = readEmployeesFromCsv(path);

        employeesList
            .forEach(empDto -> {
                if (empDto.isManager) {
                    employeeService.addManager(empDto.firstname, empDto.lastname, empDto.department);
                } else {
                    employeeService.addEmployee(empDto.firstname, empDto.lastname, empDto.department);
                }
            });

        return true;
    }

    private List<EmployeeLineDto> readEmployeesFromCsv(String path) throws IOException, CsvValidationException {
        var employeesLines = readLines(path);
        return employeesLines.stream()
            .map(this::readEmployeeFromLine)
            .toList();
    }

    private EmployeeLineDto readEmployeeFromLine(List<String> line) {
        var firstname = line.get(0);
        var lastname = line.get(1);
        var department = Department.findByLabel(line.get(2));
        var isManager = line.size() == 4 && line.get(3).equals("Manager");

        return new EmployeeLineDto(firstname, lastname, department, isManager);
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
