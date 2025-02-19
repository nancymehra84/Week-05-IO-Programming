package com.io_programing.advanced_problems.validate_data_before_processing;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Employee {
    int id;
    String name;
    String email;
    String phone;
    String department;
    double salary;

    public Employee(int id, String name, String email, String phone, String department, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + department + ") - $" + salary + " - " + email + " - " + phone;
    }
}

public class ValidateData {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    private static final String PHONE_REGEX = "^[0-9]{10}$";
    private static final Pattern phonePattern = Pattern.compile(PHONE_REGEX);

    public static void validateCSVData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length >= 6) {
                    String email = data[2].trim();
                    String phone = data[3].trim();

                    boolean isValidEmail = emailPattern.matcher(email).matches();
                    boolean isValidPhone = phonePattern.matcher(phone).matches();

                    if (!isValidEmail) {
                        System.out.println("Invalid Email: " + line);
                    }
                    if (!isValidPhone) {
                        System.out.println("Invalid Phone Number: " + line);
                    }
                } else {
                    System.out.println("Invalid Row Format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/io_programing/advanced_problems/employee.csv";

        validateCSVData(filePath);
    }
}
