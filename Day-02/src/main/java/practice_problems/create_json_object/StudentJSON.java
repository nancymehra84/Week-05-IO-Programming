package practice_problems.create_json_object;
import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJSON {
    public static String studentJSON(){
        JSONObject student=new JSONObject();
        student.put("Name","Nancy Mehra");
        student.put("Age",21);

        JSONArray subjects=new JSONArray();
        subjects.put("Maths");
        subjects.put("Science");
        subjects.put("English");

        student.put("Subjects",subjects);

        return student.toString(2);
    }
    public static void main(String[] args){
        System.out.println(StudentJSON.studentJSON());
    }
}
