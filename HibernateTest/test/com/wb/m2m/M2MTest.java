package com.wb.m2m;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.wb.model.m2m.M2MElder;
import com.wb.model.m2m.M2MElderImpl;
import com.wb.model.m2m.M2MJunior;
import com.wb.model.m2m.M2MJuniorImpl;
import com.wb.model.m2m.M2MPerson;

public class M2MTest {


    private static SessionFactory sf;
    private static Session session;
    private static Transaction tr;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Ignore
    @Test
    public void m2mNewAndInsertTest()
    {
        M2MElder e = new M2MElderImpl();
//        e.setId(40);
        e.setAge((short) 60);
        e.setName("m_DWD");
        
        M2MJunior j = new M2MJuniorImpl();
        j.setId(20);
        j.setAge((short) 21);
        j.setName("e_DWD");
        
        e.addJunior(j);
        j.addElder(e);
        
        session.save(j);
        session.save(e);
        
        // 2��setId,���Ĵ����ǰһ����
        // ɾ��j��setID��ʣ��e��setId�������ˡ���
        // 4��  4��insert 2���Ƕ����insert��2���ǹ�ϵ��insert����ϵ��insert��tr is active ֮��
        
        // ...������Ҳ�ǿ��Եģ�������setId��30�������á���
        
        // �����˼��£�����j.setId����û�С���e.setId���⣬���ǲ��������õġ�
        
        //... ri,���Լ��Σ��Լ�����Ϳ�ˡ����������Ѿ�����󣬣���2��setId �������õģ���save��ʱ��Ҳ���Ը��µ����id�����ݵġ�
        
        // ������ new+inser��ʱ�� setId����Ч�ģ�����j��setId����д����������ɹ��� 2��setId������д�ġ�д�˾���update
        // new+insert��ʱ�� ��savej������save e ����һ���ģ���������дj��setid����
        
        // ȫ��new ȫ��setId,��saveOrUpdateֻ��tr is active���update������save��һ��insert����trisavtice���update
        
        // ȫ��new ȫ��setId ��ʧ�ܣ���setId�йأ���save��˳��Ҳ�йء���save���Ǹ�����setId����save���Ǹ�����setId��
        // ���ң�����save���Ǹ���ʹsetId��Ҳû�õġ�
        // �����м���save-update�����Եڶ���save��Ӧ�ò��ᷢ��sql�ġ���
        // ��д�ڶ����Ļ����²⣬tr is active�����3��insert��tr֮ǰ��1��������֪���Բ��ԣ��������ˡ���
        
        // ���˲²⣬new+insert ��ʱ�򣬵�һ��save�ģ�ֱ��insert�������ҿ�sql����ֻ����name��age�ģ����ᷢ��id�ġ�
        // Ȼ��������������ʱ��������id�����Ե��´���Ȼ��ع��������������insert�����ع��ˡ�Ҳ��֪���ǻع������Ǹ���û��insert��ȥ
    }
    
    
    @Ignore
    @Test
    public void delWithNoinverseTest()
    {
        M2MElder e = session.get(M2MElder.class, 25);
        
        M2MPerson p = null;
        for(M2MPerson j : e.getJunior())
        {
            if(j.getId() == 2)
            {
                System.out.println(" find id = 2");
                p = j;
                break;
            }
        }
        e.delJunior(p);
        
        // 3tiao   2select 1delete,, delete��tr is active ��ġ� 2select���� find id = 2 ֮ǰ��
        
    }
    
    
    
