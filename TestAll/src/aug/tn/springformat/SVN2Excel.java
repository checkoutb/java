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
     * add��modify��delete�����¼
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        fromTxt();
    }
    
    
    
    //��Ҫÿ���ļ��ڸ������е���߰汾��������������߰汾
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void fromTxt()
    {
        String fname = "F:/daimagengxin.txt";
        File f = new File(fname);
        BufferedReader reader = null;
        Map maps = new HashMap<String, String>();
        
        //code Java�ļ���tag ����� log�汾
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
                
                //�����
//                matcher = pattern.matcher(temp);
//                if(matcher.find())
//                {
//                    tag = matcher.group();
//                }
                
                //�޸ĵ��ļ�
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
        String fname = "F:/��������Զ������һḲ��ͬ���ļ�.xlsx";
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
            //3.1,,12.11,,3.11����ֱ��subString..
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
            //3.1,,,3.10.,,,Double.valueOf����ת��3.1
            cell3.setCellValue(tag);
            
            i++;
        }
        
        row = sh.createRow(i++);
        cell2 = row.createCell(2);
        cell3 = row.createCell(3);
        //ͬһ��������ͬһ���ļ������۸��¼��Σ�ֻ��¼һ�Σ���¼����svn�޶��汾����
        cell2.setCellValue("��������(����Ҫ)(ͬһ��������ͬһ���ļ������۸��¼��Σ�ֻ��¼һ��)");
        cell3.setCellValue(maps.size());
        
        row = sh.createRow(i++);
        cell2 = row.createCell(2);
        cell3 = row.createCell(3);
        //��Ӱ����ļ���Ŀ����ʱ�������㶼��Ҫ��ͬһ���ļ���
        cell2.setCellValue("���ļ���(��������9999)(��ʱ�������㶼��Ҫ��ͬһ���ļ���)");
        cell3.setCellValue(sets.size());;
        
        row = sh.createRow(i++);
        cell2 = row.createCell(2);
        cell3 = row.createCell(3);
        //ͬһ��������ͬһ���ļ������¼��ξ��м���
        cell2.setCellValue("�ܸ�����(ͬһ��������ͬһ���ļ������¼��ξ��м���)");
        cell3.setCellValue(num);
        
        FileOutputStream out = new FileOutputStream(fname);
        workbook.write(out);
        out.close();
        System.out.print("Done");
    }
}
