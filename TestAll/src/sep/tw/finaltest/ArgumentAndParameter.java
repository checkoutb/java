package sep.tw.finaltest;

public class ArgumentAndParameter {

    private int a;
    
    
    public static void main(String[] args) {

        ArgumentAndParameter a1 = new ArgumentAndParameter();
        a1.setA(3);
        System.out.println(a1.getA());          //3
        change(a1);
        System.out.println(a1.getA());          //5555
    }
    
    public static void change(ArgumentAndParameter aaa)
    {
        aaa.setA(5555);
    }


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

}
