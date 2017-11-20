package nov.t.arrayadd2list;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class AddArray2List {

    public static void main(String[] args) {

        ArrayList<int []> list = new ArrayList<>();
        int[] arr = new int[2];
        
        arr[0] = 1;
        arr[1] = 2;
        
        list.add(arr);
        
        list.add(arr);
        
        System.out.println(" 111 : " + list.size());            //2
        
        
        ArrayList<String> llist = new ArrayList<>();
        String s = "asd";
        llist.add(s);
        llist.add(s);
        System.out.println(" 222 : " + llist.size());           //2
        
        
        LinkedHashSet<int []> set = new LinkedHashSet<>();
        set.add(arr);
        set.add(arr);
        System.out.println(" 3 : " + set.size());           //1
        
        arr[1] = 3;
        set.add(arr);
        System.out.println(" 4 : " + set.size());           //1
        
        arr[0] = 3;
        set.add(arr);
        System.out.println(" 5 : " + set.size());           //1
        
        
        arr[0] = 111;
        arr[1] = 222;
        
        list.add(arr);
        
        arr = list.get(0);
        System.out.println(" 6 : " + arr[0] + ", " + arr[1]);       //gg,111,222.......................
        
        
        List<Object[]> list2 = new LinkedList<>();
        Object[] oarr = new Object[3];
        
        oarr[0] = new BigDecimal(11);
        oarr[1] = new String("11.2");
        oarr[2] = "111";
        
        list2.add(oarr);
        
        oarr = new Object[3];
        
        oarr[0] = new BigDecimal(1);
        oarr[2] = "asd";
        oarr[1] = new String("ax");
        
        list2.add(oarr);
        
        oarr = list2.get(0);
        System.out.println(" 7 : " + oarr[0] + ", " + oarr[1] + ", " + oarr[2]);
        oarr = list2.get(1);
        System.out.println(" 8 : " + oarr[0] + ", " + oarr[1] + ", " + oarr[2]);
        
        System.out.println(" 9 : " + oarr.hashCode());
        
    }

}
