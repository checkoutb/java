package may.f;

import java.util.HashSet;
import java.util.Set;

/**
 */
public class XingCan {

	
	private int a;
	private String s;
	
	
	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Set<Integer> s = new HashSet<Integer>();
		s.add(3);
		
		System.out.println(s);
		if(3 == s.iterator().next())
		{
			System.out.println(s.iterator().next());
		}
		
		/*int a = 4;
		StringBuffer ss = new StringBuffer("a");
		StringBuffer qq = new StringBuffer("b");
		
		XingCan x = new XingCan();
		System.out.println(x + " " + a + " " + ss + " " + qq);
		TestQ(x, a, ss, qq);
		System.out.println(x + " " + a + " " + ss + " " + qq);*/
	}

	private static void TestQ(XingCan x, int a, StringBuffer ss, StringBuffer qq)
	{
		ss.append("asddw");
		qq = ss;
		qq.append("IIIIIIIIII");
		a = 111111;
		x.setA(3);
		x.setS("1231");
		System.out.println(ss + " " + qq);
	}

	/**
	 * @return the a
	 */
	public int getA() {
		return a;
	}


	/**
	 * @param a the a to set
	 */
	public void setA(int a) {
		this.a = a;
	}


	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}


	/**
	 * @param s the s to set
	 */
	public void setS(String s) {
		this.s = s;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "XingCan [a=" + a + ", s=" + s + "]";
	}

}
