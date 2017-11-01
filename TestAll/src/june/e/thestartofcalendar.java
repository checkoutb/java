package june.e;

import java.util.Calendar;
import java.util.Date;

/**
 */
public class thestartofcalendar {

	/**
	 */
	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		Date d = c.getTime();
		System.out.println(d);
		
		d = new Date();
		System.out.println(d);
	}

}
