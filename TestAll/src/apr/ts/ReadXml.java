package apr.ts;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 */
public class ReadXml {

	/**
	 * dom java×Ô´ø¡£¡£
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String fname = "F:/whocare.hbm.xml";
			File f = new File(fname);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document d = builder.parse(f);
//			Document d = builder.parse("file:///F:/whocare.hbm.xml");
			NodeList n = d.getElementsByTagName("class");
			Element e = d.getDocumentElement();
			System.out.println(e.getAttribute("package") + '\n' + e.getAttribute("default-access"));
			for(int i = 0; i < n.getLength(); i++)
			{
				e = (Element) d.getElementsByTagName("class").item(i);
				System.out.println(e.getAttribute("name") + " : " + e.getAttribute("table"));
			}
			System.out.println("done");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	//dom4j
/*	public static void main(String[] args)
	{
		String fname = "F:/whocare.hbm.xml";
		File f = new File(fname);
		
	}*/

}
