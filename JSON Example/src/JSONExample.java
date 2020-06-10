import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;
/**
 * Example of program using JSON.simple library 
 * http://code.google.com/p/json-simple/ to get jar
 * @author rryon
 * 8/2/2012
 *
 */
public class JSONExample {

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

			for(Object s: studentlist)
			{
			
			// Split up to print individual values 
				JSONObject studentObject = (JSONObject) s;
				String name = (String) studentObject.get("name");
				System.out.println("Name: " + name);
		 
				Long age = (Long) studentObject.get("age");
				System.out.println( "Age: "+ age);
		 
				// String to char conversion
				char gender =  ((String) studentObject.get("gender")).charAt(0);
				System.out.println("Gender: " + gender);
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