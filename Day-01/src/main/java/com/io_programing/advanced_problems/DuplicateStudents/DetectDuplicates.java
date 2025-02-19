package com.io_programing.advanced_problems.DuplicateStudents;

import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void findDuplicates(String fileName) {
        Map<String, String> uniqueRecords = new HashMap<>();
        Set<String> duplicateRecords = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");

                String id = columns[0].trim();

                if (uniqueRecords.containsKey(id)) {
                    duplicateRecords.add(line);
                } else {
                    uniqueRecords.put(id, line);
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("\nDuplicate Records Found:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "src/main/java/com/io_programing/advanced_problems/DuplicateStudent.csv";
        findDuplicates(fileName);
    }
}

