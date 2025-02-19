package com.io_programing.basic_problems.read_count_rows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRowsCSV {
    public static void countRowsCSV(String filePath){
        int Count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                Count++;
            }
            System.out.println("Total number of records: " + Count);
        } catch (IOException e) {
            System.out.println("Error reading the file");
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/io_programing/basic_problems/Employee.csv";
        CountRowsCSV.countRowsCSV(filePath);
    }
}