    @Ignore
    @Test
    public void addWithNoinverseTrueTest()
    {
        M2MElder e = session.get(M2MElder.class, 25);
        M2MJunior j = session.get(M2MJunior.class, 2);
        
//        if(!e.getJunior().contains(j))            // �������ν������contain�ģ�add��ȥҲ���ᷢ��������ϵ��sql��
        {
            System.out.println(" not contain ");
            e.addJunior(j);
            j.addElder(e);              // ���� һ�� add  �����ܱ�� ������ ˫��ά��
        }
        
        // 4tiao 3select 1insert
        // 2��session.get    e.getJunior
        // tr is active �� insert��ϵ
        // ����˫�� ��û��inverse="true" �������еġ������ȷ
        // ���� commit��ʱ�� �Զ��� �Ĺ��Ķ������档
        
        // ����˵���ǣ�˫��ά����ϵ���������м���в����¼�����������ظ�����
        // �����ǵģ����ҵ��м��û�� ���� ��������������ȥ�������������������ظ��� ��Ӧ��ϵ��
        // ...e֪���ˣ����м���2������Ϊ�����������˼��£�û�����⡣������Ϊ��������ֻ�ǵ���İ���������ֻ��e��ά��
        
        // yes������һ��addElder������ֱ�Ӵ����ݿ��м�� ɾ�� ��ϵ���󣬣�����ͻᱨ������˵������ͻ��������tr is active��
        // ��2��insert ���м������ǰ����һ���ġ���������ǰ�������������
        
    }
    
    
    @Ignore
    @Test
    public void addNewAndInsert22Test()
    {

        M2MElder eld1 = new M2MElderImpl();
        eld1.setAge((short) 52);
        eld1.setName("e_AAA");
        
        M2MElder eld2 = new M2MElderImpl();
        eld2.setAge((short) 66);
        eld2.setName("e_BBB");
        
        M2MJunior j1 = new M2MJuniorImpl();
        j1.setAge((short) 11);
        j1.setName("j_EEE");
//        j1.setId(10);
        
        M2MJunior j2 = new M2MJuniorImpl();
        j2.setAge((short) 15);
        j2.setName("j_FFF");
//        j2.setId(12);
        
        j1.addElder(eld2);
        j1.addElder(eld1);
        
        j2.addElder(eld2);
        j2.addElder(eld1);
        
        eld1.addJunior(j2);
        eld1.addJunior(j1);
        
        eld2.addJunior(j2);
        eld2.addJunior(j1);
        
        session.saveOrUpdate(j1);
        System.out.println("\n\n-------------------");
        session.saveOrUpdate(j2);
        System.out.println("\n\n...................");
        session.saveOrUpdate(eld1);
        System.out.println("\n\n+++++++++++++++++++");
        session.saveOrUpdate(eld2);
        
//        try {
//            System.out.println(" sleep start ");
//            Thread.sleep(1000 * 20);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
        // �޷���⣬��������Ե��ˡ���8��sql
        // ��-------------֮ǰ��4��insert ����4������ ȫ��������
        // ��tr is active�� 4��insert ����4����ϵ��
        
        // ��������Ϊj.setId�����⡣�ղ������£���setId�ͷ���sql�����ǲ�����뵽���ݿ⣬Ҳû���κ���ʾ��������֪��Ϊʲô��
    }
    
    
    @Ignore
    @Test
    public void addM2MrelationTest()
    {
        //,,,������Ϳ����ˡ�����֪��Ϊʲô��һ��new+���� �ᱨ����������ֻ������
        M2MJunior j = session.get(M2MJunior.class, 1);
        M2MElder e = session.get(M2MElder.class, 17);
        
        j.addElder(e);
        e.addJunior(j);
        
        // һ��5��sql
        // session.get,,2��select
        // addXXX..2��select �� junior_elder inner join ��һ���ı�
        // tr is active ��һ��insert��junior_elder��
        
        // �ڶ������У�ֻ��ǰ4��select��û������insert
    }
    
    
    @Ignore
    @Test
    public void addJuniorTest()
    {
        // id auto from 1;
        M2MJunior j = new M2MJuniorImpl();
        j.setAge((short) 24);
        j.setName("J_DDD");
        j.setId(50);        //invalid
        session.save(j);
    }
    
    
    
    @Ignore
    @Test
    public void delTest()
    {
        M2MElder eld = session.get(M2MElder.class, 18);
        session.delete(eld);
    }
    
    
    @Ignore
    @Test
    public void addDateUseIdTest()
    {
        M2MElder eld = new M2MElderImpl();
        eld.setAge((short) 53);
        eld.setName("T_qwe");
        eld.setId(37);           //���û�õģ����������õ�<generator class="identity" />���ε��ˡ�����Ȼ�õ������ݿ�������id
                            //save��ʱ��ô�á���saveOrUpdate��ʱ�����ã�update�ˡ�
        session.save(eld);
    }
    
