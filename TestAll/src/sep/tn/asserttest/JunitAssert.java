package sep.tn.asserttest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

public class JunitAssert {

    
//    @Ignore
    @Test
    public void assertTest()
    {
        int a = 4;
        int b = 4;
        int c = 3;
        String s = null;
        
        String s1 = "asd";
        String s2 = "asd";
        
        assertTrue(a==b);
//        assertFalse(a==b);
        
        assertNull(s);
//        assertNotNull(s);
        
//        fail("msg : fail");
        
//        assertEquals("error of it", 4, c);      // error of it excepted:<4> but was:<3>
        assertEquals(4, a);
        
//        assertNotSame("not same", s1, s2);        // ，s1，s2是两个 类变量， 里面保存的是 来自一个常量的。
        
//        failNotSame("must", s1, s2);      // private
        
//        assertNotSame("not same", s1.intern(), s2.intern());        //当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 才为 true。 

        assertEquals(s1, s2);
    
    
    }
}
