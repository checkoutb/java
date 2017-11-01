package july.tf;

import java.math.BigDecimal;

public class BigDecimalDeJinDu {


    public static void main(String[] args) {
        
        
        BigDecimal bg = new BigDecimal(0.00390625);     //2^-n不会出现误差
        System.out.println(bg);
        bg = BigDecimal.valueOf(0.00232);
        System.out.println(bg + " " + new BigDecimal(0.00232));
    }

}
