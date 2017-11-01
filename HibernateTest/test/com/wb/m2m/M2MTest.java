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
        
        // 2个setId,报的错和以前一样。
        // 删了j的setID，剩下e的setId，可以了。。
        // 4条  4个insert 2个是对象的insert，2个是关系的insert，关系的insert在tr is active 之后
        
        // ...再运行也是可以的，，而且setId的30不起作用。。
        
        // 又试了几下，，是j.setId必须没有。。e.setId随意，但是不会有作用的。
        
        //... ri,多试几次，自己都糊涂了。。。反正已经插入后，，，2个setId 都是有用的，用save的时候也可以更新到这个id的数据的。
        
        // 可能是 new+inser的时候 setId是无效的，，且j的setId不能写。。。插入成功后， 2个setId都可以写的。写了就是update
        // new+insert的时候 先savej还是先save e 都是一样的，，都不能写j的setid。。
        
        // 全部new 全部setId,用saveOrUpdate只有tr is active后的update。。用save有一个insert，和trisavtice后的update
        
        // 全部new 全部setId 会失败，和setId有关，和save的顺序也有关。先save的那个可以setId，后save的那个不能setId。
        // 而且，，先save的那个即使setId了也没用的。
        // 由于有级联save-update，所以第二个save是应该不会发出sql的。。
        // 不写第二个的话，猜测，tr is active后会有3条insert，tr之前是1条。。不知道对不对，不想试了。。
        
        // 个人猜测，new+insert 的时候，第一个save的，直接insert到表，并且看sql，是只发出name，age的，不会发出id的。
        // 然后级联，，级联的时候不能无视id，所以导致错误？然后回滚？，上面的那条insert都被回滚了。也不知道是回滚，还是根本没有insert进去
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
        
        // 3tiao   2select 1delete,, delete是tr is active 后的。 2select都是 find id = 2 之前。
        
    }
    
    
    
    @Ignore
    @Test
    public void addWithNoinverseTrueTest()
    {
        M2MElder e = session.get(M2MElder.class, 25);
        M2MJunior j = session.get(M2MJunior.class, 2);
        
//        if(!e.getJunior().contains(j))            // 这个无所谓，就算contain的，add进去也不会发出新增关系的sql来
        {
            System.out.println(" not contain ");
            e.addJunior(j);
            j.addElder(e);              // 增加 一个 add  ，才能变成 真正的 双端维护
        }
        
        // 4tiao 3select 1insert
        // 2个session.get    e.getJunior
        // tr is active 后 insert关系
        // 这里双方 都没有inverse="true" 可以运行的。结果正确
        // 而且 commit的时候 自动把 改过的东西保存。
        
        // 网上说的是，双端维护关系，都将在中间表中插入记录，将报主键重复错误。
        // 好像是的，，我的中间表没有 设置 主键。。。刚想去设置主键，，发现有重复的 对应关系。
        // ...e知道了，，中间表的2个列作为主键后，又试了几下，没有问题。。是因为，我这里只是单项的包含，所以只是e来维护
        
        // yes。加了一个addElder，并且直接从数据库中间表 删除 关系，后，，这里就会报错，就是说主键冲突。而且在tr is active后
        // 是2条insert 到中间表，，以前都是一条的。。所以以前不会错，，这里会错。
        
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
        
        // 无法理解，，这里可以的了。共8条sql
        // 在-------------之前就4条insert 保存4个对象 全部发出。
        // 在tr is active后 4条insert 保存4个关系。
        
        // 。。是因为j.setId的问题。刚才试了下，有setId就发出sql，但是不会插入到数据库，也没有任何提示。。。不知道为什么。
    }
    
    
    @Ignore
    @Test
    public void addM2MrelationTest()
    {
        //,,,在这里就可以了。。不知道为什么第一个new+关联 会报错。。这里是只关联，
        M2MJunior j = session.get(M2MJunior.class, 1);
        M2MElder e = session.get(M2MElder.class, 17);
        
        j.addElder(e);
        e.addJunior(j);
        
        // 一共5条sql
        // session.get,,2条select
        // addXXX..2条select 是 junior_elder inner join 另一方的表
        // tr is active 后一条insert到junior_elder表
        
        // 第二次运行，只有前4条select。没有最后的insert
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
        eld.setId(37);           //这个没用的，看来被配置的<generator class="identity" />屏蔽掉了。。依然用的是数据库自增的id
                            //save的时候么用。。saveOrUpdate的时候有用，update了。
        session.save(eld);
    }
    
    @Ignore
    @Test
    public void addDate2Test()
    {
        // ok,由于主键是自增的，所以完全可以多次运行，主键不同，name，age相同 的数据。
        // 而且这一次主键从17开始，，可能是addDataTest发出的insert吧，虽然那个insert根本没有作用。
        // insert的只有2个属性 name age，id这里没有设置，所以是数据库的auto_increament有效？
        M2MElder eld = new M2MElderImpl();
        eld.setAge((short) 61);
        eld.setName("T_bbb");
        session.saveOrUpdate(eld);
    }
    
    
    @Ignore
    @Test
    public void addDataTest()
    {
        // error， 是因为 2条setId，但是为什么就不知道了
        
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
        
//      session = sf.getCurrentSession();       //要配置"hibernate.current_session_context_class">thread
        session = sf.openSession();
        
//        System.out.println("start of start 3");
        tr = session.beginTransaction();        //必须开启session，无论是session.xxx,还是query.xxx...what is query...?
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
