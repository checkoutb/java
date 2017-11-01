package oct.thi.mapppppp;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Mapppppppp {

    public static void main(String[] args) {

        
        Map<Long, String> map = new HashMap<>();
        
        Long a = new Long(123);
        
        String s = "zxc";
        
        map.put(a, s);
        
        Long aa = new Long(123);
        
        System.out.println(map.containsKey(aa));
        System.out.println(map.containsKey(a));
        System.out.println(aa.hashCode());
        
        
        a++;
        
        System.out.println("\n\n");
        System.out.println(a);
        System.out.println(a.hashCode());
        System.out.println(map.containsKey(a));
        
        
        System.out.println("\n\n");
        System.out.println(map.get("asd"));
        
        
        String sss = "";
        System.out.println(sss.isEmpty());
        
        sss = map.get(765675);
        System.out.println(sss);
        
        
        sss = map.get(123L);            // 123 is different from 123L
        System.out.println(sss);
        
        map.put(123L, "bnhm");
        System.out.println(map.get(123L));
        
        
        System.out.println(map.size());
        Map<Map<Long, String>, String> map2 = new HashMap<>();
        
        map2.put(map, "097");
        
        System.out.println(map2.get(map));
        System.out.println(map2.get(map));
        
        System.out.println("\n");
        
        map.clear();
        System.out.println(map.size());
        
        System.out.println(map2.get(map));
        
        map.put(123L, "bnhm");
        System.out.println(map2.get(map));
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(null));
        
    }

}
