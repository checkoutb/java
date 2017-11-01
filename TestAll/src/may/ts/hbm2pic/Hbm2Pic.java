package may.ts.hbm2pic;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 */
public class Hbm2Pic {

	/**
	 * @throws TransformerException 
	 */
	public static void main(String[] args) throws TransformerException {

		/*TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.setOutputProperty("encoding", "UTF-8");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		t.transform(new DOMSource(null, "F:\\whocare.hbm.xml"), new StreamResult(out));
		String strXml = out.toString();
		System.out.println(strXml);*/
		
		String f = "f:\\whocare.hbm.xml";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document d = db.parse(f);
//			NodeList nl = d.getChildNodes();
			
			/*for(int i = 0; i < nl.getLength(); i++)
			{
				Node n = nl.item(i);
				NodeList nll = n.getChildNodes();
				System.out.println(n.getNodeName());
				for(int j = 0; j < nll.getLength(); j++)
				{
					Node nn = nll.item(j);
					System.out.println("  " + nn.getNodeName());
				}
				System.out.println(n.getNodeName() + " /");
			}
			*/
			/*while(d.hasChildNodes())
			{
				NodeList nl = d.getChildNodes();
				
			}*/
			
			/*int tag = 1;
			while(true)
			{
				switch (tag) 
				{
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					default:
				}
			}*/
			
			/*
			Stack<Object> stack = new Stack<Object>();
			stack.clear();
			stack.push(d);
//			System.out.println(d.getNodeName());
			Node n = null;
			NodeList nl = null;
			int k = 0;
			Pattern pattern = Pattern.compile("#.*");
//			Matcher matcher = null;
			

			while(!stack.isEmpty())
			{
				if(stack.peek() instanceof String)
				{
					System.out.println(stack.pop());
					continue;
				}
				n = (Node) stack.pop();
				
				if(n.hasChildNodes())
				{
					stack.push(n.getNodeName());
					
					System.out.println(n.getNodeName());
					nl = n.getChildNodes();
					for(int i = nl.getLength()-1; i>=0; i--)
					{
						stack.push(nl.item(i));
					}
				}
				else
				{
					if(pattern.matcher(n.getNodeName()).matches())
					{
						System.out.print("");
					}
					else
					{
						System.out.println(n.getNodeName() + "  " + n.getAttributes().getNamedItem("name"));
					}
				}
			}
			
			*/
			/*
			String s = null;
			NodeList nl = d.getElementsByTagName("class");
			for(int i = 0; i < nl.getLength(); i++)
			{
				s = nl.item(i).getAttributes().getNamedItem("name").getNodeValue();
				System.out.println(s);
			}
			*/
			
//			String s = "F:\\wobang\\wobang_workspace\\CMS任务书\\2016年CMS任务书";
			String s = "F:\\wobang\\wobang_workspace\\Dev_CMS20170222\\src-aviva";
			File f2 = new File(s);
			/*String[] fname = f2.list();
			for(int i = 0; i < fname.length; i++)
			{
				System.out.println(fname[i] + " ");
			}*/
			/*File[] fs = f2.listFiles();
			for(int i = 0; i < fs.length; i++)
			{
				if(fs[i].isDirectory())
				{
					System.out.println("" + fs[i].getName());
				}
				else
				{
					System.out.println("   " + fs[i].getName());
				}
			}*/
			
			showTree(f2, "");
			
			
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void showTree(File f, String prefix)
	{
		File[] fs = f.listFiles();
//		if(prefix.length()!=0 && prefix.contains("|"))
		{
//			System.out.println("                 12222222222222 " + prefix);
//			prefix = "   " + prefix.substring(prefix.length()-4, prefix.length());
//			System.out.println("                 22222333        " + prefix);
		}
		
		if(prefix.length() > 6)
		{
			prefix = "    " + prefix.substring(prefix.length()-4*(prefix.length()/4-1), prefix.length());
		}
		for(int i = 0; i < fs.length; i++)
		{
			if(fs[i].isDirectory())
			{
				System.out.println(prefix + fs[i].getName());
//				System.out.print(prefix);
				showTree(fs[i], "|---" + prefix);
			}
			else
			{
				System.out.println(prefix + fs[i].getName());
			}
		}
	}

}
