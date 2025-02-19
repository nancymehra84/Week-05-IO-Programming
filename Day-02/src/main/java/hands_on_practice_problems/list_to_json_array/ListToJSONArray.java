package hands_on_practice_problems.list_to_json_array;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters (Jackson needs them to serialize)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ListToJSONArray {

    public static <T> String listToJSONArray(List<T> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Nancy", 25),
                new Person("Muskan", 30)
        );

        String jsonArray = listToJSONArray(people);
        System.out.println(jsonArray);
    }
}



