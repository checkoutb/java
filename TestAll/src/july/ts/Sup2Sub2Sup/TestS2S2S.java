package july.ts.Sup2Sub2Sup;


public class TestS2S2S {


    public static void main(String[] args) {

        
        Sub b = new Sub();
        b.setA(111);
        b.setB(222);
        
        Sup p = b;
        Sub c = (Sub)p;
        
        System.out.println(c.getA() + " " + c.getB());
        print(p);
    }
    
    public static void print(Sup p)
    {
        Sub b = (Sub)p;
        System.out.println(b.getA() + " " + b.getB());
    }

}
