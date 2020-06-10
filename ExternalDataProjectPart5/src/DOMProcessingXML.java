import javax.xml.parsers.*;
import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * Created by Lucas Chapman 6/8/2020.
 * This class is used to parse the XML file using DOM processing.
 */
public class DOMProcessingXML {
    public static void main(String[] args) {
        try {
            Element root = init();
            dataProcessing(root);
            System.out.println("Parsing finished");
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println("Error, unable to parse the XML file");
            System.exit(1);
        }
    }

    /**
     * Sets up everything for DOM processing and then parses the file
     * @return returns the value of the Element object
     * @throws IOException                  used to be able parse the XML file
     * @throws SAXException                 used to be able to parse the XML file
     * @throws ParserConfigurationException used to be to create a DocumentBuilder object
     */
    private static Element init() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File f = new File("laptops.xml");
        Document doc = builder.parse(f);
        System.out.println("Parsing the " + f + " file...\n");
        return doc.getDocumentElement();
    }

    /**
     * Process the data found in tags and calls the findData()
     * @param root passes the Element object
     */
    private static void dataProcessing(Element root) {
        NodeList rootChildNodes = root.getChildNodes();
        Laptop laptop = new Laptop();

        for (int i = 0; i < rootChildNodes.getLength(); i++) {
            Node rootNode = rootChildNodes.item(i);

            if (rootNode instanceof Element) {
                Element child = (Element) rootNode;
                findData(child, laptop);
            }
        }
    }

    /**
     * Finds the data in each tag and will print Laptop objects out to the console when all
     * values have been set
     * @param child  passes the Element object
     * @param laptop passes the Laptop object
     */
    private static void findData(Element child, Laptop laptop) {
        boolean isReady = false;    // checks if the Laptop object has been set up yet
        NodeList childChildNodes = child.getChildNodes();

        for (int i = 0; i < childChildNodes.getLength(); i++) {
            Node childNode = childChildNodes.item(i);

            if (childNode instanceof Element) {
                Element lastChild = (Element) childNode;
                Text lastChildText = (Text) lastChild.getFirstChild();
                String tagName = lastChild.getTagName();
                String data = lastChildText.getData();

                // Creates new Laptop objects
                switch (tagName) {
                    case "id":
                        laptop.setId(Integer.parseInt(data));
                        break;
                    case "brand":
                        laptop.setBrand(data);
                        break;
                    case "name":
                        laptop.setName(data);
                        break;
                    case "productNumber":
                        laptop.setProductNumber(data);
                        break;
                    case "serial":
                        laptop.setSerial(data);
                        break;
                    case "os":
                        laptop.setOs(data);
                        break;
                    case "ram":
                        laptop.setRam(Double.parseDouble(data));
                        break;
                    case "cpu":
                        laptop.setCpu(data);
                        break;
                    case "storage":
                        laptop.setStorage(Double.parseDouble(data));
                        break;
                    case "price":
                        laptop.setPrice(Double.parseDouble(data));
                        isReady = true;
                }

                if (isReady) {  // if object is ready to be printed
                    System.out.println(laptop.toString());
                }
            }
        }
    }
}