import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Lucas Chapman 6/11/2020.
 * This class is created to process JSON data.
 */
public class JSONControlClass {
    public static void main(String[] args) {
        try {
            JSONObject jsonObject = init();
            process(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
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
        Object obj = parser.parse(new FileReader("Students.json"));
        return (JSONObject) obj;
    }

    /**
     * Processes JSON data to be used to create objects
     * @param jsonObject passes the values in the JSONObject
     */
    private static void process(JSONObject jsonObject) {
        college(jsonObject);

        System.out.println("\nParsing Array");
        JSONArray studentList = (JSONArray) jsonObject.get("students");

        for (Object s : studentList) {
            persons(s);
            students(s);
            graduate(s);
        }
        System.out.println("\nParsing finished");
    }

    /**
     * Prints out the name of the college
     * @param jsonObject passes the values in the JSONObject
     */
    private static void college(JSONObject jsonObject) {
        System.out.println("Parsing College");
        String college = (String) jsonObject.get("college");
        System.out.println("College: " + college);
    }

    /**
     * Gets enough values to create Person objects
     * @param s passes the values stored in the object
     */
    private static void persons(Object s) {
        JSONObject persons = (JSONObject) s;

        // Checks if a Person object should be created
        if (!persons.containsKey("major") && !persons.containsKey("graduation")) {
            Person person = new Person();

            person.setName((String) persons.get("name"));
            person.setAge(Math.toIntExact((Long) persons.get("age")));
            person.setGender(((String) persons.get("gender")).charAt(0));
            System.out.println("\nPersons:\n" + person.toString());
        }
    }

    /**
     * Gets enough values to create Student objects
     * @param s passes the values stored in the object
     */
    private static void students(Object s) {
        JSONObject students = (JSONObject) s;

        // Checks if a Student object should be created
        if (students.get("major") != null && !students.containsKey("graduation")) {
            Student student = new Student();

            student.setName((String) students.get("name"));
            student.setAge(Math.toIntExact((Long) students.get("age")));
            student.setGender(((String) students.get("gender")).charAt(0));

            // If a student has more than one major
            if (students.get("major") instanceof JSONArray) {
                JSONArray majorList = (JSONArray) students.get("major");
                // Gets the first and second values in the majorList
                student.setMajor(majorList.get(0).toString().concat(", " + majorList.get(1).toString()));
            } else {
                student.setMajor((String) students.get("major"));
            }
            System.out.println("\nStudents:\n" + student.toString());
        }
    }

    /**
     * Gets enough values to create Graduate objects
     * @param s passes the values stored in the object
     */
    private static void graduate(Object s) {
        JSONObject grad = (JSONObject) s;

        // Checks if a Graduate object should be created
        if (grad.get("graduation") != null) {
            Graduate graduate = new Graduate();

            graduate.setName((String) grad.get("name"));
            graduate.setAge(Math.toIntExact((Long) grad.get("age")));
            graduate.setGender(((String) grad.get("gender")).charAt(0));
            // Gets one major since graduate doesn't contain more than one major
            graduate.setMajor((String)  grad.get("major"));
            graduate.setGraduationYear((String) grad.get("graduation"));
            System.out.println("\nGraduate:\n" + graduate.toString());
        }
    }
}