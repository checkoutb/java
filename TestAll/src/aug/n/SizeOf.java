package aug.n;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SizeOf {

    public static void main(String[] args) {
        System.out.println(Integer.SIZE);
        System.out.println(Double.SIZE);
        System.out.println(Float.SIZE);
        System.out.println(Float.toHexString(3f));          //...==
        
        Integer i = Integer.reverse(1);         //bits 反转
        System.out.println(i);
        
        System.out.println(i instanceof Integer);       //变量 instanceof 类
        System.out.println(Integer.class.isInstance(i));
        System.out.println();
        
        int[] a = {1,2};
        show(a);
        System.out.println(a[1]);
        
        String s = "2017/7/5";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date d = sdf.parse(s);
            System.out.println(d);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        BigDecimal bd = new BigDecimal(10000);
        BigDecimal bd2 = (bd.multiply(BigDecimal.valueOf(0.0422)));
        System.out.println(bd2);
//        bd2 = bd.divide(new BigDecimal(365), 3, RoundingMode.HALF_DOWN);
//        System.out.println(bd2);
        bd2 = bd2.divide(new BigDecimal(365), RoundingMode.HALF_UP);            //默认是4？？描述写的是用给予的精度。。
        System.out.println(bd2);
        
        bd = BigDecimal.ONE;
//        bd2 = bd.divide(new BigDecimal(3));
        System.out.println(bd2);

        double d = 0.1104 * 365;
        d = d/10000;
        System.out.println(d);
    }
    
    public static void show(final int[] a)
    {
        a[1]++;
    }

}
