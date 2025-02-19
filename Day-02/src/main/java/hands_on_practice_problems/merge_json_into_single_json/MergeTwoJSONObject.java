package hands_on_practice_problems.merge_json_into_single_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public class MergeTwoJSONObject {
    public static void main(String[] args) {
        //Student 1 data
        JSONObject student1=new JSONObject();
        student1.put("name","Rishika Bisht");
        student1.put("age",21);

        //Student 2 data
        JSONObject student2=new JSONObject();
        student2.put("name","Nancy Mehra");
        student2.put("age",22);

        JSONObject mergedStudent=new JSONObject(student1);
        mergedStudent.put("Student1",student1);
        mergedStudent.put("Student2",student2);
        System.out.println(mergedStudent.toString(4));
    }
}

