package sep.tw.finaltest;

import java.math.BigDecimal;

public class Final {

    public final int a = 2;
    
    public final BigDecimal b;
    
    public static void main(String[] args) {
        
        final int aa;
        System.out.println("asd");
        aa = 4;                         //ֻҪ��ʹ��ǰ����ֵ�������
        System.out.println(aa);
        
        Final f = new Final();
//        f.b = f.b.add(BigDecimal.ONE);        //���ˣ���Ū�ˣ�������������ֵ�ܸģ�������ܱ䡣
        
    }

    public Final()
    {
//        a = 4;            //Ҫô����ʱ��ʼ����Ҫô��������ʼ����ֻ���ұ���ѡһ����
        b = BigDecimal.TEN;
    }
    
    public Final(BigDecimal bbb)
    {
        b = bbb;
    }
}
