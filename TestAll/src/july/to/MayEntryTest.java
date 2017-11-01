package july.to;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class MayEntryTest {

    /**
     */
    public static void main(String[] args) {
        
        maps.put(1, "a");
        maps.put(2, "b");
        maps.put(3, "c");
        
        for(Map.Entry<Integer, String> entry : maps.entrySet())
        {
            System.out.println(entry);      //...一次取出所有信息的、
            
            int s = entry.getKey();
//            if(entry instanceof Integer)
//            {
//                System.out.println("ttttt");
//            }
        }
        
        
        Object o = maps.get(5);
        System.out.println(o);
        if(o == null)
        {
            System.out.println("nullll");
        }
    }

    public static Map<Integer, String> maps = new HashMap<Integer, String>();
}
