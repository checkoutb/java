package may.ele;

/**
 */
public class Fabnocci {

	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 1;
		int b = 1;

		for(int i = 1; i < 21; i+=2)
		{
			//fibonacci,,
			System.out.print(a + " " + b + " ");
			a += b;
			b += a;
		}
	}

}
