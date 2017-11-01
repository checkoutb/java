package june.te;

/**
 */
public class ForTheProjectTest {

	/**
	 */
	public static void main(String[] args) {
		/*Class clazz = null;
		if(clazz == null)
		{
			System.out.println("1111");
		}*/
		
		String s[] = System.getProperty("java.class.path").split(";");
		for (String string : s) {
			System.out.println(string);
		}
	}

}
