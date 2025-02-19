package practice_problems.merge_two_json_object;
import org.json.JSONObject;

public class MergeTwoJSON {
    public static void mergeTwoJSON(){
        JSONObject jsonObject1=new JSONObject();
        jsonObject1.put("name","Nancy Mehra");
        jsonObject1.put("age",21);

        JSONObject jsonObject2=new JSONObject();
        jsonObject2.put("email","mehranancy975@gmail.com");
        jsonObject2.put("city","Bhopal");

        for(String key:jsonObject2.keySet()){
            jsonObject1.put(key,jsonObject2.get(key));
        }
        System.out.println(jsonObject1.toString(4));
    }
    public static void main(String[]args){
        MergeTwoJSON.mergeTwoJSON();
    }
}
