package hands_on_practice_problems.json_to_xml_format;

public class ConvertJSONToXML {
    public static void main(String[] args) {
        String json = "{\"name\":\"Nancy\", \"age\":22, \"city\":\"Bhopal\"}";
        //Try block
        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(json);
            String xml = org.json.XML.toString(jsonObject);
            System.out.println("XML Output:");
            System.out.println(xml);
        }
        //Catch block
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

