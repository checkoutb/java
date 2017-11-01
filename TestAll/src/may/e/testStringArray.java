package may.e;

/**
 */
public class testStringArray {

	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "may.e";
		Package p = Package.getPackage(name);
		System.out.println(p.getName());
		String s1 = "qwert12345";
		System.out.println(s1.substring(4, s1.length()));
		
		
		String[] m = new String[11];
//		System.out.println(m.toString());
		for(String s : m)
		{
			System.out.print(s + " ");
		}
		System.out.println();
		setS(m);
		for(String s : m)
		{
			System.out.print(s + " ");
		}
		
		String[] monthOneYear = new String[10];
		System.arraycopy(m, 2, monthOneYear, 0, 5);
		for(String s : monthOneYear)
		{
			System.out.print(s + " ");
		}
		
//		System.out.println(m.toString());
		
//		String[] n = null;
//		for(String s : n)
//		{
//			System.out.println("sssss");
//		}
	}
	
	private static void setS(String[] m)
	{
		for(int i = 0; i < m.length; i++)
		{
			m[i] = "cc " + i;
		}
	}
	

}
