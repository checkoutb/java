package nov.twen;

public class TryForAndParameterOrder {

    public static void main(String args[])
    {
        
        long start = System.nanoTime();
//        int b = 1;
        String bb = "";
        for(int i = 0; i < 100000; i++)
        {
            try{
//                b += i;
                bb += i;
                if(i % 10 == 0)
                {
                    bb = bb.substring(bb.length()-1);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        long end = System.nanoTime();
        System.out.println("��ʱ��" + (end - start));
        
        
        long start2 = System.nanoTime();
        try
        {
            String aa = "";
//            int a = 1;
            for(int i = 0; i < 100000; i++)         //��1000 �� 10000��ֱ��������
            {
//                a += i;
                aa += i;
                if(i % 10 == 0)
                {
                    aa = aa.substring(aa.length()-1);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        long end2 = System.nanoTime();
        System.out.println("��ʱ��" + (end2 - start2));
        

    }
}
