package june.t;

import java.util.Scanner;

/**
 */
public class Systemgetsetproperty {

	/**
	 */
	public static void main(String[] args) {
		System.out.print("intput:");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.setProperty("asd", s);
		printf();
	}
	
	public static void printf()
	{
		System.out.println(System.getProperty("asd"));
	}

}
