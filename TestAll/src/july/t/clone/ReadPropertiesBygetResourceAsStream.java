package july.t.clone;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class ReadPropertiesBygetResourceAsStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties p = new Properties();
		//getClassLoader()�Ǵӹ��̸�Ŀ¼�»�ã����ܼ�/������������/�Ǵӵ�ǰ��İ��л�ã���/���Ǹ�Ŀ¼
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
