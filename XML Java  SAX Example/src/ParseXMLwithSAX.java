/**
 *  Ray Ryon
 *	Sample XML program using SAX parsing.
 *  See org.xml.sax.ContentHandler for all available events.
 *  Help for this example comes from: http://java.sun.com/developer/technicalArticles/xml/mapping/
* 
* This example uses Person class with inherited subclasses
*/
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

public class ParseXMLwithSAX extends DefaultHandler {
	static Person person;
	static String currentTag;
 
	public void startDocument( ) throws SAXException {
		System.out.println( "SAX Event: START DOCUMENT" );
	}
   public void endDocument( ) throws SAXException {
	    System.out.println( "SAX Event: END DOCUMENT" );
   }
   public void startElement( String namespaceURI, String localName, String qName, Attributes attr) throws SAXException {
        	System.out.println( "SAX Event: START ELEMENT[ " + localName + " ]" );
	   		currentTag = localName;
	   		if(currentTag.equals("student")) {
        		person = new Person();
        		System.out.println("Student");
        	}
	   		if(currentTag.equals("graduate")) {
        		person = new Graduate();
        		System.out.println("Graduate");
	   		}
   }
   public void endElement( String namespaceURI, String localName, String qName )
   		throws SAXException {
	   		// System.out.println( "SAX Event: END ELEMENT[ " + localName + " ]" );
	   if(localName.equals("student")) {
    		System.out.println(person);
    	}
	   if(localName.equals("graduate")) {
   		System.out.println(person);
   	}
    		currentTag = "";
  		
   }
   public void characters( char[] ch, int start, int length )
   		throws SAXException {

//	   	System.out.print( "SAX Event: CHARACTERS " );
	    String value = new String(ch,start,length);
	  
	   	System.out.println( currentTag + " " + value  );
	   	if( currentTag.equals("name")) {
    		person.setName(value);
    	}
	   	if( currentTag.equals("age")) {
    		person.setAge(value);
    	}
	   	if( currentTag.equals("gender")) {
    		person.setGender(value.charAt(0));
    	}
	   	if( currentTag.equals("major")) {
	   		if(person instanceof Graduate) {
	   			(  (Graduate) person).setMajor(value);
	   		}	   		
	   		else if(person instanceof Student) {
	   			((Student) person).setMajor(((Student) person).getMajor()+" and "+value);
	   			}
			   	else{
			   		person = new Student(person);
		    		((Student) person).setMajor(value);
			   	}
		   	}
	   	if (currentTag.equals("graduation")) {
	   		(  (Graduate) person).setGraduationYear(value);
	   	}
	   	
   }
   // Constructor
   public ParseXMLwithSAX() {
      try {
         // Create SAX 2 parser...
         XMLReader xr = XMLReaderFactory.createXMLReader();

         // Set the ContentHandler...
		xr.setContentHandler( this );

         // Parse the file...
         xr.parse( new InputSource( new FileReader( "Student.xml" )) );

      } catch ( Exception e ) {
    	  e.printStackTrace();
      }
   }
   public static void main( String[] argv ) {
 	  System.out.println( "Example of SAX Events:" );
 	  ParseXMLwithSAX ob = new ParseXMLwithSAX();		// create object and call constructor.
    }
}