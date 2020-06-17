import org.json.simple.*;
import java.io.*;
import java.util.Formatter;

/**
 * Created by Lucas Chapman 6/16/2020.
 * This class is used to write a JSON file using hardcoded data.
 */
public class WritingJSONFiles {
    public static void main(String[] args) {
        JSONObject device = createJSONObject();
        JSONArray laptops = createJSONArray();
        device.put("laptops", laptops);
        writeFile(device);
    }

    /**
     * Creates the JSONObject that will contain all of the data in the JSON file
     * @return returns the data stored in the JSONObject
     */
    private static JSONObject createJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("device","laptop");
        return jsonObject;
    }

    /**
     * Creates the JSONArray that will contain all the Laptop objects in the JSON file
     * @return returns the data stored in the JSONArray
     */
    private static JSONArray createJSONArray() {
        JSONArray jsonArray = new JSONArray();

        // 1st Laptop
        JSONObject laptop1 = new JSONObject();
        laptop1.put("id", 1010);
        laptop1.put("name", "Business Surface Laptop 3");
        laptop1.put("productNumber", "10JCR6UKR5");
        laptop1.put("serial", "LKS67BX1");
        laptop1.put("os", "Windows 10");
        laptop1.put("ram", 999.9);
        laptop1.put("cpu", "Intel Core i9-999GHz");
        laptop1.put("storage", 999.9);
        laptop1.put("price", 999999.99);
        jsonArray.add(laptop1);

        //2nd Laptop
        JSONObject laptop2 = new JSONObject();
        laptop2.put("id", 1011);
        laptop2.put("name", "MacBook Air Pro");
        laptop2.put("productNumber", "15MNW66KRS");
        laptop2.put("serial", "3QOM1AAW");
        laptop2.put("os", "macOS");
        laptop2.put("ram", 50.5);
        laptop2.put("cpu", "Intel Core i9-75GHz");
        laptop2.put("storage", 246.1);
        laptop2.put("price", 599.99);
        jsonArray.add(laptop2);
        return jsonArray;
    }

    /**
     * Prints out the data created in this class and writes a JSON file
     * @param device passes the JSONObject that will contain all the data in the JSON file
     */
    private static void writeFile(JSONObject device) {
        try {
            // Converts all the data in the JSONObject to a String
            StringWriter data = new StringWriter();
            device.writeJSONString(data);
            String jsonText = data.toString();
            System.out.println(jsonText);   // displays all the data to the console for testing

            // Writes the JSON file with the data created in this class
            Formatter file = new Formatter("laptops2.json");
            file.format("%s", jsonText);
            file.close();
        } catch (IOException e) {
            System.out.println("Error, unable to write the laptops2.json file");
            System.exit(1);
        }
    }
}