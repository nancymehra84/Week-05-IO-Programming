package com.io_programing.intermediate_problems.search_records;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecordCSV {
    public static void searchRecordCSV(String filePath){

        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line;
            String Name="Nancy";
            while((line= br.readLine())!=null){
                String[] column=line.split(",");
                String Name2=column[1].trim();

                if(Name.equals(Name2)){
                    System.out.println(column[0]+","+column[1]+","+column[2]+","+column[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        String filePath="src/main/java/com/io_programing/intermediate_problems/Student.csv";
        SearchRecordCSV.searchRecordCSV(filePath);
    }
}
