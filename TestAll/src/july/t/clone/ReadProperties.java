package july.t.clone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Set;

/**
 */
public class ReadProperties {

	/**
	 */
	public static void main(String[] args) {
		Properties p = new Properties();
//		InputStream in = ReadProperties.class.getClassLoader().getResourceAsStream("f:\\asdf.properties");
		InputStream in = null;
		try {
			in = new FileInputStream("f:/asdf.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}				//InputStream 是一个abstract class
		if(in == null)
		{
			System.out.println("null");
			return;
		}
		try {
			p.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set set = p.keySet();
		for(Object o : set)
		{
			System.out.println(o.toString() + " = " + p.getProperty((String)o));
		}
		System.out.println(p.get("qwe"));
		System.out.println(p.getProperty("qwe"));
		System.out.println(p.size());
		System.out.println(p.put("zqz", "尝试中文"));
		System.out.println(p.getProperty("zqz"));
		
		try {
			OutputStream out = new FileOutputStream("f:/asdf.properties");
			p.store(out, "zzzz11zzs");
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
