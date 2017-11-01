package aug.tf.calendar_exception;

import java.util.Calendar;
import java.util.Date;

public class MonthAndThrows {

    public static void main(String[] args) throws RuntimeException{
        
        Calendar c = Calendar.getInstance();        //也是现在的时间
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
            throw new RuntimeException();       //非受检异常，不会要求有处理这个exception的代码，除了RuntimeException的全是受检异常
        }
        if(a == 4)
        {
//            throw new Exception();            //包含受检异常，无法编译。要求有代码来处理这个exception，要么trycatch，要么throws
        }
        System.out.println("zxcv");         //一旦throw，如果前面没有catch到，那么不会执行。就算throws，这里也不能运行。
        
    }
}
