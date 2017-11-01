package june.o;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class foreachlist {

	/**
	 */
	public static void main(String[] args) {
		List<String> l = new ArrayList();
		l.add("asd");
		l.add("zxc");
		l.add("dfg");
		
		for(String s : l)
		{
			System.out.println(s);
		}
	}
}
