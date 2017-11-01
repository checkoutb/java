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
        
        String a[] = {"asd", "zxc", "qwe", "fgh", "asd"};          //����+��ʼ�� ������
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
        
        
        
        
        List<String> sList3 = (List<String>) CollectionUtils.union(sList, sList2);          //������ӣ��ظ��ı��һ���� �����������ֻ��2���ظ��ı��1���������3���ظ��ģ���ô�᷵��2����ֻ����1��,4���ظ��ı��2��
        show(sList3);
        
        sList3 = (List<String>) CollectionUtils.intersection(sList, sList2);            //������Ҳ������Ĳ�����ֻ�������ظ��Ĳ���һ���������4����ͬ�ģ���ô�᷵��2����ͬ�ġ�
        show(sList3);
        System.out.println(sList3.size());
        
        sList3 = (List<String>) CollectionUtils.disjunction(sList, sList2);             //��ȡ,,����������������Ĳ�����
        show(sList3);
        
        sList3 = (List<String>) CollectionUtils.subtract(sList, sList2);        //��ȥ������ͬ�ı��һ�������ǰ����2����ͬ�ģ�����ֻ��1��������ô�᷵��1����(ֻ��ȥ��һ��)��
        show(sList3);
        
        System.out.println(CollectionUtils.containsAny(sList, sList2));         //�н���
        sList3.clear();
        sList3.add("999mmm");
        System.out.println(CollectionUtils.containsAny(sList, sList3));
        

        Map map = CollectionUtils.getCardinalityMap(sList);         //.������Collection�Ľڵ�ֵΪkey��ӵ����ֵͬ�Ľڵ���� Ϊvalue��map��
        Set<Map.Entry<Object, Object>> entrySet = map.entrySet(); 
        for(Map.Entry<Object, Object> entry : entrySet)
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        
        System.out.println(CollectionUtils.isSubCollection(sList, sList3));     //ǰ�� �Ǻ��ߵ� һ���Ӽ������������Լ���
                                                        //Ҫ��ע�ͣ���������ǰ�ߺ��е�ֵ ���߶���(�Ӽ�)��&&ǰ�ߵ�ÿ��ֵ�ĸ��� <= ���ߵ�ÿ��ֵ�ĸ�����
        sList3.clear();
        System.out.println(CollectionUtils.isSubCollection(sList, sList3));
        System.out.println(CollectionUtils.isSubCollection(sList3, sList));
        System.out.println(CollectionUtils.isSubCollection(sList, sList));
        
        System.out.println();
        System.out.println(CollectionUtils.isProperSubCollection(sList, sList));
        System.out.println(CollectionUtils.isProperSubCollection(sList3, sList));       //ǰ���Ǻ��ߵ�һ�����Ӽ�
                                            //ǰ�ߺ��е�ֵ���߶��� �� ( ���ߴ���ǰ��û�е�ֵ����ǰ�ߴ���һ��ֵ�ĸ���<���ߵ����ֵ�ĸ��� )
        sList3.addAll(sList);
        sList3.remove(0);
        System.out.println(CollectionUtils.isProperSubCollection(sList3, sList));
        
        
        System.out.println();
        System.out.println(CollectionUtils.isEqualCollection(sList3, sList3));      //ֵ+ֵ�ĸ��� ��ȫ��ȡ�
        sList3.clear();
        sList3.addAll(sList);
        System.out.println(CollectionUtils.isEqualCollection(sList3, sList));
        sList3.remove(0);
        System.out.println(CollectionUtils.isEqualCollection(sList3, sList));
        
        
        System.out.println();
        System.out.println(CollectionUtils.cardinality("asd", sList));          //common-collections  �� common-collections4 ��������Ŀ��ǰ�ߣ�testAll�Ǻ���
                                //����Collection��ֵΪ"asd"�ĸ���
        
        
//        System.out.println("\n" + CollectionUtils.find(sList, "asd"));            //����jar����е�󰡡����������Ǹ�������/Predicate��ƥ�䣬���ص�һ��ƥ���
                                                                        //predicate �����ܵ��ģ�
        
        //�����ο�
        // https://www.2cto.com/kf/201505/401081.html
        //predicate ���������ҳ������һ����չʾ���ܵ�
        
        /*
        void forAllDo(Collection collection, Closure closure)
        ��collection��ÿ���ڵ㶼��closure���execute()�������+��������/Ҫ�Լ�����ġ�
        
        
        void filter(Collection collection, Predicate predicate)
        ������Predicate�ľ�remove
        
        void transform(Collection collection, Transformer transformer)
        ��ô���ú�forAllDo��һ���ģ����Ƕ�collection��ÿ���ڵ���transformer��transform��������
        
        int countMatches(Collection inputCollection, Predicate predicate)
        ƥ��ĸ���
        
        
        boolean exists(Collection collection, Predicate predicate)
        
        Collection select(Collection inputCollection, Predicate predicate)
        ��������ƥ��������µļ��ϡ�
        
        void select(Collection inputCollection, Predicate predicate, Collection outputCollection)
        
        Collection selectRejected(Collection inputCollection, Predicate predicate)
        ��ò�ƥ���
        
        void selectRejected(Collection inputCollection, Predicate predicate, Collection outputCollection)
        
        
        Collection collect(Collection inputCollection, Transformer transformer)
        
        Collection collect(Iterator inputIterator, Transformer transformer) 
        
        Collection collect(Collection inputCollection, final Transformer transformer, final Collection outputCollection)
        
        
        
        */
        /*
        ...̫���ˣ���������
        
        boolean addIgnoreNull(Collection collection, Object object)
        ���null�����ӽ�ȥ����null���ӽ�ȥ
        
        void addAll(Collection collection, Iterator iterator)
        
        
        Object index(Iterator iterator, int idx)
        
        Object get(Object object, int index)
        
        int size(Object object)
        
        boolean isEmpty(Collection coll)
        null,��� ����true
        
        boolean isNotEmpty(Collection coll)
        !isEmpty
        
        
        reverseArray(Object[] array)
        
        
        boolean isFull(Collection coll)
        
        int maxSize(Collection coll)
        
        common-collection  ������ɡ����Ƿ���������⣿�������⣬��common-collection4�� �͸ĵ��ˣ�retain����retain����remove����remove
        public static Collection retainAll(Collection collection, Collection retain) {
            return ListUtils.retainAll(collection, retain);
        }
        public static Collection removeAll(Collection collection, Collection remove) {
            return ListUtils.retainAll(collection, remove);
        }
        �����������������������෴�ģ�һ�������ߵĽ���һ���ǲ���
        
         */
        
        
        
        
//        ListUtils.emptyIfNull(list)
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //...md,����  ListUtils�����϶�����Map Set Utils....
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    public static void show(Collection<?> c)        //buenng Collection<>
    {
        Object obj[] = c.toArray();
        String[] ss = new String[]{};
        String[] s2 = c.toArray(ss);        //...
        
//        for(int i = 0; i < c.size(); i++)     //һ������Ϳ����ˣ����Ҳ�ǿ��Եġ�
//        {
////            System.out.print(ss[i] + "; ");       // ss ��û�б�����Collection�е�ֵ��
//            System.out.print(s2[i] + "..");
//        }
        
        
        for(int i = 0; i < c.size(); i++)
        {
            System.out.print(obj[i] + ", ");
        }
        System.out.println();
    }
}
