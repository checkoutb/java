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
		cmd������� �������� ��������ǲ�һ���ġ���ʹճ��txt��Ҳ��һ����
		ֻ��s3�ǲ�һ���ģ���������һ���ġ�newString().intern()������ֱ��д="hello",,Ψһ����ת����ʱ����ܿ����õ�
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
		
		
		//string��hashcode:s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
		//ֻ�ж�����hashcode������������û�еġ�
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
		System.out.println(i.hashCode());		//�͵���ֵ����
//		System.out.println(Integer.hashCode(4) + "," + Integer.hashCode(0));		//1.8���Ǻ�����û�У�������api��д��since1.8��
		
		Long l = Long.decode("-0x11");		//����16���ơ�		IntegerҲ��decode
		System.out.println(l);
		
		l = Long.valueOf("-1");				//����16����
		System.out.println(l);
		
		l = 1L;
		long l2 = Long.rotateLeft(l, 2);
		System.out.println(l2 + ", " + l);
		
		System.out.println(l.bitCount(15L));			//...cannot understand
	}

}
