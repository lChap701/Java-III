import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Formatter;
/**
 * Example writing JSON objects
 * http://code.google.com/p/json-simple/ to get jar
 * @author rryon
 * 8/2/2012
 *
 */
public class JSONExample2 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        JSONObject obj = new JSONObject();

        obj.put("name","Jane");
        obj.put("age",25);
        obj.put("gender","F");

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);
        String jsonText = out.toString();
        System.out.print(jsonText);

        Formatter output = new Formatter("student2.json");
        output.format("%s", jsonText);
        output.close();
    }
}