package nov.six;

import java.io.UnsupportedEncodingException;

public class String2byteArray {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub

        String s = "asdasd";
        byte[] byteArr = s.getBytes();
        
        System.out.println(s.length() + ", " + byteArr.length);
        
        byteArr = s.getBytes("UTF-8");
        System.out.println(byteArr.length);
        
        s = "Œ“Œ“Œ“asd";
        byteArr = s.getBytes();
        System.out.println(byteArr.length);
        
        byteArr = s.getBytes("UTF-8");
        System.out.println(byteArr.length);
    }

}
