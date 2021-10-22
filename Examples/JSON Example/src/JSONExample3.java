import org.json.simple.JSONArray;

import java.io.IOException;
import java.io.StringWriter;
/**
 * Example of JSON program creating array
 * http://code.google.com/p/json-simple/ to get jar
 * @author rryon
 * 8/2/2012
 *
 */
public class JSONExample3 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        JSONArray list = new JSONArray();
        list.add("red");
        list.add("green");
        list.add("blue");

        StringWriter out = new StringWriter();
        list.writeJSONString(out);
        System.out.print(out);
    }
}