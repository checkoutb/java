package june.o;

/**
 */
public class finallyandreturn {

	/**
	 */
	public static void main(String[] args) {
		int a = fin();
		System.out.println(a);
	}
	
	public static int fin()
	{
		try
		{
			System.out.println("try");
			return 100;
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			System.out.println("finally");
			//return 10;		//function will return 10
		}
		return 50;
	}

}
