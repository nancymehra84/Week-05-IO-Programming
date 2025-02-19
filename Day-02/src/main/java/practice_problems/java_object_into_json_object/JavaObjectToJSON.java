package practice_problems.java_object_into_json_object;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Car{
    String carName;
    String Brand;
    int price;

    public Car(String carName,String Brand,int price){
        this.carName=carName;
        this.Brand=Brand;
        this.price=price;
    }

    public String getCarName() {
        return carName;
    }

    public String getBrand() {
        return Brand;
    }

    public int getPrice() {
        return price;
    }
}
public class JavaObjectToJSON{
    public static void javaObjectToJSON(){
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            Car car=new Car("Supra","Toyota",12000000);

            String jsonString=objectMapper.writeValueAsString(car);
            System.out.println(jsonString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        JavaObjectToJSON.javaObjectToJSON();
    }
}
