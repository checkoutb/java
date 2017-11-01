package sep.tw.finaltest;

import java.math.BigDecimal;

public class Final {

    public final int a = 2;
    
    public final BigDecimal b;
    
    public static void main(String[] args) {
        
        final int aa;
        System.out.println("asd");
        aa = 4;                         //只要在使用前被赋值后可以了
        System.out.println(aa);
        
        Final f = new Final();
//        f.b = f.b.add(BigDecimal.ONE);        //算了，不弄了，反正类对象里的值能改，类对象不能变。
        
    }

    public Final()
    {
//        a = 4;            //要么定义时初始化，要么构造器初始化，只能且必须选一个。
        b = BigDecimal.TEN;
    }
    
    public Final(BigDecimal bbb)
    {
        b = bbb;
    }
}
