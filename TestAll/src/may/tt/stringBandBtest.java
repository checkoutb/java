package may.tt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 */
public class stringBandBtest {

	/**
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer(5);
		StringBuffer sb3 = new StringBuffer("");
		
		System.out.println(sb.length() + " " + sb2.length() + " " + sb3.length());
		System.out.println(sb.capacity() + " " + sb2.capacity() + " " + sb3.capacity());
		
		
		String d = "2017-2-3";
		String dd = "2017-0002-6";
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMM");
		
		
		Date date = sdf.parse(d);
		System.out.println(date);
		date = sdf.parse(dd);
		System.out.println(date);
		date = sdf2.parse(d);
		System.out.println(date);
		date = sdf2.parse(dd);
		System.out.println(date);
		String ss = sdf2.format(date);
		System.out.println(ss);
		ss = sdf.format(date);
		System.out.println(ss);
		System.out.println(sdf3.format(date));
	}

}
