package apr.tseven;

import java.io.File;


/**
 */
public class ExceptionTest {

//	private static final Exception ArrayStoreException = null;


	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		try
		{
			beCalledByMain();
		}
//		catch(NullPointerException e)
		{
			System.out.println("111");
//			e.printStackTrace();
		}
	}

	
	public static void beCalledByMain()
	{
		String str = null;
//		str.length();
		File f = new File(str);
		System.out.println(f);
	}
}
