package aug.th.printbigdecimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PrintfBigDecimal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        BigDecimal bg = BigDecimal.valueOf(3.22334);
//        System.out.printf("%10s, %10f, %10d", bg, bg, bg);      //s f������ d����
        
        String s1 = "'fd'e'.'>''dfe'.<//'ef'eaf'2``/fd";
        String s2 = s1.replaceAll("('|>|\\.)", "");
//        String s2 = s1.replaceAll("['</]*", "");            //Ҫ+* ���� +
        System.out.println(s2);
        
        
        Set<Integer> set = new HashSet<>();
//        List<Integer> list = (LinkedList<Integer>) set;     //mlgb...list.addAll(set)�Ϳ�����
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        
    }

}
