package june.tt;

/**
 */
public class CalNumberOfWord {

	/**
	 */
	public static void main(String[] args) {
//		String words = "zeroonetwothreefourfivesixseveneightnine";
		String words = "onethreefivesevennine";
//		System.out.println((int)'a');
//		System.out.println(Integer.valueOf('a'));
		/*int[] nums = new int[26];
		char[] cwords = words.toCharArray();
		for(char c : cwords)
		{
			nums[(int)c - 97]++;
		}
		int index = 97;
		for(int i : nums)
		{
			if(i!=0)
			{
				System.out.print((char)index + ":" + i + ", ");
			}
			index++;
		}
		System.out.println();
		*/
		/*
		 * eight:h
		 * four:u
		 * two:w
		 * six:x
		 * zero:z
		 * 
		 * ----去除上面的5个以后
		 * five:f
		 * three:h,r,t
		 * one:o
		 * seven:s
		 * 
		 * 只剩一个nine
		 * 
		 * */
		
		int a = 11;
		int b = 2342;
		
		/*byte ba = (byte)a;
		byte bb = (byte)b;
		System.out.println(ba);
		int b1 = ba^bb;
		System.out.println(b1);*/
		
		int t = 0;
		/*for(int i = 0; i < 7; i++)
		{
			System.out.println(a>>i & 1);
		}*/
		System.out.println(a>>0 & 1);
		while(a>>1 != 0)
		{
			System.out.println(a>>1 & 1);
			a = a>>1;
		}
		System.out.println(a = a<<1);
		System.out.println(a);
		
		
		
	}

}
