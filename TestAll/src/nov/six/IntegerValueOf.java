package nov.six;

import java.math.BigDecimal;

public class IntegerValueOf {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("asd");
        Integer value = Integer.valueOf(4);             // valueOf�����л��������Ķ����ġ�����˵��-127 - 128 ��Integer�����
        
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
        
        // 100000 ��Լ��15�������߸��࣬��Ҫ��double��ѭ��ֻ����1.��bigdecima��ѭ������13-16
        
        // 1000000 31-4,37-4,31-4,31-4,32-4,,��Լ8��
        
        // 10000000 151-26,187-26,151-27,154-26,154-25,,6��
        
        // 100000000 1249-249,1247-249,1259-250,1249-251,,5��
        
        
        
    }

}
