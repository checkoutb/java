package sep.fi.stringbuffer;

public class FunChangeSB {

    public static void main(String[] args) {

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        
        plus(a, b);
        
        System.out.println(a + ", " + b);
        
    }
    
    public static void plus(StringBuffer a, StringBuffer b)
    {
        a.append(b);
        b = a;              //debug 看到这步以后a和b 的id是一样的，将a赋给了b
    }

}
