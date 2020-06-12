import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Example of program using JSON.simple library 
 * http://code.google.com/p/json-simple/ to get jar
 * @author rryon
 * 8/2/2012
 *
 */
public class JSONExampleRevised {

    /**
     * @param args
     */
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("Students.json"));
            JSONObject jsonObject = (JSONObject) obj;

            System.out.println("Parsing College");
            String college = (String) jsonObject.get("college");

            System.out.println("College: " + college);

            JSONArray studentlist =  (JSONArray) jsonObject.get("students");

            System.out.println("Parsing Array");

            for(Object s: studentlist){

                // Split up to print individual values
                System.out.println();
                JSONObject studentObject = (JSONObject) s;
                String name = (String) studentObject.get("name");
                System.out.println("Name: " + name);

                Long age = (Long) studentObject.get("age");
                System.out.println( "Age: "+ age);

                // String to char conversion
                char gender =  ((String) studentObject.get("gender")).charAt(0);
                System.out.println("Gender: " + gender);

                //determine if student has a major, and if it's one or multiple
                if(studentObject.get("major") != null) {
                    if(studentObject.get("major") instanceof JSONArray) {
                        JSONArray majorList =  (JSONArray) studentObject.get("major");
                        System.out.println("Majors: ");
                        for(Object m: majorList){
                            System.out.println("\t" + m);
                        }
                    }
                    else {
                        String major = (String) studentObject.get("major");
                        System.out.println("Major: " + major);
                    }
                }

                //determine if student has a graduation year
                if(studentObject.get("graduation") != null) {
                    String gradYear = (String) studentObject.get("graduation");
                    System.out.println("Graduation: " + gradYear);
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}