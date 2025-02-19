package practice_problems.read_json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;

public class ReadJSON {
    public static void readJSON(){
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            JsonNode rootNode=objectMapper.readTree(new File("src/Data.json"));

            String name=rootNode.path("name").asText();
            String email=rootNode.path("email").asText();

            System.out.println("Name:"+name);
            System.out.println("Email:"+email);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        ReadJSON.readJSON();
    }
}
