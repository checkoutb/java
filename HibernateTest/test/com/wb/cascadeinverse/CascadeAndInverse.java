package com.wb.cascadeinverse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.wb.model.Person;
import com.wb.model.PersonImpl;
import com.wb.model.Planet;
import com.wb.model.PlanetImpl;

public class CascadeAndInverse {

    private static Session session;
    
    private static SessionFactory sessionFactory;
    
    private static Transaction transaction;
    
    private static Configuration con;
    
    @BeforeClass
    public static void initial()            //应该由于上面这个注解，所以这里必须static
    {
        session = sessionFactory.getCurrentSession();       //static方法,所以session要static
        transaction = session.beginTransaction();           //,,session.get的时候报错，没有transaction，get是无效的。
        System.out.println("initial....");
    }

    static          //比BeforeClass先
    {
        System.out.println("static...");
        con = new Configuration();
        con.configure("hibernate/hibernate.cfg.xml");               //无参时默认是src下的hibernate.cfg.xml
        sessionFactory = con.buildSessionFactory();                 //sessionFactory必须static
    }
    
    @AfterClass
    public static void close()
    {
        if(transaction.isActive())
        {
            transaction.commit();
        }
        if(session.isConnected())
        {
            session.close();
        }
    }
    
    
    

    @Ignore
    @Test
    public void cascadeAndInverseTest()
    {
        /**
         * 这里能体现cascade，如果one的cascade是none，那么这里会报错：先保存person，再保存planet；
         * 如果是all，update-person的时候报错，id为空。。
         * ，，但是save-update还是不懂。这里只是save，，那么update呢？
         * */
        
        Planet pl = session.get(PlanetImpl.class, 2);
        Person p = new PersonImpl();
        
        p.setAge(22);
        p.setName("zxc");
        p.setPlanet(pl);
        
        pl.getPerson().add(p);
        
        session.saveOrUpdate(pl);
        transaction.commit();
        
    }
    
    /**
     * cascade="saveupdate"和inverse="false"必须同时设置，才能让team维护级联关系
     * 
     *  Hibernate的get和load方法查询出的实体都是持久化对象，
     *  拿到该对象后，如果你调用了该对象的set方法，
     *  那么在事务递交的时候，Hibernate会把你设置的值自动更新到数据库中。
     *  
     * */
    @Ignore
    @Test
    public void inverse3Test()
    {
        
        /**
         * 这里是想测试没有cascade的时候会怎么样，结果还是会保存的，那cascade有什么用？而且默认应该是不做任何级联操作的。
         * 。。。。。。。。ca，两边都设为cascade="none"都会发出update语句。。
         * 发现，两边inverse，cascade删掉后，和删掉前的person顺序是不一样的，没有细分是inverse还是cascade的问题
         * */
        
        Planet pl = session.get(PlanetImpl.class, 2);
        Person[] p = pl.getPerson().toArray(new Person[]{});
        Person p2 = p[2];
        session.evict(p[2]);
        System.out.println(p2.getAge());
        p2.setAge(p2.getAge()+1);
        int p2id = p2.getId();
        session.evict(p2);              //evict没用，而且发出的sql还多了。以前是只有一条update更新改变的那个person，
                                //现在是一条select搜索planet，然后对planet的每个person都做一把update
                        //ok了，mlgb，上面是级联all的。。所以要保存。。.不驱逐，级联all，还是只发出一条sql，更新那个被改变的。evict一个，就要更新全部。。
                //evict有用，不驱逐的话，还是会更新的。驱逐了就不更新了..set之前还是之后evict都一样。
        
        session.saveOrUpdate(pl);
        transaction.commit();
        
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        
        p2 = session.get(PersonImpl.class, p2id);           //没有导入PersonImpl的话，eclipse的第一个提示是转成Person，第二个才是没有导入
        System.out.println(p2.getAge());
    }
    
    
    @Ignore
    @Test
    public void inverse2Test()
    {
        
        /**
         * ok,inverse是指在one这一端的操作，就是set里remove掉，会不会修改person的planet。
         * inverse="true"，不会修改person的planet。
         * inverse="false"，会修改person的planet，但是由于数据库写了planet_id非空，所以会报错
         * */
        
        Planet pl = session.get(PlanetImpl.class, 2);
        Person[] p = pl.getPerson().toArray(new Person[]{});
        Person p2 = p[2];
        System.out.println(p2.getPlanet().getId());
        
        pl.getPerson().remove(p2);
        int p2id = p2.getId();
        
        session.saveOrUpdate(pl);
        transaction.commit();
        
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        
        p2 = session.get(Person.class, p2id);
        System.out.println(p2.getPlanet().getId());
    }
    
    
    @Ignore
    @Test
    public void inverseTest()
    {
        /**
         * 这里就不知道了，级联没有或者save-update，inverse是false，都可以更新person的planet到数据库啊。
         * */
        
        Planet pl = session.get(PlanetImpl.class, 2);
        Person[] p = pl.getPerson().toArray(new Person[]{});
        Person p2 = p[2];
        System.out.println(p2.getPlanet().getId());
        
        Planet pl2 = session.get(PlanetImpl.class, 3);
        p2.setPlanet(pl2);
        System.out.println(p2.getPlanet().getId());
        int p2id = p2.getId();
        
        session.saveOrUpdate(pl);
        transaction.commit();
        
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        
        p2 = session.get(Person.class, p2id);
        System.out.println(p2.getPlanet().getId());
        
    }
    
    
    
