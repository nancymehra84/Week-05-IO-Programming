package hands_on_practice_problems.filter_json_data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JsonFilter {

    // Method to filter users older than a given age
    public static List<User> filterUsersByAge(List<User> users, int ageThreshold) {
        return users.stream()
                .filter(user -> user.getAge() > ageThreshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/java/hands_on_practice_problems/filter_json_data/user.json");
            List<User> users = objectMapper.readValue(file, new TypeReference<List<User>>() {});

            // Call method to filter users older than 25
            List<User> filteredUsers = filterUsersByAge(users, 25);

            System.out.println("Users older than 25:");
            filteredUsers.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// User class
class User {
    private String name;
    private int age;

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}


