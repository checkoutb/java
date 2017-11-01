package july.tei.monthofcalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MonthOfCalendar {

    public static void main(String[] args) {
        
        Date d = new Date();
        Calendar c = Calendar.getInstance();
//        c.setTime(d);
        
        int month = c.get(Calendar.MONTH);      //从0开始的。
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d) + "\n" + c + "\n" + month);

        System.out.println(c.get(Calendar.DAY_OF_MONTH));       //cong 1 kaishi 
        
        System.out.println(c.get(Calendar.DAY_OF_WEEK));        //周日为1.
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        c.add(Calendar.MONTH, 0);
        System.out.println(sdf.format(c.getTime()));
    }

}
