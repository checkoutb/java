package june.tn;



/**
 */
public class ThrowsTest {

	/**
	 */
	public static void main(String[] args) {
		
		System.out.println("111111");
		show();
		System.out.println("44444");
	}

	public static void show()
	{
		System.out.println("22222");
		if (1 == 1) {
			throw new RuntimeException();
		}
		System.out.println("33333");
	}
}
