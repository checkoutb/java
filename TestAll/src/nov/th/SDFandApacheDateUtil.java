package nov.th;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SDFandApacheDateUtil {

    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub

        Date start = new Date("2016/5/5");
        Date end = new Date("2017/3/3");
        
        String dateS = "20160101";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        
        start =sdf.parse(dateS);
        
//        dateS = "2016/4/2";                   //ParseException. Unparseable date
        end = sdf.parse(dateS);
        
        System.out.println(start + ",\n" + end);
        
//        DateUtils.addDa
    }

}
