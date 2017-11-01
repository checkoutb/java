package july.s.threadlocalandresultset;

/**
 */
public class Print1000Char {

	/**
	 */
	public static void main(String[] args) {
		
		//char is short int ,should less then 65535
		char c = (char)20000;
		for(; c < 40000;)
		{
			System.out.print(++c + ",");
			if(c%100 == 0)
			{
				System.out.println();
			}
		}
	}

}
