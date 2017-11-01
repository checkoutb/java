package sep.t;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmptyAndGet {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<Long> list = new ArrayList<>();
//        Long l = list.get(0);       //‘ΩΩÁ¡À
        
        BigDecimal bg = null;
        bg = BigDecimal.ZERO;
        BigDecimal bg2 = BigDecimal.ZERO;
        bg2 = bg2.add(new BigDecimal(2));
        System.out.println(bg + ", " + bg2);
    }

}
