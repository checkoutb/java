package july.tw;

/**
 */
public class 中文类 {

	/**
	 */
	public static void main(String[] args) {
		
		中文类 中 = new 中文类();
		中.中文方法();
	}
	
	public void 中文方法()
	{
		String 字符串 = "字符串";
		int 数值 = 5;
		System.err.println(字符串 + " " + (数值 + 4));		//left2right.so string+4==string.
	}

}
