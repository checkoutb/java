package july.to;


public class XingCanTestTest {

    private int a;
    
    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {

        XingCanTestTest xx = new XingCanTestTest();
        xx.setA(4);
        xx.fun1(xx);
        System.err.println(xx.getA());
    }
    
    public void fun1(XingCanTestTest c)
    {
        c.setA(400);
    }

}
