package july.ten;

/**
 */
public class TryAndFinally {

	/**
	 */
	public static void main(String[] args) {
		
		try
		{
			System.out.println("111");
		}
		finally
		{
			System.out.println("zz");
		}
	}
	
	public static void test(final int a)
	{
		System.out.println(a);
//		a++;			//error
		
	}

}
