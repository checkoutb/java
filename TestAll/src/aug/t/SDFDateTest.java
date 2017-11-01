package aug.t;

import java.text.SimpleDateFormat;
import java.text.DateFormat.Field;
import java.util.Calendar;
import java.util.Date;

/**
 */
public class SDFDateTest {

    /**
     */
    public static void main(String[] args) {
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Calendar c = Calendar.getInstance();
        System.out.println(sdf.format(c.getTime()));        //now  2017-08-03

        sdf = new SimpleDateFormat("YYYY-mm-DD");       //error ?
        System.out.println(sdf.format(c.getTime()));
        
        sdf = new SimpleDateFormat("yyyy-M-d");         // 2017-8-3
        System.out.println(sdf.format(c.getTime()));
        
        Date d = c.getTime();
        int month = d.getMonth();
        System.out.println(month);          //7  begin from 0.
        int day = d.getDay();
        System.out.println(day);            //4...???..it is thursday...
        
        c.set(Calendar.YEAR, 1934);
        int year = c.getTime().getYear();
        System.out.println(year);           //if year<2000, getYear will return 34, the last two number of year
        
        int day2 = d.getDate();
        System.out.println(day2);           //this is the day!!!,,
    }

}
