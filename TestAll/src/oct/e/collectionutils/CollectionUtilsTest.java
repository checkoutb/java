package oct.e.collectionutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;

public class CollectionUtilsTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

//        List<String> sList = new LinkedList<>();
        
        String a[] = {"asd", "zxc", "qwe", "fgh", "asd"};          //声明+初始化 才能用
        List<String> sList = Arrays.asList(a);
        
        String t;
        
        Iterator<String> it = sList.iterator();
        while(it.hasNext())
        {
            t = (String) it.next();
            System.out.print(t + ", ");
//            System.out.print(it.next());
        }
        System.out.println();
        
//        for(it = sList.iterator(); it.hasNext();)
//        {
//            System.out.print(it.next() + ". ");
//        }
//        System.out.println();
        
        a = new String[]{"asd", "123", "345"};
        
//        for(int i = 0; i < a.length; i++)
//        {
//            System.out.print(a[i] + ", ");
//        }
        
        List<String> sList2 = Arrays.asList(new String[]{"asd", "123", "456",});
        for(int i = 0; i < sList2.size(); i++)
        {
            System.out.print(sList2.get(i) + ", ");
        }
        System.out.println();
        
        
        
        
        List<String> sList3 = (List<String>) CollectionUtils.union(sList, sList2);          //两者相加，重复的变成一个。 并集，，这个只是2个重复的变成1个，如果有3个重复的，那么会返回2个，只减少1个,4个重复的变成2个
        show(sList3);
        
        sList3 = (List<String>) CollectionUtils.intersection(sList, sList2);            //交集，也不是真的并集，只是两个重复的并成一个，如果有4个相同的，那么会返回2个相同的。
        show(sList3);
        System.out.println(sList3.size());
        
        sList3 = (List<String>) CollectionUtils.disjunction(sList, sList2);             //析取,,好像这个才是真正的并集？
        show(sList3);
        
        sList3 = (List<String>) CollectionUtils.subtract(sList, sList2);        //减去，有相同的变成一个，如果前者有2个相同的，后者只有1个，，那么会返回1个的(只减去了一个)。
        show(sList3);
        
        System.out.println(CollectionUtils.containsAny(sList, sList2));         //有交集
        sList3.clear();
        sList3.add("999mmm");
        System.out.println(CollectionUtils.containsAny(sList, sList3));
        

        Map map = CollectionUtils.getCardinalityMap(sList);         //.。。以Collection的节点值为key，拥有相同值的节点个数 为value的map。
        Set<Map.Entry<Object, Object>> entrySet = map.entrySet(); 
        for(Map.Entry<Object, Object> entry : entrySet)
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        
        System.out.println(CollectionUtils.isSubCollection(sList, sList3));     //前者 是后者的 一个子集，，可以是自己，
                                                        //要看注释，，好像是前者含有的值 后者都有(子集)，&&前者的每个值的个数 <= 后者的每个值的个数。
        sList3.clear();
        System.out.println(CollectionUtils.isSubCollection(sList, sList3));
        System.out.println(CollectionUtils.isSubCollection(sList3, sList));
        System.out.println(CollectionUtils.isSubCollection(sList, sList));
        
        System.out.println();
        System.out.println(CollectionUtils.isProperSubCollection(sList, sList));
        System.out.println(CollectionUtils.isProperSubCollection(sList3, sList));       //前者是后者的一个真子集
                                            //前者含有的值后者都有 且 ( 后者存在前者没有的值，或，前者存在一个值的个数<后者的这个值的个数 )
        sList3.addAll(sList);
        sList3.remove(0);
        System.out.println(CollectionUtils.isProperSubCollection(sList3, sList));
        
        
        System.out.println();
        System.out.println(CollectionUtils.isEqualCollection(sList3, sList3));      //值+值的个数 完全想等。
        sList3.clear();
        sList3.addAll(sList);
        System.out.println(CollectionUtils.isEqualCollection(sList3, sList));
        sList3.remove(0);
        System.out.println(CollectionUtils.isEqualCollection(sList3, sList));
        
        
        System.out.println();
        System.out.println(CollectionUtils.cardinality("asd", sList));          //common-collections  和 common-collections4 的区别。项目是前者，testAll是后者
                                //返回Collection中值为"asd"的个数
        
        
//        System.out.println("\n" + CollectionUtils.find(sList, "asd"));            //两个jar差别有点大啊。。。好像是根据正则/Predicate来匹配，返回第一个匹配的
                                                                        //predicate 这个类很吊的，
        
        //。。参考
        // https://www.2cto.com/kf/201505/401081.html
        //predicate 类在上面的页面中有一定的展示。很吊
        
        /*
        void forAllDo(Collection collection, Closure closure)
        对collection的每个节点都做closure类的execute()。这个类+方法可以/要自己定义的。
        
        
        void filter(Collection collection, Predicate predicate)
        不满足Predicate的就remove
        
        void transform(Collection collection, Transformer transformer)
        怎么觉得和forAllDo是一样的，都是对collection中每个节点做transformer的transform方法。。
        
        int countMatches(Collection inputCollection, Predicate predicate)
        匹配的个数
        
        
        boolean exists(Collection collection, Predicate predicate)
        
        Collection select(Collection inputCollection, Predicate predicate)
        根据正则匹配来获得新的集合。
        
        void select(Collection inputCollection, Predicate predicate, Collection outputCollection)
        
        Collection selectRejected(Collection inputCollection, Predicate predicate)
        获得不匹配的
        
        void selectRejected(Collection inputCollection, Predicate predicate, Collection outputCollection)
        
        
        Collection collect(Collection inputCollection, Transformer transformer)
        
        Collection collect(Iterator inputIterator, Transformer transformer) 
        
        Collection collect(Collection inputCollection, final Transformer transformer, final Collection outputCollection)
        
        
        
        */
        /*
        ...太多了，挑几个。
        
        boolean addIgnoreNull(Collection collection, Object object)
        如果null，不加进去。非null，加进去
        
        void addAll(Collection collection, Iterator iterator)
        
        
        Object index(Iterator iterator, int idx)
        
        Object get(Object object, int index)
        
        int size(Object object)
        
        boolean isEmpty(Collection coll)
        null,或空 返回true
        
        boolean isNotEmpty(Collection coll)
        !isEmpty
        
        
        reverseArray(Object[] array)
        
        
        boolean isFull(Collection coll)
        
        int maxSize(Collection coll)
        
        common-collection  有问题吧。还是反编译的问题？，有问题，在common-collection4中 就改掉了，retain调用retain，，remove调用remove
        public static Collection retainAll(Collection collection, Collection retain) {
            return ListUtils.retainAll(collection, retain);
        }
        public static Collection removeAll(Collection collection, Collection remove) {
            return ListUtils.retainAll(collection, remove);
        }
        。。。这两个方法明显是相反的，一个是两者的交，一个是补？
        
         */
        
        
        
        
//        ListUtils.emptyIfNull(list)
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //...md,还有  ListUtils。。肯定还有Map Set Utils....
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    public static void show(Collection<?> c)        //buenng Collection<>
    {
        Object obj[] = c.toArray();
        String[] ss = new String[]{};
        String[] s2 = c.toArray(ss);        //...
        
//        for(int i = 0; i < c.size(); i++)     //一个输出就可以了，这个也是可以的。
//        {
////            System.out.print(ss[i] + "; ");       // ss 并没有被赋予Collection中的值。
//            System.out.print(s2[i] + "..");
//        }
        
        
        for(int i = 0; i < c.size(); i++)
        {
            System.out.print(obj[i] + ", ");
        }
        System.out.println();
    }
}
