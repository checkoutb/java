package sep.fi.propertyutiles;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;

public class PropertyUtilsTest {

    public static void main(String[] args) {
        
        TestT tt = new TestT();
//        Test tt = new Test();         //内部类不能用。。不知道为什么
        tt.setA("aa");
        tt.getA();
        
        try {
            PropertyUtils.setSimpleProperty(tt, "a", "zxcv");
            PropertyUtils.setSimpleProperty(tt, "b", 3);
            
            
            //..
            PropertyUtils.setSimpleProperty(tt, "a", "mn");
            
            
            
            //list
            List<String> list1 = new ArrayList<>();
            list1.add("abc");
            list1.add("qwe");
            tt.setList(list1);
//            PropertyUtils.setSimpleProperty(tt, "list", list);
            PropertyUtils.setIndexedProperty(tt, "list[1]", "fgj");
            
            
            //array
            int[] arr = {1,2,3,4,5};
//            tt.setArray(arr);
            PropertyUtils.setSimpleProperty(tt, "array", arr);
            PropertyUtils.setIndexedProperty(tt, "array[2]", 11);
            
            
            
            //set
            Set<String> set1 = new HashSet<>();
            set1.add("mmm");
            set1.add("rrr");
            tt.setSet(set1);
//            PropertyUtils.setSimpleProperty(tt, "set", set);
//            PropertyUtils.setIndexedProperty(tt, "set[0]", "zzz");            //illegalArgument
            
            
            
            //map
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("111", 1);
            map1.put("222", 2);
//            tt.setMap(map1);
            PropertyUtils.setSimpleProperty(tt, "map", map1);       //
            PropertyUtils.setMappedProperty(tt, "map", "111", 11);
//            PropertyUtils.setMappedProperty(tt, "map(222)", "map(222) 22");       //222=map(222) 22....and map is Map<String, Integer>
            PropertyUtils.setMappedProperty(tt, "map(222)", "222");         // 不会测试类型是否匹配，可能保存的是Map<Object, Object>，那就要自己转换了啊。
            
            
            
            //nested  嵌套，类作为属性
            Sub sub2 = new Sub();
            sub2.setName("aaa");
//            tt.setSub(sub2);
            PropertyUtils.setSimpleProperty(tt, "sub", sub2);
            PropertyUtils.setNestedProperty(tt, "sub.name", "vvv");
            
            
            
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
            String a = (String) PropertyUtils.getSimpleProperty(tt, "a");
            System.out.println(a);
            
            //list
            System.out.println(PropertyUtils.getSimpleProperty(tt, "list"));
            System.out.println(PropertyUtils.getIndexedProperty(tt, "list[0]"));
            System.out.println(PropertyUtils.getIndexedProperty(tt, "list", 1));
            
            //set
            System.out.println(PropertyUtils.getSimpleProperty(tt, "set"));
//            System.out.println(PropertyUtils.getIndexedProperty(tt, ));
//            System.out.println();
            
            //array
            System.out.println(PropertyUtils.getSimpleProperty(tt, "array"));
            System.out.println(PropertyUtils.getIndexedProperty(tt, "array[0]"));
            System.out.println(PropertyUtils.getIndexedProperty(tt, "array", 1));
            
            //map
            System.out.println(PropertyUtils.getSimpleProperty(tt, "map"));             // 222=map(222) 22, 111=11
            System.out.println(PropertyUtils.getMappedProperty(tt, "map(111)"));        // 11
            System.out.println(PropertyUtils.getMappedProperty(tt, "map", "222"));      //...print  map(222) 22   ???...set wrong...
            
            
            //nested
            System.out.println(PropertyUtils.getSimpleProperty(tt, "sub"));
            System.out.println(PropertyUtils.getNestedProperty(tt, "sub.name"));
            
            
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
    }

}



class Test
{
    private Sup sup;
    private String a;
    private int b;
    private float c;
    private boolean d;
    /**
     * @return the sup
     */
    public Sup getSup() {
        return sup;
    }
    /**
     * @param sup the sup to set
     */
    public void setSup(Sup sup) {
        this.sup = sup;
    }
    /**
     * @return the a
     */
    public String getA() {
        return a;
    }
    /**
     * @param a the a to set
     */
    public void setA(String a) {
        this.a = a;
    }
    /**
     * @return the b
     */
    public int getB() {
        return b;
    }
    /**
     * @param b the b to set
     */
    public void setB(int b) {
        this.b = b;
    }
    /**
     * @return the c
     */
    public float getC() {
        return c;
    }
    /**
     * @param c the c to set
     */
    public void setC(float c) {
        this.c = c;
    }
    /**
     * @return the d
     */
    public boolean isD() {
        return d;
    }
    /**
     * @param d the d to set
     */
    public void setD(boolean d) {
        this.d = d;
    }
    
}


class Sup
{
    private String a;
    private int b;
    private float c;
    /**
     * @return the a
     */
    public String getA() {
        return a;
    }
    /**
     * @param a the a to set
     */
    public void setA(String a) {
        this.a = a;
    }
    /**
     * @return the b
     */
    public int getB() {
        return b;
    }
    /**
     * @param b the b to set
     */
    public void setB(int b) {
        this.b = b;
    }
    /**
     * @return the c
     */
    public float getC() {
        return c;
    }
    /**
     * @param c the c to set
     */
    public void setC(float c) {
        this.c = c;
    }
    
}