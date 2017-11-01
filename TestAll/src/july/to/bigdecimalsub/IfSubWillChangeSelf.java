package july.to.bigdecimalsub;

import java.math.BigDecimal;

/**
 */
public class IfSubWillChangeSelf {

    /**
     */
    public static void main(String[] args) {
        
        BigDecimal bg = new BigDecimal(100);
        BigDecimal bg2 = bg.subtract(new BigDecimal(5));
        
        System.out.println(bg + "\n" + bg2);        //100 95
    }

}
