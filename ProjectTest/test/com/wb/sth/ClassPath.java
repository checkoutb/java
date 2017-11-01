package com.wb.sth;

/**
 */
public class ClassPath {

	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s[] = System.getProperty("java.class.path").split(";");
		for (String string : s) {
			System.out.println(string);
		}
	}

}
