import org.json.simple.*;
import java.io.*;
import java.util.Formatter;

/**
 * Created by Lucas Chapman 6/16/2020.
 * This class is created to write a JSON data and write it to a file called students2.json.
 */
public class JSONExample4 {
    public static void main(String[] args) {
        JSONObject college = createJSONObject();
        JSONArray students = createJSONArray();
        college.put("students", students);
        writeFile(college);
    }

    /**
     * Creates the JSONObject that will contain all of the data in the JSON file
     * @return returns the values stored in the JSONObject
     */
    private static JSONObject createJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("college","IHCC");
        return jsonObject;
    }

    /**
     * Creates the JSONArray that will contain all of the student objects
     * @return returns the values stored in the JSONArray
     */
    private static JSONArray createJSONArray() {
        JSONArray jsonArray = new JSONArray();

        // 1st student
        JSONObject student1 = new JSONObject();
        student1.put("name", "Betty");
        student1.put("age", 18);
        student1.put("gender", "F");
        jsonArray.add(student1);

        // 2nd student
        JSONObject student2 = new JSONObject();
        student2.put("name", "Bob");
        student2.put("age", 22);
        student2.put("gender", "M");
        JSONArray majors = new JSONArray();
        majors.add("Software Development");
        majors.add("Robotics");
        student2.put("majors", majors);
        jsonArray.add(student2);

        // 3rd student
        JSONObject student3 = new JSONObject();
        student3.put("name", "Jane");
        student3.put("age", 27);
        student3.put("gender", "F");
        student3.put("major", "Math");
        student3.put("graduation", "2017");
        jsonArray.add(student3);
        return jsonArray;
    }

    /**
     * Prints out the JSON data to the console and writes it to a file.
     * @param college passes the JSONObject that will contain all the data in the JSON file
     */
    private static void writeFile(JSONObject college) {
        try {
            // Turns all the data in the object to a String
            StringWriter data = new StringWriter();
            college.writeJSONString(data);
            String jsonText = data.toString();
            System.out.println(jsonText);   // to display data to the console for testing

            // Writes the String data to a file
            Formatter file = new Formatter("students2.json");
            file.format("%s", jsonText);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}