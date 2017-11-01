package aug.tn.springformat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 */
public class SVN2Excel {

    /**
     * add，modify，delete都会记录
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        fromTxt();
    }
    
    
    
    //需要每个文件在该需求中的最高版本，不是需求点的最高版本
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void fromTxt()
    {
        String fname = "F:/daimagengxin.txt";
        File f = new File(fname);
        BufferedReader reader = null;
        Map maps = new HashMap<String, String>();
        
        //code Java文件，tag 需求点 log版本
        String code = "null1";
        String tag = "null2";
        String log = "0000";
        String regEx3 = "Revision: [0-9]+";
        Pattern pattern3 = Pattern.compile(regEx3);
        String regEx = "[0-9]+\\.[0-9]+";
        Pattern pattern = Pattern.compile(regEx);
        String regEx2 = "[^/][a-zA-Z0-9_\\.\\-]+\\.(java|native|properties|xml|jsp)";
        Pattern pattern2 = Pattern.compile(regEx2);
        String tagcode = null;
        int num = 0;
        try
        {
            reader = new BufferedReader(new FileReader(f));
            String temp = null;
            String logg = null;
            
            while((temp = reader.readLine()) != null)
            {
                Matcher matcher = pattern3.matcher(temp);
                if(matcher.find())
                {
                    log = matcher.group();
                    log = log.substring(10);
                }
                
                //需求点
//                matcher = pattern.matcher(temp);
//                if(matcher.find())
//                {
//                    tag = matcher.group();
//                }
                
                //修改的文件
                matcher = pattern2.matcher(temp);
                if(matcher.find())
                {
                    num++;
                    code = matcher.group();
                    
//                    tagcode = tag + code;
                    tagcode = code;
                    if(maps.containsKey(tagcode))
                    {
                        logg = (String) maps.get(tagcode);
                        if((Double.valueOf(log) - Double.valueOf(logg)) > 0.001)
                        {
                            maps.put(tagcode, log);
                        }
                    }
                    else
                    {
                        maps.put(tagcode, log);
                    }
                }
            }
            System.out.println(maps.size());
            try {
                toExcel((HashMap<String, String>)maps, num);
            } catch (EncryptedDocumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("resource")
    public static void toExcel(HashMap<String, String> maps, int num) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
    {
        
        String log = null;
        String code = null;
        String tag = null;
        String fname = "F:/代码更新自动创建且会覆盖同名文件.xlsx";
        Set<String> sets = new HashSet<String>();
        
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sh = workbook.createSheet();
        sh.setColumnWidth(2, 18000);
        
        String regEx = "[0-9]+\\.[0-9]+";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = null;
        
        XSSFRow row = null;
        XSSFCell cell1 = null;
        XSSFCell cell2 = null;
        XSSFCell cell3 = null;
        int i = 1;
        for(String tc : maps.keySet())
        {
            //3.1,,12.11,,3.11不能直接subString..
            matcher = pattern.matcher(tc);
            if(matcher.find())
            {
                tag = matcher.group();
                code = tc.substring(tag.length());
            }
            else
            {
                tag = "9999";
                code = tc;
            }
            sets.add(code);
            log = maps.get(tc);
            
            row = sh.createRow(i);
            cell1 = row.createCell(3);
            cell2 = row.createCell(2);
            cell3 = row.createCell(4);
            
            cell1.setCellValue(Integer.valueOf(log));
            cell2.setCellValue(code);
            //3.1,,,3.10.,,,Double.valueOf都会转成3.1
            cell3.setCellValue(tag);
            
            i++;
        }
        
        row = sh.createRow(i++);
        cell2 = row.createCell(2);
        cell3 = row.createCell(3);
        //同一个需求点的同一个文件，无论更新几次，只记录一次，记录的是svn修订版本最大的
        cell2.setCellValue("数据条数(不需要)(同一个需求点的同一个文件，无论更新几次，只记录一次)");
        cell3.setCellValue(maps.size());
        
        row = sh.createRow(i++);
        cell2 = row.createCell(2);
        cell3 = row.createCell(3);
        //受影响的文件数目，有时多个需求点都是要改同一个文件的
        cell2.setCellValue("总文件数(包含需求9999)(有时多个需求点都是要改同一个文件的)");
        cell3.setCellValue(sets.size());;
        
        row = sh.createRow(i++);
        cell2 = row.createCell(2);
        cell3 = row.createCell(3);
        //同一个需求点的同一个文件，更新几次就有几次
        cell2.setCellValue("总更新数(同一个需求点的同一个文件，更新几次就有几次)");
        cell3.setCellValue(num);
        
        FileOutputStream out = new FileOutputStream(fname);
        workbook.write(out);
        out.close();
        System.out.print("Done");
    }
}
