package nov.six;

import java.math.BigDecimal;

public class IntegerValueOf {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("asd");
        Integer value = Integer.valueOf(4);             // valueOf里面有缓存下来的东西的。网上说是-127 - 128 的Integer类对象。
        
        long time = System.currentTimeMillis();
        BigDecimal bd = BigDecimal.ZERO;
        BigDecimal max = BigDecimal.valueOf(100000000L);
        BigDecimal ad = BigDecimal.ONE;
//        System.out.println(" " + max);
        for(; bd.compareTo(max) < 0; bd = bd.add(ad))
        {
//            System.out.print(bd);
        }
        long used = System.currentTimeMillis() - time;
        System.out.println("bigdecimal " + used);
        
        time = System.currentTimeMillis();
        double dd = 0;
        double dmax = 100000000.0;
        double step = 1;
        
        for(; dd < dmax; dd+=step)
        {
            
        }
        used = System.currentTimeMillis() - time;
        System.out.println("double " + used);
        
        // 10000 3-0
        
        // 100000 大约是15倍，或者更多，主要是double的循环只返回1.。bigdecima的循环返回13-16
        
        // 1000000 31-4,37-4,31-4,31-4,32-4,,大约8倍
        
        // 10000000 151-26,187-26,151-27,154-26,154-25,,6倍
        
        // 100000000 1249-249,1247-249,1259-250,1249-251,,5倍
        
        
        
    }

}
