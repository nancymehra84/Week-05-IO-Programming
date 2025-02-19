package com.io_programing.basic_problems.read_print_csvfile;
import java.util.*;
import java.io.*;

public class ReadCsv {
    public static void readCsv(String fileName){
        try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
            String line;
            while((line=br.readLine())!=null){
                String[] columns=line.split(",");
                System.out.println("ID:"+columns[0]+",Name:"+columns[1]+",Age:"+columns[2]+",Marks:"+columns[3]);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        String fileName="src/main/java/com/io_programing/basic_problems/Student.csv";
        ReadCsv.readCsv(fileName);
    }
}
