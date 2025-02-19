package hands_on_practice_problems.json_report_from_database_records;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;

public class GenerateJSONReportFromDatabaseRecords {
    public static void main(String[] args) {
        //Try block
        try {
            // Database records as a list
            List<Student> students = Arrays.asList(
                    new Student("Nancy", 25, "nancy@example.com"),
                    new Student("Muskan", 22, "muskan@example.com"),
                    new Student("Rishika", 28, "rishika@example.com")
            );

            // Converting list to JSON and write to file
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("src/main/java/hands_on_practice_problems/json_report_from_database_records/students_report.json"), students);

            System.out.println("JSON report generated successfully!");
        }
        //Catch block
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
