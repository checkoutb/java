package aug.tf.calendar_exception;

import java.util.Calendar;
import java.util.Date;

public class MonthAndThrows {

    public static void main(String[] args) throws RuntimeException{
        
        Calendar c = Calendar.getInstance();        //Ҳ�����ڵ�ʱ��
//        System.out.println(c);
        c.set(2017, 0, 1);
        System.out.println(c.toString() + "\n" + c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DATE));
//        c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
//        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DATE));
//        c.set(Calendar.MONTH, -1);
//        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DATE));
        //set .... add....
        c.add(Calendar.MONTH, -1);
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DATE));
        c.add(Calendar.MONTH, -13);
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DATE));
        
        int a = 4;
        if(a == 4)
        {
            throw new RuntimeException();       //���ܼ��쳣������Ҫ���д������exception�Ĵ��룬����RuntimeException��ȫ���ܼ��쳣
        }
        if(a == 4)
        {
//            throw new Exception();            //�����ܼ��쳣���޷����롣Ҫ���д������������exception��Ҫôtrycatch��Ҫôthrows
        }
        System.out.println("zxcv");         //һ��throw�����ǰ��û��catch������ô����ִ�С�����throws������Ҳ�������С�
        
    }
}
