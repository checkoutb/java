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
        System.out.println(j);      //�������ֱ��� ֻ������4�Ρ�list.get(i) == 2ʱ���������3�ˡ�2��ɾ�ˡ�����˵3���Ԫ��û�о���list.get(i) == 2���жϡ�2���Ԫ��û��print
    
        System.out.println();
        list.add(1, 2);     //0��ʼ��add���Ժ����1���λ�á�
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
                i--;        //���Ͼ������ģ�5�Σ����û�취��ʵ�����ǰ�==2��ȫ��ɾ���ˡ�
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
                it.remove();        //�������it.remove������list.remove(i).. ����it.remove���޲εġ�
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
//                list.remove(i);           //foreach��ɾ���Ļ��ᱨ��ConcurrentModificationException������˵����ǣ���Iteratorʱ���ֶԼ��Ͻ����޸ģ��ͻᱨ�������
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