    @Ignore
    @Test
    public void addDate2Test()
    {
        // ok,���������������ģ�������ȫ���Զ�����У�������ͬ��name��age��ͬ �����ݡ�
        // ������һ��������17��ʼ����������addDataTest������insert�ɣ���Ȼ�Ǹ�insert����û�����á�
        // insert��ֻ��2������ name age��id����û�����ã����������ݿ��auto_increament��Ч��
        M2MElder eld = new M2MElderImpl();
        eld.setAge((short) 61);
        eld.setName("T_bbb");
        session.saveOrUpdate(eld);
    }
    
    
    @Ignore
    @Test
    public void addDataTest()
    {
        // error�� ����Ϊ 2��setId������Ϊʲô�Ͳ�֪����
        
        M2MElder eld1 = new M2MElderImpl();
        eld1.setAge((short) 51);
        eld1.setName("a_CCC");
        
        M2MElder eld2 = new M2MElderImpl();
        eld2.setAge((short) 64);
        eld2.setName("a_DDD");
        
        M2MJunior j1 = new M2MJuniorImpl();
        j1.setAge((short) 13);
        j1.setName("n_JJJ");
        j1.setId(10);
        
        M2MJunior j2 = new M2MJuniorImpl();
        j2.setAge((short) 14);
        j2.setName("n_UUU");
        j2.setId(12);
        
        j1.addElder(eld2);
        j1.addElder(eld1);
        
        j2.addElder(eld2);
        j2.addElder(eld1);
        
        eld1.addJunior(j2);
        eld1.addJunior(j1);
        
        eld2.addJunior(j2);
        eld2.addJunior(j1);
        
        session.saveOrUpdate(j1);
        System.out.println("\n\n-------------------");
        session.saveOrUpdate(j2);
        System.out.println("\n\n...................");
        session.saveOrUpdate(eld1);
        System.out.println("\n\n+++++++++++++++++++");
        session.saveOrUpdate(eld2);
        
//        try {
//            System.out.println(" sleep start ");
//            Thread.sleep(1000 * 20);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
    }
    

    
    /**
     */
    @BeforeClass
    public static void setUp() throws Exception {
        Configuration conf = new Configuration();
//        conf.configure("hibernate/hibernate.cfg.xml");
//        System.out.println("start of start");
        conf.configure("com/wb/model/m2m/hibernate.cfg.xml");
        
//        System.out.println("start of start 2");
        sf = conf.buildSessionFactory();
        
//        System.out.println("start of start 2.5");
        
//      session = sf.getCurrentSession();       //Ҫ����"hibernate.current_session_context_class">thread
        session = sf.openSession();
        
//        System.out.println("start of start 3");
        tr = session.beginTransaction();        //���뿪��session��������session.xxx,����query.xxx...what is query...?
                                        //this is query...
                                        //      String hql = "select a.name,a.id from PersonImpl a where id>=1 and id<3";
                                        //      Query query = session.createQuery(hql);
                                        //      List<PersonImpl> list = query.list();
                                    //and Criteria...
                                    //      Criteria c = session.createCriteria(PersonImpl.class);
                                    //      c.add(Restrictions.between("id", 8, 11));
                                    //      List<Person> plist = c.list();
        System.out.println("start...\n");
    }
    
    @AfterClass
    public static void down() throws Exception
    {
        System.out.println("\nthis is the AfterClass...");
        if(tr.isActive())
        {
            System.out.println("tr is active...");
            tr.commit();        //second commit will throw exception
                                //see the code, first line is if(!isActive()){throw Exception...}
        }
        else
        {
            System.out.println("tr is not active...");
        }
//      tr.commit();
        System.out.println("\nthis is the AfterTransactionCommit...");
        
        if(session.isConnected())
        {
            //getCurrentSession,session will auto close after commit,
            //OpenSession,u need close session by session.close();
            //yes,getCurrentSession won't print below,openSession will print below
            System.out.println("session is connected");
        }
        session.close();
//      session.close();    //second close won't throw exception!!!cannot understand the code...
        sf.close();
        System.out.println("\nend...");
    }

}
