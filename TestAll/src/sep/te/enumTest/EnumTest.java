package sep.te.enumTest;

import java.util.EnumMap;
import java.util.EnumSet;

import org.junit.Ignore;
import org.junit.Test;

public class EnumTest {

    
    
    
    
    @Ignore
    @Test
    public void EnumSetEnumMapTest()
    {
        // java.util.EnumMap
        EnumMap<EE2, String> enumMap = new EnumMap<EE2, String>(EE2.class);     //EnumMap的构造器的参数是key域的类
        
        enumMap.put(EE2.OK, "aaoka");
        enumMap.put(EE2.Exception, "exccc");
        
        for(EE2 e : EE2.values())
        {
            System.out.println("key:" + e.name() + ", value:" + enumMap.get(e));
        }
        
        System.out.println("\n\n");
        
        EnumSet<EE2> set = EnumSet.allOf(EE2.class);
        for(EE2 e : set)
        {
            System.out.println(e);
        }
    }
    
    
    @Ignore
    @Test
    public void enumSwitchTest()
    {
//        EE2 e = EE2.OK;
        EE e = EE.OK;
        switch(e)
        {
        case OK:
            System.out.println("aa");
            break;
        case Error:
            System.out.println("zzz");
            break;
        }
    }
    
    
    @Ignore
    @Test
    public void enumEETest()
    {
        EE e = EE.OK;
        System.out.println(e.getDeclaringClass().getName());            //EE 这个枚举的包名+枚举类名
        System.out.println(e.name());       //OK
        System.out.println(e.ordinal());    //0
        
        e = EE.Error;
        System.out.println(e.getDeclaringClass().getName());
        System.out.println(e.name());   //Error
        System.out.println(e.ordinal());        //1
        System.out.println(e.toString());   //Error
    }
    
    
    @Ignore
    @Test
    public void enumEE2Test()
    {
        // ca,ee2没有修改父类的方法，和父类的构造器。
        EE2 e = EE2.OK;
        
        System.out.println(e.getDeclaringClass().getName());            //EE 这个枚举的包名+枚举类名
        System.out.println(e.name());       //OK
        System.out.println(e.ordinal());    //0
        System.out.println(e.getValue());
        
        e = EE2.Error;
        System.out.println(e.getDeclaringClass().getName());
        System.out.println(e.name());   //Error
        System.out.println(e.ordinal());        //1
        System.out.println(e.toString());   //Error
        System.out.println(e.getValue());
    }
}
