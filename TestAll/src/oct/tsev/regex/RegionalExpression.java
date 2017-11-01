package oct.tsev.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegionalExpression {

    public static void main(String[] args) {

        String regEx1 = "[0-9]+\\.[0-9]+";
        Pattern p1 = Pattern.compile(regEx1);
        
        String aim = "1.2.3.4.5.6.7.8.9";
        String r = null;
        
        Matcher match1 = p1.matcher(aim);
        if(match1.find())
        {
            r = match1.group();
            System.out.println(r);
        }
        
    }

}
