package practice_problems.parse_json_and_filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
public class JsonFilter {

    public static String filterJsonByAge(String jsonArray) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<Person> people = objectMapper.readValue(jsonArray, new TypeReference<List<Person>>() {});

            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());

            return objectMapper.writeValueAsString(filteredPeople);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    public static void main(String[] args) {
        String jsonInput = "[{\"name\":\"Nancy\",\"age\":21}, {\"name\":\"Rishika\",\"age\":22}, {\"name\":\"Muskan\",\"age\":30}]";

        String filteredJson = filterJsonByAge(jsonInput);
        System.out.println(filteredJson);
    }
}



