package june.t;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 */
public class findFunction4mJQ {

	/**
	 */
	public static void main(String[] args) {
		
		int n = 0;		//number of line
		int nn = 0;		//number of function
		String f = "F:/wobang/firefox_download/jquery-3.2.1.js";
//		String fo = "F:/wobang/1111/eee/private/jquery.txt";
		File file = new File(f);
		String s = null;
//		Pattern p = Pattern.compile("");
		
		try {
			BufferedReader r = new BufferedReader(new FileReader(file));
//			BufferedWriter w = new BufferedWriter(new FileWriter(new File(fo)));
			while((s=r.readLine()) != null)
			{
				n++;
				if(s.matches("^[^ 	].*(unction)+.*"))
				{
					nn++;
					System.err.println(nn + " " + n + " " + s);
//					w.write(n + " " + s + "\n");
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			System.out.println("done");
		}

	}

}
