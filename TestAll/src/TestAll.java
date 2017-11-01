import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 */
public class TestAll {

    public int a;
    
    private final int aaa;
//    static
//    {
//        aaa = 3;
//    }
    
    public TestAll()
    {
        aaa = 3;
    }
    
    public int getAAA()
    {
        return aaa;
    }
    
	/**
	 */
	public static void main(String[] args) {
		

	    
	    String s23 = "A";
	    System.out.println(s23.substring(0, 1));

	    
	    
	    
	    
	     
	    int i = 1;
	    System.out.println(i+++""+i+++""+i+++""+i+++""+i++);
	    System.out.print(i+++""+i+++""+i+++""+i+++""+i++);
	    
	    
	    BigDecimal[] a = new BigDecimal[4];
	    System.out.println("\n\n" + a[1]);      //数组默认是null，，属性会编译报错。...忘记后一句是什么意思了。
	    
	    
	    int a1 = 4;
	    int b = 3;
	    
	    BigDecimal bg = new BigDecimal(a1 + b).divide(new BigDecimal(2), 2, RoundingMode.HALF_UP);
	    System.out.println(bg);
	    
	    
	    final int ad = 3;
//	    ad++;
	    
	    int a2 = 4;
	    fun_aaa(a2);
	    System.out.println("\n\n" + a2);
	    Integer s2 = new Integer(a2);
	    fun_aa(s2);
	    System.out.println(s2);
	    
	    TestAll ta = new TestAll();
	    ta.a = 123;
	    fun_a(ta);
	    System.out.println(ta.a);
	}

	public static void fun_a(TestAll a)
	{
	    a.a = 457;
//	    a.getAAA()++;
	}
	
	public static void fun_aaa(int a)
	{
	    a++;
	    
	}
	

	public static void fun_aa(Integer a)
	{
	    a = new Integer(3);            //id 改变
//	    a.intValue() ++;
	    a++;                   //id gaibian
	    System.out.println(" " + a);
	}
}
