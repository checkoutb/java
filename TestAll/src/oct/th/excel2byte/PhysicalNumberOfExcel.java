package oct.th.excel2byte;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class PhysicalNumberOfExcel {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub

        String f = "F:/副本.xls";
        
        HSSFWorkbook hw = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(f)));
        
        HSSFSheet sh = hw.getSheet("记账规则");
        
        System.out.println(sh.getPhysicalNumberOfRows());
        
        
        Date date = new Date("2000/1/1");
        System.out.println(date);
        
        
        FileInputStream fis = new FileInputStream(f);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        int c = bis.read();
        while(c!=-1)
        {
            baos.write(c);
            c = bis.read();
        }
        bis.close();
        
        byte[] retArr = baos.toByteArray();
//        System.out.println(retArr);               //??
        System.out.println(retArr.length);
        
        
        Date ddd = new Date();
        System.out.println(ddd);            //windows 的时间
    }

}
