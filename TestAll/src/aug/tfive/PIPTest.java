package aug.tfive;

import java.util.Set;

public class PIPTest {

    public static void main(String[] args) {
        
        Set<Long> oid = null;       //必须要加 = null，不然下面和null比较会报错 没有初始化。
        if(oid == null)
        {
            System.out.println("nnnuuuullllllll");
        }
    }

}
