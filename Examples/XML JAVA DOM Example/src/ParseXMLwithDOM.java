/**
 * Student Sample application
 *  Program to read an XML file using DOM
 * @version 1.00 07/03/29
 */
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ParseXMLwithDOM {
  public static void main(String[] args)
      throws ParserConfigurationException, IOException, SAXException,
             XPathExpressionException 
  {
	  Person myPerson= null; 
    DocumentBuilderFactory dbFactory =
      DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

    File file = new File("student.xml");
    Document doc = docBuilder.parse(file);
    Element root = doc.getDocumentElement();
        
// This code processes the Child elements of the root.
        
    NodeList nodes = root.getChildNodes();
    int numStudents = 0;
    for(int i=0; i<nodes.getLength(); i++)
    {
    
      Node childNode = nodes.item(i);
      if (childNode instanceof Element)
      {
      	numStudents++;
      	if (numStudents != 1)
      		System.out.println(myPerson.toString());
      	myPerson = new Person();
        System.out.println("Person " + numStudents + ": ");
        Element childElement = (Element)childNode;
        NodeList nodes2 = childElement.getChildNodes();
        for(int j=0; j<nodes2.getLength(); j++)
    	{
            Node childNode2 = nodes2.item(j);
            if (childNode2 instanceof Element)
            {
                Element childElement2 = (Element)childNode2;
                Text textNode2 = (Text)childElement2.getFirstChild();
                String tagName = childElement2.getTagName();
                String data = textNode2.getData();
//                System.out.print("\t"+ tagName);
//                System.out.println(": " + data);
                switch(tagName) {
                	case "name" : myPerson.setName(data);
                		break;
                	case "age" : myPerson.setAge(data);    		
            			break;
                	case "gender" : myPerson.setGender(data);
            			break;
                	case "major" : 
                		if (myPerson instanceof Student) {
               			((Student) myPerson).setMajor(((Student) myPerson).getMajor()+", "+data);
                		}
               			else {
                  			myPerson = new Student(myPerson);
                			((Student) myPerson).setMajor(data);
                			}
               		break;
               	case "graduation" : 
                		myPerson = new Graduate((Student) myPerson);
                		((Graduate) myPerson).setGraduationYear(data);  
                		break;
               } // End of case
             }  // End of if for children elements
         }  // End of for next loop
      }  // End of if for Student element
   } // End of first for next loop
    	// Print out the last object.
  		System.out.println(myPerson.toString());
  }  // End of main
} // End of class
