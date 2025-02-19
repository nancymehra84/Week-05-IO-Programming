package com.io_programing.basic_problems.write_data_csvfile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataCSV {
    public static void writeDataCSV(String filePath){
        String[] employee={"ID,Name,Department,Salary",
                "101,Nancy Mehra,HR,50000",
                "102,Muskan Gupta,IT,65000",
                "103,Rishika Bisht,Finance,70000",
                "104,Shrishti Mishra,Marketing,55000",
                "105,Pratham Raj,Sales,60000"};
        try (FileWriter writer=new FileWriter(filePath)){
            for(String line:employee){
                writer.write(line + "\n");
            }
            System.out.println("CSV file created successfully!");
        }catch (IOException e){
            System.out.println("Error writing in file");
        }
    }
    public static void main(String[] args){
        String fileName="src/main/java/com/io_programing/basic_problems/Employee.csv";
        WriteDataCSV.writeDataCSV(fileName);
    }
}
