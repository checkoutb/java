package july.e.enumm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 */
public class DoubleFor {

	/**
	 */
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.addAll((Collection<String>) Arrays.asList(new String[]{"qqq","zzz","aaa"}));
//		list.add(")
		
		for(Iterator<String> i = list.iterator(); i.hasNext(); )
		{
			for(Iterator<String> j = list.iterator(); j.hasNext(); )
			{
				System.err.println(i.next() + " " + j.next());
			}
		}
		
		for(String s : list)
		{
			for(String s1 : list)
			{
				System.out.println(s + " " + s1);
			}
		}
	}

}
