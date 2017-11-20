package nov.fot.genericinterface;

public class Test {

    public static void main(String[] args) {
        
        ThirdImpl thi = new ThirdImpl();
        
        System.out.println(thi instanceof ThirdImpl);
        System.out.println(thi instanceof Third);
        System.out.println(thi instanceof Second);
        System.out.println(thi instanceof First);
        System.out.println(thi instanceof Second2);
//        System.out.println(thi instanceof );
        
        abstractIn a = new AbstaractIn();
        a.setA(4);
//        assert(4 == a.getA());
//        assert(4 != a.getA());
        System.out.println(a.getA());
    }

}
