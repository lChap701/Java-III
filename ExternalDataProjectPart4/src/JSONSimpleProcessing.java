import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Lucas Chapman 6/11/2020.
 * This class is designed to parse JSON files and create Laptop objects.
 */
public class JSONSimpleProcessing {
    public static void main(String[] args) {
        try {
            JSONObject jDevice = init();    // jDevice represents the device object in the JSON file
            process(jDevice);
            System.out.println("\nParsing finished");
        } catch (Exception e) {
            System.out.println("Error, unable to parse the JSON file");
            System.exit(1);
        }
    }

    /**
     * Parses through the JSON File
     * @return returns the parsed data and stores it in a JSONObject
     * @throws IOException      used to be able to parse the JSON file
     * @throws ParseException   used to be able to parse the JSON file
     */
    private static JSONObject init() throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        System.out.println("Parsing laptops.json...");
        Object obj = parser.parse(new FileReader("laptops.json"));
        return (JSONObject) obj;
    }

    /**
     * Processes JSON data to be used to create Laptop objects
     * @param jDevice passes the values in the JSONObject
     */
    private static void process(JSONObject jDevice) {
        device(jDevice);

        // Gets all objects in the laptops array found in laptops.json
        JSONArray arrLaptops = (JSONArray) jDevice.get("laptops");

        for (Object l : arrLaptops) {
            laptops(l);
        }
    }

    /**
     * Used to print the name of the device JSON object in laptops.json
     * @param jDevice passes the values in the JSONObject
     */
    private static void device(JSONObject jDevice) {
        String device = jDevice.get("device").toString();
        String dashes = "-";
        System.out.println("\nDevice: " + device + "\n" + dashes.repeat(50));
    }

    /**
     * Gets enough values to create Laptop objects and prints each object out to the console
     * @param l passes the values in the object
     */
    private static void laptops(Object l) {
        JSONObject jLaptop = (JSONObject) l;

        int id = Math.toIntExact((Long) jLaptop.get("id"));
        String brand = jLaptop.get("brand").toString();
        String name = jLaptop.get("name").toString();
        String prodNum = jLaptop.get("productNumber").toString();
        String serial = jLaptop.get("serial").toString();
        String os = jLaptop.get("os").toString();
        double ram = (Double) jLaptop.get("ram");
        String cpu = jLaptop.get("cpu").toString();
        double storage = (Double) jLaptop.get("storage");
        double price = (Double) jLaptop.get("price");

        Laptop laptop = new Laptop(id, brand, name, prodNum, serial, os, ram, cpu, storage, price);
        System.out.println(laptop.toString());
    }
}