    @Ignore
    @Test
    public void one2manyCascadeTest()
    {
        
        /**
         * one2many,one端设置了cascade="save-update",inverse默认false，inverse="true"也可以级联update-many端。
         * 通过one获得many，修改many，不改one，update-one，只发出一条sql更新被修改的many
         * */
        
        Planet pl = session.get(PlanetImpl.class, 2);
//        System.out.println(pl.getPerson().size());          //这里只发出一条sql就获得3个person
//        for(Person p : pl.getPerson())
//        {
//            System.out.println(p.getName());
//        }
        
//        Person[] a = new Person[]{};
//        Person[] p = pl.getPerson().toArray(a);
        
//        Person[] p = pl.getPerson().toArray(new Person[]{});
        
        Person[] p = new Person[]{};
        p = pl.getPerson().toArray(p);          //3个都可以toArray。
        
        System.out.println(p.length);
        Person p1 = p[1];
        System.out.println(p1.getAge());
        p1.setAge(p1.getAge()+1);
        session.saveOrUpdate(pl);
        transaction.commit();
        
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        
        pl = session.get(PlanetImpl.class, 2);
        for(Person per : pl.getPerson())
        {
            System.out.println(per.getAge());
        }
    }
    
    
    @Ignore
    @Test
    public void many2oneCascadeTest()
    {
        /**
         * many2one，设置many2one的cascade为save-update,one端inverse为true,删除one端的inverse(默认false)，依然可以被级联保存
         * 通过many获得one，然后修改one，不修改many，saveOrUpdate-many端，只发出一条sql用来更新one端，会自动级联update，one端
         * */
        
        
        Person p = session.get(Person.class, 5);        //person是many，planet是one
        System.out.println(p.getName());
        Planet pl = p.getPlanet();                  //不配置lazy的话，是默认有懒加载的，不过配不配false都要发两条，区别是第二条及时发，是person被get的时候还是这里的时候
        System.out.println(pl.getAge());
        pl.setAge(pl.getAge()+1);
        
//        p.setName("1a");                  //擦，没有这句的时候没有改变planet，以为是person没有改变的原因，加了这句也没有。连自己都没有变。可能是transaction.commit没有的原因
        
        session.saveOrUpdate(p);
        transaction.commit();           //commit以后session就不能用了。evict也不行
//        session.beginTransaction();       
        
//        session.evict(pl);
        pl = p.getPlanet();
        System.out.println(pl.getAge());        //这个应该是内存里的吧。
        
//        con.configure("hibernate/hibernate.cfg.xml");
//        sessionFactory = con.buildSessionFactory();
        session = sessionFactory.getCurrentSession();       //commit是关闭session和transaction，
        transaction = session.beginTransaction();
        
        p = session.get(Person.class, 5);
        System.out.println(p.getPlanet().getAge());
    }
    
    
    @Ignore
    @Test
    public void getTest()
    {
        Person p = session.get(Person.class, 9);            //为什么这里不能用接口？,hbm里要配置proxy才能用接口。
        System.out.println(p.getName());
        Planet pl = session.get(PlanetImpl.class, 2);      //不配的话要转成接口..buyong...
        System.out.println(pl.getName());
    }
    
    
    @Ignore
    @Test
    public void testTest()
    {
        System.out.println("test...");
    }
}
