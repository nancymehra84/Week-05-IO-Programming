package com.io_programing.advanced_problems.merge_csv_files;

import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;
    int marks;
    String grade;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setMarksAndGrade(int marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeCSVFiles {

    public static void main(String[] args) {
        String file1 = "src/main/java/com/io_programing/advanced_problems/students1.csv";
        String file2 = "src/main/java/com/io_programing/advanced_problems/students2.csv";
        String outputFile = "src/main/java/com/io_programing/advanced_problems/merged_students.csv";

        mergeCSVFiles(file1, file2, outputFile);
    }

    public static void mergeCSVFiles(String file1, String file2, String outputFile) {
        Map<Integer, Student> studentMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) { // Skip header row
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 3) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());

                    studentMap.put(id, new Student(id, name, age));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 3) {
                    int id = Integer.parseInt(data[0].trim());
                    int marks = Integer.parseInt(data[1].trim());
                    String grade = data[2].trim();

                    if (studentMap.containsKey(id)) {
                        studentMap.get(id).setMarksAndGrade(marks, grade);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            for (Student student : studentMap.values()) {
                bw.write(student.toString());
                bw.newLine();
            }

            System.out.println("Merged data written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

