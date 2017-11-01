package july.t.clone;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class ReadPropertiesBygetResourceAsStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties p = new Properties();
		//getClassLoader()是从工程根目录下获得，不能加/。跳过，不加/是从当前类的包中获得，加/就是根目录
//		InputStream in = ReadPropertiesBygetResourceAsStream.class.getResourceAsStream("qwer.properties");
		InputStream in = ReadPropertiesBygetResourceAsStream.class.getResourceAsStream("cvb.native");		//....
		try {
			p.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set key = p.keySet();
		for(Object o : key)
		{
			System.out.println(o + " = " + p.get(o));
		}
		
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
