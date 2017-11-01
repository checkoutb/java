package sep.e;

import java.math.BigDecimal;

public class ConnectJoin {

    public static void main(String[] args) {

        String s1 = null;
        String s2 = "asd";
        String s3 = s1+s2;
        System.out.println(s3);     //nullasd
        
        StringBuffer sb = new StringBuffer().append(s1).append(s2).append(s3);
        System.out.println(sb);         //nullasdnullasd
        System.out.println(sb.length() + " , " + sb.capacity());        //14 , 16
        
        
        BigDecimal bg = new BigDecimal(0);
        System.out.println(bg);
        
        BigDecimal bg2 = bg.add(new BigDecimal(100));
        System.out.println(bg + ",,," + bg2);
        
    }

}
