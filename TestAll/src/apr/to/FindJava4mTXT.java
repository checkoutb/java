package apr.to;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FindJava4mTXT {

	/**
	 * add，modify，delete都会记录
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		fromTxt();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void fromTxt()
	{
		String fname = "F:/changename.txt";
		File f = new File(fname);
		BufferedReader reader = null;
	/*	Map maps = new HashMap<String, String>();
		String code = "null1";
		String tag = "null2";
		String log = "0000";
		String regEx3 = "Revision: [0-9]+";
		Pattern pattern3 = Pattern.compile(regEx3);
		String regEx = "[0-9]+\\.[0-9]+";
		Pattern pattern = Pattern.compile(regEx);
		String regEx2 = "[^/][a-zA-Z-_\\.]+\\.(java|native|properties|xml)";
		Pattern pattern2 = Pattern.compile(regEx2);
		String tagcode = null;*/
		int num = 0;
		
		String regEx = "[^/][a-zA-Z-_\\.]+\\.java";
		Pattern pattern = Pattern.compile(regEx);
		String regEx2 = "[0-9]+,*[0-9]+:";
		Pattern pattern2 = Pattern.compile(regEx2);
		
		String temp = null;
		Matcher matcher = null;
//		HashSet<String> jname = new HashSet();
		List<String> ljava = new ArrayList<String>();
		
		try
		{
			reader = new BufferedReader(new FileReader(f));
			
			while((temp = reader.readLine()) != null)
			{
				matcher = pattern.matcher(temp);
				if(matcher.find())
				{
					ljava.add(matcher.group());
				}
				
				matcher = pattern2.matcher(temp);
				if(matcher.find())
				{
					ljava.add(matcher.group());
				}
			}
			
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		toExcel(ljava);
		
		
	}
	
	
	public static void toExcel(List<String> l)
	{
		String fname = "F:/java创建覆盖同名.xlsx";
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sh = workbook.createSheet();
		sh.setColumnWidth(2, 18000);
		
		XSSFRow row = null;
		XSSFCell cell1 = null;
//		XSSFCell cell2 = null;
//		XSSFCell cell3 = null;
		String str2 = null;
		int v = 0;

		int i = 1;
		for(String str : l)
		{
			str2 = str;
			if(str.length() < 7)
			{
				str2 = str.substring(0, str.length()-1);
				
//				if(str.length() > 4)
				{
//					System.out.print("222");
//					str2 = str.substring(0, str.length()-5) + str.substring(str.length()-4, str.length()-1);
				}
//				v = Integer.valueOf(str2);
			}
			row = sh.createRow(i);
			cell1 = row.createCell(2);
//			cell2 = row.createCell(2);
//			cell3 = row.createCell(4);
			
			cell1.setCellValue(str2);
//			cell2.setCellValue(code);
//			cell3.setCellValue(tag);
			
			i++;
		}
		
		FileOutputStream out;
		try {
			out = new FileOutputStream(fname);
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Done");
		
	}
	
	
	public static void toExcel(HashSet<String> s) throws IOException
	{
		String fname = "F:/java创建覆盖同名.xlsx";
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sh = workbook.createSheet();
		sh.setColumnWidth(2, 18000);
		
		XSSFRow row = null;
		XSSFCell cell1 = null;
//		XSSFCell cell2 = null;
//		XSSFCell cell3 = null;
		
		int i = 1;
		for(String str : s)
		{
			row = sh.createRow(i);
			cell1 = row.createCell(2);
//			cell2 = row.createCell(2);
//			cell3 = row.createCell(4);
			
			cell1.setCellValue(str);
//			cell2.setCellValue(code);
//			cell3.setCellValue(tag);
			
			i++;
		}
		
		FileOutputStream out = new FileOutputStream(fname);
		workbook.write(out);
		out.close();
		System.out.print("Done");
	}
	
}

