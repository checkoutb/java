package june.f;

import java.util.Calendar;
import java.util.Date;

/**
 */
public class StartsWithA {

	/**
	 */
	public static void main(String[] args) {
		/*String s = "asd";
		
		System.out.println("asasdad".startsWith(s,2) ? true : false);*/
		
		
		Calendar c = Calendar.getInstance();
//		System.out.println(c);
		Date d = new Date();
		c.setTime(d);
		c.set(Calendar.DAY_OF_MONTH ,16);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		System.out.println(c.get(Calendar.MINUTE));
	}

}
