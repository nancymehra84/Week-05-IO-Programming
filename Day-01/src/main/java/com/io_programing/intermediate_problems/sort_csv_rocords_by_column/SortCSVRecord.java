package com.io_programing.intermediate_problems.sort_csv_rocords_by_column;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + department + ") " + salary;
    }
}

public class SortCSVRecord{

    public static List<Employee> readEmployeesFromCSV(String filePath) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length >= 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String department = data[2].trim();
                    double salary = Double.parseDouble(data[3].trim());

                    employees.add(new Employee(id, name, department, salary));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public static List<Employee> getTopPaidEmployees(List<Employee> employees, int topN) {
        return employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                .limit(topN)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/io_programing/intermediate_problems/Employee.csv";

        List<Employee> employees = readEmployeesFromCSV(filePath);

        List<Employee> topPaidEmployees = getTopPaidEmployees(employees, 5);

        System.out.println("Top 5 Highest-Paid Employees:");
        topPaidEmployees.forEach(System.out::println);
    }
}


