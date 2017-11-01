import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 */
public class Calculator {

	
	public static void ddd()
	{
		System.out.print("dddd");
	}
	/**
	 */
	public static void main(String[] args) {
	    
	    
	    
	    List<Integer> list = new LinkedList<>();
	    for(int i = 11; i < 33; ++i)
	    {
	        list.add(i);
	    }
	    
	    for(Integer i : list) 
	    {
	        System.out.print(i + ", ");
	    }
	    System.out.println("\n");
	    
	    int aa;
	    Iterator it = list.iterator();
	    while(it.hasNext())
	    {
	        aa = (int) it.next();
	        if(aa > 21 && aa < 25)
	        {
	            it.remove();
	        }
	    }
	    
	    for(int i : list)
	    {
	        System.out.print(i + ", ");
	    }
	    System.out.println("\n\n");
	    
	    
	    
	    
	    BigDecimal bg = BigDecimal.ZERO;
	    bg = bg.subtract(BigDecimal.TEN);
	    System.out.println(bg);
	    
	    
	    Set<String> set = new HashSet<>();
	    set.add("asd");
	    System.out.println("          " + set.size());
	    set.add(null);
	    set.add(null);
	    set.add(null);
	    System.out.println("          " + set.size());
	    
//	    set.addAll(null);            // error 
	    
	    List<String> list1 = new LinkedList<>();
	    list1.add("zxc");
	    System.out.println("   " + list1.size());
	    list1.add(null);
	    list1.add(null);
	    list1.add(null);
	    System.out.println("   " + list1.size());
	    
	    
	    Map<String, String> map2 = new HashMap<>();
	    map2.put(null, null);
	    map2.put(null, null);
	    System.out.println(".." + map2.size());
	    System.out.println(".." + map2.get(null));
	    
	    Map<String, String> map3 = new Hashtable<>();
//	    map3.put(null, null);            //error
//	    map3.put("asd", null);       //error
//	    map3.put(null, "asd");       //error
	    
	    
	    BigDecimal jxRate13 = BigDecimal.ONE;
	    BigDecimal jxRateCoefficient = jxRate13.divide(new BigDecimal(0.85), 4, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
//	    if (jxRate3.compareTo(new BigDecimal(0.8)) >= 0) {
	    System.out.println(jxRateCoefficient);
//	    System.exit(0);
	    
//	    int a = 1/0;
	    
	    
	    
        /*
         * G 年代标志符 
         * y 年 
         * M 月 
         * d 日 
         * h 时 在上午或下午 (1~12) 
         * H 时 在一天中 (0~23) 
         * m 分 
         * s 秒 
         * S 毫秒 
         * E 星期 
         * D 一年中的第几天 
         * F 一月中第几个星期几 
         * w 一年中第几个星期 
         * W 一月中第几个星期 
         * a 上午 / 下午 标记符 
         * k 时 在一天中 (1~24) 
         * K 时 在上午或下午 (0~11) 
         * z 时区
         */
	    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss:SS a z k w D F W E G");
	    SimpleDateFormat sdf3 = new SimpleDateFormat("yy/MM/dd HH:mm:ss a");
	    Date now = new Date();
	    System.out.println(sdf1.format(now) + "\n" + sdf2.format(now) + "\n" + sdf3.format(now));
	    
/*	    BigDecimal ss = BigDecimal.valueOf(2551073.31);
	    BigDecimal ys = BigDecimal.valueOf(3497214.34);
	    BigDecimal bg = ss.divide(ys,10,BigDecimal.ROUND_UP);
	    System.out.println(bg);*/
/*
		ddd();
		
		int a = 444;
		a = -a;
		System.out.println(a);
		a = +a;
		System.out.println(a);
		a = -a;
		System.out.println(a);*/
		
	/*	System.out.println(3 & 2);
		System.out.println(1024 & 333);
		System.out.println(1024 | 333);
		System.out.println(333>>1);
		
		String s = "123";
		s += "ddd";
		System.out.println(s);*/
		/*
		System.out.println(22265.66/(393360-22265.66));
		System.out.println(21423.23/0.06 - 393360);
		System.out.println(153120 + 393360);		//546480
		System.out.println((21423.23+8368.2)/(569760.00-(21423.23+8368.2)));
		
		System.out.println(21423.23/393360 - 8368.2/153120);
		System.out.println(8368.2/(153120-2400*2-1680-8368.5));
		System.out.println( 8368.2/(159600.00-7116.79-8368.2) );
		*/
		
//		System.out.println();
//		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println(8667.17-8368.2);
//		System.out.println();
//		System.out.println();
		
	}

}
