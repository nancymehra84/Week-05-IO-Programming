package com.io_programing.advanced_problems.read_large_csv_files;

import java.io.*;

public class LargeCSVReader {

    public static void readLargeCSVInChunks(String filePath, int batchSize) {
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            int batchCount = 0;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                totalRecords++;
                batchCount++;

                if (batchCount == batchSize) {
                    System.out.println("Processed " + totalRecords + " records...");
                    batchCount = 0;
                }
            }

            System.out.println("Total records processed: " + totalRecords);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/io_programing/advanced_problems/LargeStudent.csv";
        int batchSize = 100;

        readLargeCSVInChunks(filePath, batchSize);
    }
}

