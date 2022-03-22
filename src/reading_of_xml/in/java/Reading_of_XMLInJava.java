
package reading_of_xml.in.java;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Reading_of_XMLInJava {

    public static void main(String[] args) {
        Document  dom;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      try
      {
          DocumentBuilder builder = factory.newDocumentBuilder();
          dom = builder.parse("cars.xml");
        
          Element doc = dom.getDocumentElement();
          NodeList ownersList = doc.getElementsByTagName("owner");
          
          for(int i = 0 ; i < ownersList.getLength() ; i++)
          {
              Element owner =  (Element)ownersList.item(i);
              if(owner.getAttribute("name").equals("Jane")){
              NodeList carsList = owner.getElementsByTagName("car");
              
              printcars(carsList);
          }
          }
          
         
      }
      catch(ParserConfigurationException pce)
      {
          System.err.println(pce.getMessage());
      }
      catch(SAXException se)
      {
          System.err.println(se.getMessage());
      }
      catch(IOException ioe)
      {
          System.err.println(ioe.getMessage());
      }

    }
    
  public static void printcars(NodeList cars)
      {
        for(int i = 0; i < cars.getLength() ; i++)
        {
            Element carNode = (Element)cars.item(i);
            Car carobj       = new  Car();
            carobj.color = carNode.getElementsByTagName("color").item(0).getTextContent();
            carobj.make  = carNode.getElementsByTagName("make").item(0).getTextContent();
            carobj.model = carNode.getElementsByTagName("model").item(0).getTextContent();
            carobj.year = Integer.parseInt(carNode.getElementsByTagName("year").item(0).getTextContent());
            carobj.vin  = carNode.getAttribute("vin");
            System.out.println(carobj.toString());
        }
      }
    
}
