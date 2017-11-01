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
    public static void initial()            //Ӧ�������������ע�⣬�����������static
    {
        session = sessionFactory.getCurrentSession();       //static����,����sessionҪstatic
        transaction = session.beginTransaction();           //,,session.get��ʱ�򱨴�û��transaction��get����Ч�ġ�
        System.out.println("initial....");
    }

    static          //��BeforeClass��
    {
        System.out.println("static...");
        con = new Configuration();
        con.configure("hibernate/hibernate.cfg.xml");               //�޲�ʱĬ����src�µ�hibernate.cfg.xml
        sessionFactory = con.buildSessionFactory();                 //sessionFactory����static
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
         * ����������cascade�����one��cascade��none����ô����ᱨ���ȱ���person���ٱ���planet��
         * �����all��update-person��ʱ�򱨴�idΪ�ա���
         * ��������save-update���ǲ���������ֻ��save������ôupdate�أ�
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
     * cascade="saveupdate"��inverse="false"����ͬʱ���ã�������teamά��������ϵ
     * 
     *  Hibernate��get��load������ѯ����ʵ�嶼�ǳ־û�����
     *  �õ��ö�������������˸ö����set������
     *  ��ô������ݽ���ʱ��Hibernate��������õ�ֵ�Զ����µ����ݿ��С�
     *  
     * */
    @Ignore
    @Test
    public void inverse3Test()
    {
        
        /**
         * �����������û��cascade��ʱ�����ô����������ǻᱣ��ģ���cascade��ʲô�ã�����Ĭ��Ӧ���ǲ����κμ��������ġ�
         * ����������������ca�����߶���Ϊcascade="none"���ᷢ��update��䡣��
         * ���֣�����inverse��cascadeɾ���󣬺�ɾ��ǰ��person˳���ǲ�һ���ģ�û��ϸ����inverse����cascade������
         * */
        
        Planet pl = session.get(PlanetImpl.class, 2);
        Person[] p = pl.getPerson().toArray(new Person[]{});
        Person p2 = p[2];
        session.evict(p[2]);
        System.out.println(p2.getAge());
        p2.setAge(p2.getAge()+1);
        int p2id = p2.getId();
        session.evict(p2);              //evictû�ã����ҷ�����sql�����ˡ���ǰ��ֻ��һ��update���¸ı���Ǹ�person��
                                //������һ��select����planet��Ȼ���planet��ÿ��person����һ��update
                        //ok�ˣ�mlgb�������Ǽ���all�ġ�������Ҫ���档��.�����𣬼���all������ֻ����һ��sql�������Ǹ����ı�ġ�evictһ������Ҫ����ȫ������
                //evict���ã�������Ļ������ǻ���µġ������˾Ͳ�������..set֮ǰ����֮��evict��һ����
        
        session.saveOrUpdate(pl);
        transaction.commit();
        
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        
        p2 = session.get(PersonImpl.class, p2id);           //û�е���PersonImpl�Ļ���eclipse�ĵ�һ����ʾ��ת��Person���ڶ�������û�е���
        System.out.println(p2.getAge());
    }
    
    
    @Ignore
    @Test
    public void inverse2Test()
    {
        
        /**
         * ok,inverse��ָ��one��һ�˵Ĳ���������set��remove�����᲻���޸�person��planet��
         * inverse="true"�������޸�person��planet��
         * inverse="false"�����޸�person��planet�������������ݿ�д��planet_id�ǿգ����Իᱨ��
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
         * ����Ͳ�֪���ˣ�����û�л���save-update��inverse��false�������Ը���person��planet�����ݿⰡ��
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
         * one2many,one��������cascade="save-update",inverseĬ��false��inverse="true"Ҳ���Լ���update-many�ˡ�
         * ͨ��one���many���޸�many������one��update-one��ֻ����һ��sql���±��޸ĵ�many
         * */
        
        Planet pl = session.get(PlanetImpl.class, 2);
//        System.out.println(pl.getPerson().size());          //����ֻ����һ��sql�ͻ��3��person
//        for(Person p : pl.getPerson())
//        {
//            System.out.println(p.getName());
//        }
        
//        Person[] a = new Person[]{};
//        Person[] p = pl.getPerson().toArray(a);
        
//        Person[] p = pl.getPerson().toArray(new Person[]{});
        
        Person[] p = new Person[]{};
        p = pl.getPerson().toArray(p);          //3��������toArray��
        
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
         * many2one������many2one��cascadeΪsave-update,one��inverseΪtrue,ɾ��one�˵�inverse(Ĭ��false)����Ȼ���Ա���������
         * ͨ��many���one��Ȼ���޸�one�����޸�many��saveOrUpdate-many�ˣ�ֻ����һ��sql��������one�ˣ����Զ�����update��one��
         * */
        
        
        Person p = session.get(Person.class, 5);        //person��many��planet��one
        System.out.println(p.getName());
        Planet pl = p.getPlanet();                  //������lazy�Ļ�����Ĭ���������صģ������䲻��false��Ҫ�������������ǵڶ�����ʱ������person��get��ʱ���������ʱ��
        System.out.println(pl.getAge());
        pl.setAge(pl.getAge()+1);
        
//        p.setName("1a");                  //����û������ʱ��û�иı�planet����Ϊ��personû�иı��ԭ�򣬼������Ҳû�С����Լ���û�б䡣������transaction.commitû�е�ԭ��
        
        session.saveOrUpdate(p);
        transaction.commit();           //commit�Ժ�session�Ͳ������ˡ�evictҲ����
//        session.beginTransaction();       
        
//        session.evict(pl);
        pl = p.getPlanet();
        System.out.println(pl.getAge());        //���Ӧ�����ڴ���İɡ�
        
//        con.configure("hibernate/hibernate.cfg.xml");
//        sessionFactory = con.buildSessionFactory();
        session = sessionFactory.getCurrentSession();       //commit�ǹر�session��transaction��
        transaction = session.beginTransaction();
        
        p = session.get(Person.class, 5);
        System.out.println(p.getPlanet().getAge());
    }
    
    
    @Ignore
    @Test
    public void getTest()
    {
        Person p = session.get(Person.class, 9);            //Ϊʲô���ﲻ���ýӿڣ�,hbm��Ҫ����proxy�����ýӿڡ�
        System.out.println(p.getName());
        Planet pl = session.get(PlanetImpl.class, 2);      //����Ļ�Ҫת�ɽӿ�..buyong...
        System.out.println(pl.getName());
    }
    
    
    @Ignore
    @Test
    public void testTest()
    {
        System.out.println("test...");
    }
}
