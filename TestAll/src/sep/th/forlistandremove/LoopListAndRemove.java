package sep.th.forlistandremove;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LoopListAndRemove {

    public static void main(String[] args) {

        
//      
//      Integer[] aa = {1,2,3,4,5,6,7,8,9,0};
//      List<Integer> list = Arrays.asList(aa);
//      
//      list.remove(list.get(2));
//      
//      for(Integer q : list)
//      {
//          System.out.print(q + ", ");
//          if(q%2 == 0)
//          {
//              list.remove(q);
//          }
//          
//      }
        
        
        List<Integer> list = new LinkedList<>();
        
        for(Integer i = 0; i < 10; i++)
        {
            list.add(i);
        }
        
        for(Integer i : list)
        {
            System.out.println(i + "..");
        }
        
//      for(Integer i : list)
//      {
//          System.out.println(i);
//          if(i%2 == 0)
//          {
//              list.remove(i);
//          }
//      }
        
//      Iterator it = list.iterator();          //ok
//      while(it.hasNext())
//      {
//          Integer i = (Integer) it.next();
//          System.out.println(i + ", ");
//          if(i%2 == 0)
//          {
//              it.remove();
//          }
//      }
//      
//      for(Integer i : list)
//      {
//          System.out.print(i + ", ");
//      }
        
        
//      for(int i = 0; i < list.size(); i++)
//      {
//          System.out.println(list.get(i));       //��������Ĳ��롣..���������0235689������i--�������ġ�
//          if(i%2 == 0)
//          {
//              list.remove(i);
//              i--;               //������� ����
//          }
//      }
        
//      for(int i = 0; i < list.size(); i++)     //����ʹ�á�
//      {
//          System.out.println(list.get(i));
//          if(i%2 == 0)
//          {
//              list.remove(list.get(i));
//          }
//      }
        
//      for(Integer i : list)        //����ᱨ�쳣concurrentmodification
//      {
//            System.out.println(list.get(i));
//            if (i % 2 == 0) {
//                list.remove(list.get(i));
//            }
//      }
        
//      for(Integer i : list)        //exception
//      {
//          if(i%2 ==0)
//          {
//              list.remove((int)i);
//          }
//      }
    }

}
