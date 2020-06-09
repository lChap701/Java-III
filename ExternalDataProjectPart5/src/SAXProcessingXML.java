import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

/**
 * Created by Lucas Chapman 6/2/2020.
 * This class is created to parse XML data with SAX.
 */
public class SAXProcessingXML extends DefaultHandler {
    /*
     * Global Variables
     */
    static String curTagName;
    static Laptop laptop;

    public static void main(String[] args) {
        SAXProcessingXML processingXML = new SAXProcessingXML(); // starts the SAX processing
    }

    /**
     * Default Constructor
     */
    public SAXProcessingXML() {
        try {
            System.out.println("Parsing the XML file...\n");
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(this);
            xr.parse(new InputSource(new FileReader("laptops.xml")));
            System.out.println("Parsing finished");
        } catch (Exception e) {
            System.out.println("Error, unable to parse the XML file");
            System.exit(1);
        }
    }

    /**
     * Creates new Laptop objects when the current tag is a starting laptop tag
     */
    public void startElement(String namespaceURI, String localTag, String qName, Attributes attr) {
        curTagName = localTag;
        if(curTagName.equals("laptop")) {
            laptop = new Laptop();
        }
    }

    /**
     * Checks if the value contained in tags should be used to create Laptop objects
     */
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        boolean isEndTag = value.matches(".*\\n\\t.*"); // the value of closing tags

        // Checks current tags and their values
        if (!isEndTag) {    // if the current tag is not a closing tag
            switch (curTagName) {
                case "id" -> laptop.setId(Integer.parseInt(value));
                case "brand" -> laptop.setBrand(value);
                case "name" -> laptop.setName(value);
                case "productNumber" -> laptop.setProductNumber(value);
                case "serial" -> laptop.setSerial(value);
                case "os" -> laptop.setOs(value);
                case "ram" -> laptop.setRam(Double.parseDouble(value));
                case "cpu" -> laptop.setCpu(value);
                case "storage" -> laptop.setStorage(Double.parseDouble(value));
                case "price" -> laptop.setPrice(Double.parseDouble(value));
            }
        }
    }

    /**
     * Displays the data stored in laptop objects when the current tag is a closing laptop tag
     */
    public void endElement(String namespaceURI, String localTag, String qName) {
        if (localTag.equals("laptop")) {
            System.out.println(laptop.toString());
        }
        curTagName = "";    // clears contents in curTagName
    }
}