package oct.t.longvalueextract;

import java.math.BigDecimal;

public class BigDecimalLongValueExtract {

    public static void main(String[] args) {
        
        BigDecimal bd = new BigDecimal(11.8);
        
//        long l = bd.longValueExact();         //bd��С���Ļ������ﱨ��
        
        long ll = bd.longValue();               //ֱ�ӽ�ȡ
        
        System.out.println(bd + ", " + ll);
        
        float f = bd.floatValue();
        
        
    }

}
