package july.tt;

/**
 */
public class Intern {

	/**
	 * 	      s1      s2      s3      s4      s5
      s1    true    true   false    true    true
      s2	  	    true   false    true    true
      s3		           true    false   false
      s4			                true    true
      s5				                    true
		cmd打出来的 复制下来 黏贴出来是不一样的。即使粘到txt，也不一样。
		只有s3是不一样的，其他都是一样的。newString().intern()还不如直接写="hello",,唯一就是转换的时候可能可以用到
	 */
	public static void main(String[] args) {
		
		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");
		String s4 = new String("hello").intern();
		String s5 = "hello".intern();
		
		String[] ss = new String[]{s1,s2,s3,s4,s5};
		
		System.out.print("\t");
		for(int i = 0; i < ss.length; i++)
		{
			System.out.printf("%8s", "s"+(i+1));
		}
		System.out.println();
		for(int i = 0; i < ss.length; i++)
		{
			System.out.printf("%8s", "s"+(i+1));
			for(int k = 0; k < i; k++)
			{
				System.out.print("\t");
			}
			
			for(int j = i; j < ss.length; j++)
			{
				System.out.printf("%8s", ss[i]==ss[j]);
			}
			System.out.println();
		}
		
		for(int i = 0; i < ss.length; i++)
		{
			System.out.println(ss[i].hashCode());
		}
		
		
		//string的hashcode:s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
		//只有对象有hashcode，基本类型是没有的。
		long hash = 0;
		
		for(int i = 0; i < s1.length(); i++)
		{
			hash += Integer.valueOf(s1.charAt(i));
			hash *= 31;
		}
		hash /= 31;
		System.out.println(hash);
		
		Integer i = 4;
		i = -11;
		System.out.println(i.hashCode());		//就等于值。。
//		System.out.println(Integer.hashCode(4) + "," + Integer.hashCode(0));		//1.8但是好像还是没有，，但是api上写了since1.8，
		
		Long l = Long.decode("-0x11");		//可以16进制。		Integer也有decode
		System.out.println(l);
		
		l = Long.valueOf("-1");				//不能16进制
		System.out.println(l);
		
		l = 1L;
		long l2 = Long.rotateLeft(l, 2);
		System.out.println(l2 + ", " + l);
		
		System.out.println(l.bitCount(15L));			//...cannot understand
	}

}
