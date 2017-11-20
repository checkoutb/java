package nov.ei;

import java.math.BigDecimal;

public class BigDecimalAddMultiply {

    public static void main(String[] args) {

        BigDecimal b5 = new BigDecimal(5);
        BigDecimal b1 = new BigDecimal(1);
        BigDecimal b2 = new BigDecimal(2);
        
        BigDecimal result = b5.subtract(b1).divide(b2);
        
        System.out.println(result);
        
    }

}
