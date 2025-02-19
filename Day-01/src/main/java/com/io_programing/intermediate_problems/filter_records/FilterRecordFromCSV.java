package com.io_programing.intermediate_problems.filter_records;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecordFromCSV {
    public static void filterRecordFromCSV(String filePath){

        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line;
            int index=0;
            while((line= br.readLine())!=null){
                String[] column=line.split(",");

                if(index==0){
                    System.out.println(column[0]+","+column[1]+","+column[2]+","+column[3]);
                    index++;
                }else{
                    int marks=Integer.parseInt(column[3].trim());
                    if(marks>=80){
                        System.out.println(column[0]+","+column[1]+","+column[2]+","+column[3]);
                    }
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        String filePath="src/main/java/com/io_programing/intermediate_problems/Student.csv";
        FilterRecordFromCSV.filterRecordFromCSV(filePath);
    }
}
