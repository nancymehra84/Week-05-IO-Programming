package practice_problems.validate_json_structure_using_jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONValidation {

    public static boolean isValidJSON(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode = objectMapper.readTree(jsonString);
            return true;
        } catch (JsonProcessingException e) {

            System.err.println("Invalid JSON: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String validJson = "{\"name\": \"Nancy Mehra\", \"email\": \"mehranancy975@gmail.com\"}";
        String invalidJson = "{\"name\": \"Muskan Gupta\", \"email\": }";

        System.out.println("Valid JSON? " + isValidJSON(validJson));
        System.out.println("Valid JSON? " + isValidJSON(invalidJson));
    }
}

