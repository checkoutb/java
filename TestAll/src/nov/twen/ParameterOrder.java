package nov.twen;

public class ParameterOrder {

    private int a;
    
    private int b;
    
    private int c;
    
    private int d;
    
    private static int s = 0;
    
    public static void main(String[] args) {
        
        ParameterOrder order = new ParameterOrder();
        order.setA(5);
        order.setB(6);
        order.setC(7);
        order.setD(1);
        
        order.testZ(order.getS("a"), order.getS("b"), order.getS("c"), order.getS("d"));
        testA(order.getS("a"), order.getS("b"), order.getS("c"), order.getS("d"));
        
        int qw = 1;
        int qs = 1;
        order.testQ(qw++, ++qs, qs++, ++qs);                // 执行范围 是 以,分割的吧？，这个输出 1，2，2，4.说明是正序执行，且碰到,，就会把++给实现。
        System.out.println(qw + ", " + qs);
    }

    public void testQ(int a, int b, int c, int d)
    {
        System.out.println(a + ", " + b + ", " + c + ", " + d);
    }
    
    public void testZ(int a, int b, int c, int d)
    {
        
    }
    
    public static void testA(int a, int b, int c, int d)
    {
        
    }
    
    public int getS(String a)
    {
        
        s++;
        System.out.println(a + ", " + s);
        return s;
    }
    
    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * @return the b
     */
    public int getB() {
        return b;
    }

    /**
     * @return the c
     */
    public int getC() {
        return c;
    }

    /**
     * @return the d
     */
    public int getD() {
        return d;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * @param b the b to set
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * @param c the c to set
     */
    public void setC(int c) {
        this.c = c;
    }

    /**
     * @param d the d to set
     */
    public void setD(int d) {
        this.d = d;
    }

    
    
}
