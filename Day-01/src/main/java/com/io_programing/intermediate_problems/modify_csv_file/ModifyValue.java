package com.io_programing.intermediate_problems.modify_csv_file;

import java.io.*;

public class ModifyValue {
    public static void modifyValue(String filePath,String Modified){
        try(BufferedReader br=new BufferedReader(new FileReader(filePath));
            BufferedWriter bw=new BufferedWriter(new FileWriter(Modified))){
            String line;
            String Department="IT";
            while ((line=br.readLine())!=null){
                String[] columns=line.split(",");
                String department=columns[2].trim();

                if(Department.equals(department)){
                    int updateSalary=(int)(Integer.parseInt(columns[3].trim())*1.1);
                    bw.write(columns[0]+","+columns[1]+","+columns[2]+","+updateSalary);
                }else{
                    bw.write(columns[0]+","+columns[1]+","+columns[2]+","+columns[3]);
                }
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        String filepath="src/main/java/com/io_programing/intermediate_problems/Employee.csv";
        String newFilePath="src/main/java/com/io_programing/intermediate_problems/Modified";
        ModifyValue.modifyValue(filepath,newFilePath);
    }
}
