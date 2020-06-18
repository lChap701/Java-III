import com.google.gson.*;
import java.io.IOException;
import java.util.*;

/**
 * Created by Lucas Chapman 6/16/2020.
 * This class is created to write a JSON data and write it to a file called students2.json.
 */
public class JSONExample4 {
    public static void main(String[] args) {
        Gson college = new GsonBuilder().setPrettyPrinting().create();
        Person person = person();
        Student students = students();
        Graduate graduates = graduate();
        List<Object> studentsArray = studentsArray(person, students, graduates);
        writeFile(college, studentsArray);
    }

    private static List<Object> studentsArray(Person person, Student students, Graduate graduates) {
        List<Object> studentsArray = new ArrayList<>();
        studentsArray.add(person);
        studentsArray.add(students);
        studentsArray.add(graduates);
        return studentsArray;
    }

    private static Person person() {
        Person per = new Person();
        per.setName("Betty");
        per.setAge(18);
        per.setGender('F');
        return per;
    }

    /**
     * Creates the array that will contain all of the student objects in the JSON file
     * @return returns the values stored in the array
     */
    private static Student students() {
        Student student = new Student();
        student.setName("Bob");
        student.setAge(22);
        student.setGender('M');
        List<String> majors = new ArrayList<>();
        majors.add("\"Software Development\"");
        majors.add("\"Robotics\"");
        // Formats the major data
        student.setMajor(majors.toString().substring(2, 23).concat(", " + majors.toString().substring(25, 34)));
        return student;
    }

    private static Graduate graduate() {
        Graduate grads = new Graduate();
        grads.setName("Jane");
        grads.setAge(27);
        grads.setGender('F');
        grads.setMajor("Math");
        grads.setGraduationYear("2017");
        return grads;
    }

    /**
     * Prints out the JSON data to the console and writes it to a file.
     * @param college passes the JSONObject that will contain all the data in the JSON file
     * @param studentsArray
     */
    private static void writeFile(Gson college, List<Object> studentsArray) {
        try {
            // Turns all the data to a String
            String jsonText = "{\"college\":\"IHCC\",";
            jsonText += "\n \"students\":";
            // Provides extra formatting for some data
            jsonText += college.toJson(studentsArray).replace("GraduationYear", "graduation");
            jsonText = jsonText.replaceFirst("major.*: ", "major\": [");
            jsonText = jsonText.replaceAll("ment\\\\", "ment");
            jsonText = jsonText.replaceAll(", \\\\", ", ");
            jsonText = jsonText.replaceAll("tics.*,", "tics\"],");
            jsonText += "}";
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