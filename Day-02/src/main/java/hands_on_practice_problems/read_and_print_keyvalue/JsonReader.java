package hands_on_practice_problems.read_and_print_keyvalue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class JsonReader {

    public static void printJsonKeysAndValues(JsonNode node, String parentKey) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJsonKeysAndValues(field.getValue(), parentKey + field.getKey() + ".");
            }
        } else if (node.isArray()) {
            int index = 0;
            for (JsonNode element : node) {
                printJsonKeysAndValues(element, parentKey + "[" + index + "].");
                index++;
            }
        } else {
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " : " + node.asText());
        }
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/java/hands_on_practice_problems/read_and_print_keyvalue/data.json");  // Change filename if needed
            JsonNode rootNode = objectMapper.readTree(file);

            printJsonKeysAndValues(rootNode, "");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

