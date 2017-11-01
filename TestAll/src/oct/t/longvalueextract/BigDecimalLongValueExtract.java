package oct.t.longvalueextract;

import java.math.BigDecimal;

public class BigDecimalLongValueExtract {

    public static void main(String[] args) {
        
        BigDecimal bd = new BigDecimal(11.8);
        
//        long l = bd.longValueExact();         //bd带小数的话，这里报错。
        
        long ll = bd.longValue();               //直接截取
        
        System.out.println(bd + ", " + ll);
        
        float f = bd.floatValue();
        
        
    }

}
