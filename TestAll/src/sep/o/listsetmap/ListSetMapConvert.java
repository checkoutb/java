package sep.o.listsetmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListSetMapConvert {

    public static void main(String[] args) {

        
        Date date = new Date("2011/1/1");           //应该必须这个格式。
        System.out.println(date);
        
        List<Integer> intList = new LinkedList<>();
//        intList.add(5);
        intList.addAll(Arrays.asList(new Integer[]{1,11,3,5}));
        List<Integer> intList2 = new ArrayList<>();
        intList2 = Arrays.asList(new Integer[]{1,11,3,5});
//        for(int i : intList)
//        {
//            System.out.println(i);
//        }
//        System.out.println();
        
//        Set intSet = new HashSet()
        
        show(intList);
        show2(intList);
        show(intList2);
        show2(intList2);
        Set<Integer> intSet = new HashSet<>(intList);
        show(intSet);
        show2(intSet);
        Set<Integer> intSet2 = new LinkedHashSet<>(Arrays.asList(new Integer[]{1,3,11,5}));
        show(intSet2);
        show2(intSet2);
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(3, 5);
        map.put(11, 12);
        map.put(4, 8);
        
        intList.clear();
        intList.addAll(map.keySet());
        intList.addAll(map.values());
        show(intList);
        show2(intList);
        
        intSet.clear();
        intSet.addAll(map.keySet());
        intSet.addAll(map.values());
        show(intSet);
        show2(intSet);
        
        
        intList = new ArrayList<>(map.values());
        intSet = new HashSet<>(map.values());
        show(intList);
        show2(intList);
        show(intSet);
        show2(intSet);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        
        Integer[] array = intList.toArray(new Integer[intList.size()]);
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        
        array = intSet.toArray(new Integer[1]);
        
        array = intSet.toArray(new Integer[]{});
    }

    public static void show2(Collection<?> collection)
    {
        Iterator<?> it = collection.iterator();
        System.out.print("      ");
        while(it.hasNext())
        {
            System.out.print(it.next() + ", ");
        }
        System.out.println();
    }

    public static void show(Collection<? extends Integer> collection)
    {
        if(collection instanceof List)
            System.out.print("list: ");
        if(collection instanceof Set)
            System.out.print("set : ");
        if(collection instanceof Map)
            System.out.print("Map : ");
        for(int i : collection)
        {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
