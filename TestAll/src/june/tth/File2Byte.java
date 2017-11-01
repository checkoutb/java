package june.tth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 */
public class File2Byte {

	/**
	 */
	public static void main(String[] args) {
		String file = "f:\\daimagengxin.txt";
		String outfile = "f:/test.txt";
		FileInputStream fi = null;
		FileOutputStream fo = null;
		byte[] b = null;
		try {
//			FileInputStream fi = new FileInputStream(new File(file));
//			Long len = new File(file).length();
			
			File f = new File(file);
			fi = new FileInputStream(f);
			long len = f.length();
			if(len > Integer.MAX_VALUE)
			{
				System.out.println("tooooo biiiiiiiig");
//				return null;
			}
			b = new byte[(int) len];
			int length = fi.read(b);
			System.out.println(length);
//			for(byte b1 : b)
//			{
//				System.out.print(b1 + ",");
//			}
			
			fo = new FileOutputStream(new File(outfile), true);
			int offset = 1;
			fo.write(b, offset, (int)len-offset);		//第二个形参的是第一个形参的偏移量。所以len要改。
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		finally
		{
			try {
				fi.close();
				fo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int a()
	{
		return 3;
	}
}
