package sep.fi.stringbuffer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RemoveList {

    public static void main(String[] args) {

//        System.out.print("asd");
//        Scanner sc = new Scanner(System.in);
//        
//        int a = sc.nextInt();
//        System.out.println(a);
        
        List<Integer> list = new LinkedList<>();
        
        for(int i = 1; i < 6; i++)
        {
            list.add(i);
        }
        for(Integer i : list)
        {
            System.out.print(i + ", ");
        }
        System.out.println();
        
        int j = 0;
        for(int i = 0; i < list.size(); i++)
        {
            j++;
            if(list.get(i) == 2)
            {
                list.remove(i);
            }
            
            System.out.print(list.get(i) + ", ");
        }
        System.out.println(j);      //上面这种遍历 只遍历了4次。list.get(i) == 2时，输出的是3了。2被删了。就是说3这个元素没有经过list.get(i) == 2的判断。2这个元素没有print
    
        System.out.println();
        list.add(1, 2);     //0开始，add完以后就在1这个位置。
        list.remove(2);
        list.add(2, 2);
        for(Integer i : list)
        {
            System.out.print(i + ", ");
        }
        System.out.println();
        j = 0;
        for(int i = 0; i < list.size(); i++)
        {
            j++;
            if(list.get(i) == 2)
            {
                list.remove(i);
                i--;        //加上就正常的，5次，输出没办法，实际上是把==2的全部删除了。
            }
            System.out.print(list.get(i) + ", ");
        }
    
        System.out.println();
        System.out.println();
        
        list.add(1, 2);
        list.add(1, 2);
        Iterator<Integer> it = list.iterator();
        while(it.hasNext())
        {
            int i = it.next();
            if(i == 2)
            {
                it.remove();        //这里必须it.remove，不能list.remove(i).. 而且it.remove是无参的。
            }
        }
        
        for(int i = 0; i < list.size(); i++)
        {
            System.err.print(list.get(i) + ", ");
        }
        
        System.out.println();
        System.out.println();
        
        
        list.add(1, 2);
        list.add(1, 2);
        for(Integer i : list)
        {
            if(i == 2)
            {
//                list.remove(i);           //foreach里删除的话会报错ConcurrentModificationException，网上说这个是：打开Iterator时，又对集合进行修改，就会报这个错误。
            }
        }
        
        for(Integer i : list)
        {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
