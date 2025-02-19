package com.io_programing.advanced_problems.csv_data_into_java_objects;

import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;
    int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                '}';
    }
}

public class CsvToStudentList {

    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    int marks = Integer.parseInt(data[3].trim());

                    students.add(new Student(id, name, age, marks));
                } else {
                    System.out.println("Invalid Row Format: " + line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/io_programing/advanced_problems/Student.csv";

        List<Student> students = readStudentsFromCSV(filePath);

        System.out.println("Student List:");
        students.forEach(System.out::println);
    }
}

