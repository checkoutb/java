package nov.sixt;

import java.sql.Timestamp;
import java.util.Date;

public class SubAndStampDate extends Super {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("sssss");
        
        SubAndStampDate ddd = new SubAndStampDate();
        
        System.out.println("eeeee");
        
        
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        
        System.out.println(ts);
        
        Date date = ts;
        System.out.println(date);
        
        date = new Date();
        System.out.println(date);
    }

    public SubAndStampDate()
    {
        System.out.println("sssssbbbbbuuuuu");
    }
}
