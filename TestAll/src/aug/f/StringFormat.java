package aug.f;

import java.math.BigDecimal;

public class StringFormat {

    public static void main(String[] args) {
        
/*        StringBuilder sb = new StringBuilder();
        String s = String.format("%13s%n", "考核标准");
        sb.append(s);
        s = String.format("%10s", "无敌的考核标准");               //
        sb.append(s);
        System.out.println(sb.toString());
        
        System.out.println(String.format("%9.4f", 1234.567));       //带上小数点9位
*/    
    
        BigDecimal bd = new BigDecimal(0.00001);
        BigDecimal bd2 = new BigDecimal(0.00001);
        BigDecimal bd3 = bd;
        System.out.println(bd == bd3);
        System.out.println(bd == bd2);
        System.out.println(bd.equals(bd2));
    
        
        BigDecimal dd[] = new BigDecimal[4];
        System.out.println("  " + dd[0] + dd[1] + dd[2] + dd[3]);
        
        String s = "BS2";
        System.out.println(Integer.valueOf(s.substring(2)) == 2);           //true
    }

}
