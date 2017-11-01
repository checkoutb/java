package apr.to;

import java.io.ByteArrayOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Find4mXML {

	public static void main(String[] args) throws TransformerException {
		TransformerFactory  tf  =  TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.setOutputProperty("encoding","UTF-8");
		ByteArrayOutputStream  bos  =  new  ByteArrayOutputStream();
		t.transform(new DOMSource(null, "F:/Commission.hbm.xml"), new StreamResult(bos));
		String xmlStr = bos.toString();
		
		
		
		System.out.println(xmlStr);

	}

}
