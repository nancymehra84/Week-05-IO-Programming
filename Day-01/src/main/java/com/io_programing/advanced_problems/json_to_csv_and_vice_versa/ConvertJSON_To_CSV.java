package com.io_programing.advanced_problems.json_to_csv_and_vice_versa;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.*;

public class ConvertJSON_To_CSV {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            JsonNode rootNode = objectMapper.readTree(new File(jsonFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));

            if (rootNode.isArray()) {
                ArrayNode arrayNode = (ArrayNode) rootNode;

                writer.write("ID,Name,Age,Marks");
                writer.newLine();

                for (JsonNode node : arrayNode) {
                    writer.write(node.get("ID").asText() + "," +
                            node.get("Name").asText() + "," +
                            node.get("Age").asText() + "," +
                            node.get("Marks").asText());
                    writer.newLine();
                }
            }

            writer.close();
            System.out.println("JSON converted to CSV successfully: " + csvFile);

        } catch (IOException e) {
            System.err.println("Error processing JSON file: " + e.getMessage());
        }
    }

    public static void csvToJson(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            ArrayNode jsonArray = objectMapper.createArrayNode();
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");

                ObjectNode student = objectMapper.createObjectNode();
                student.put("ID", columns[0].trim());
                student.put("Name", columns[1].trim());
                student.put("Age", columns[2].trim());
                student.put("Marks", columns[3].trim());
                jsonArray.add(student);
            }

            objectMapper.writeValue(new File(jsonFile), jsonArray);
            System.out.println("CSV converted to JSON successfully: " + jsonFile);

        } catch (IOException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String jsonInput = "src/main/java/com/ioprogramming/students.json";
        String csvOutput = "src/main/java/com/ioprogramming/students.csv";
        String jsonOutput = "src/main/java/com/ioprogramming/studentsConverted.json";

        jsonToCsv(jsonInput, csvOutput);
        csvToJson(csvOutput, jsonOutput);
    }
}
