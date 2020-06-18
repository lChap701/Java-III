import com.google.gson.*;
import java.io.IOException;
import java.util.*;

/**
 * Created by Lucas Chapman 6/16/2020.
 * This class is used to write a JSON file using hardcoded data.
 */
public class WritingJSONFiles {
    public static void main(String[] args) {
        Gson device = new GsonBuilder().setPrettyPrinting().create();
        List<Laptop> laptops = laptops();
        writeFile(device, laptops);
    }

    /**
     * Creates Laptop objects and stores each object in a list
     * @return returns the objects stored in the list
     */
    private static List<Laptop> laptops() {
        List<Laptop> lapList = new ArrayList<>();

        // 1st Laptop
        Laptop laptop1 = new Laptop();
        laptop1.setId(1010);
        laptop1.setBrand("Microsoft");
        laptop1.setName("Business Surface Laptop 3");
        laptop1.setProductNumber("10JCR6UKR5");
        laptop1.setSerial("LKS67BX1");
        laptop1.setOs("Windows 10");
        laptop1.setRam(999.9);
        laptop1.setCpu("Intel Core i9-999GHz");
        laptop1.setStorage(999.9);
        laptop1.setPrice(999999.99);
        lapList.add(laptop1);

        // 2nd Laptop
        Laptop laptop2 = new Laptop();
        laptop2.setId(1011);
        laptop2.setBrand("Apple");
        laptop2.setName("MacBook Air Pro");
        laptop2.setProductNumber("15MNW66KRS");
        laptop2.setSerial("3QOM1AAW");
        laptop2.setOs("macOS");
        laptop2.setRam(50.5);
        laptop2.setCpu("Intel Core i9-75GHz");
        laptop2.setStorage(246.1);
        laptop2.setPrice(599.99);
        lapList.add(laptop2);
        return lapList;
    }

    /**
     * Prints out the data created in this class and writes a JSON file
     * @param device passes the Gson object that will contain all the data in the JSON file
     * @param laptops passes the List that contains all the Laptop objects
     */
    private static void writeFile(Gson device, List<Laptop> laptops) {
        try {
            // Converts the data to a String
            String jsonText = "{\"device\":\"laptop\",";
            jsonText += "\n \"laptops\":";
            jsonText += device.toJson(laptops);
            jsonText += "}";
            System.out.println(jsonText);   // displayed to console for testing

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