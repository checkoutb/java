package june.s;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 */
public class bigdecimalorvalueof {

	/**
	 */
	public static void main(String[] args) {
		
		/*BigDecimal a = new BigDecimal(1.22);
		BigDecimal aa = new BigDecimal("1.22");
		System.out.println(a + "\n" + aa);
		
		a = BigDecimal.valueOf(1.22);
		aa = BigDecimal.valueOf(1.22);
		System.out.println(a + "\n" + aa);
		
		a = new BigDecimal(111111111111111111.1);
		aa = BigDecimal.valueOf(111111111111111111l);
		System.out.println(a + "\n" + aa);*/

		Map m = new HashMap();
		m.put(1, 111);
		m.put(2, "222");
		System.out.println(m.toString());
		
		m.put(2, "2");
		System.out.println(m.toString());
		m.put("2", "22");
		System.out.println(m.toString());
		m.put("a", "a");
		m.put('a', "aa");
		System.out.println(m.toString());
		System.out.println("----------------------");
		
		StringBuffer sb = new StringBuffer("a");
		StringBuffer sb1 = new StringBuffer("a");
		m.put(sb, "zz");
		m.put(sb1, "z");
		System.out.println(m.toString());
		
		Set s = m.entrySet();
		System.out.println(s);
		for(Iterator i = s.iterator(); i.hasNext(); )
		{
			
			Object o = i.next();
			System.out.println(((Map.Entry<Object,Object>)o).getKey());
		}
		
		
		/*Set s = new HashSet();
		s.add('a');
		s.add("a");
		s.add("2");
		s.add(2);
		s.add(2);
		StringBuffer sb = new StringBuffer("z");
		StringBuffer sb1 = new StringBuffer("z");
		s.add(sb1);
		s.add(sb);
		System.out.println(s.toString());*/
		
		
	}

}
