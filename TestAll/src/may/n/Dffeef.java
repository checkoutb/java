package may.n;

import java.math.BigDecimal;

/**
 */
public class Dffeef {

	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String s2 = "10";
		BigDecimal bg = new BigDecimal(s2);
		System.out.println(bg);
		
		BigDecimal a = BigDecimal.valueOf(0.5);
		if((a.compareTo(BigDecimal.valueOf(0.49))) == 1 ? true : false)
		{
			System.out.println("12121");
		}
		
		if(a.compareTo(BigDecimal.valueOf(0.111)) == 1)
		{
			System.out.println("ccc");
		}
		
		String[] s = null;
		s = Dfff();
		System.out.println(s.length);
		for(String ss : s)
		{
			System.out.print(ss + " ");
		}
	}

	public static String[] Dfff()
	{
		return new String[]{"123", "ddd", "ss", "aa"};
	}
}
