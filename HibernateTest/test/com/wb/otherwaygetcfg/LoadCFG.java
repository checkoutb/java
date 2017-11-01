package com.wb.otherwaygetcfg;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wb.model.Person;
import com.wb.model.PersonImpl;
import com.wb.model.Planet;
import com.wb.model.PlanetImpl;

public class LoadCFG {

    private static Session session;
    
    private static SessionFactory sessionFactory;
    
    private static Transaction transaction;
    
    private static Configuration configuration;
    
    @BeforeClass
    public static void init()
    {
        configuration = new Configuration().configure();        //src�µ�cfg,����˵���cfg������mapping�����ǿ��԰���.
                                                                //����˵���ǣ�mapping��ͬ���ֵ�xml������mapping�ĺ�����Ĳ���һ�������Բ���������ġ�
                                                                //����˵���Ĵ����ظ����壬���ò��ˡ�
        System.out.println("...");
        configuration.addClass(PersonImpl.class);       //Ҫ��com.wb.model���Person.hbm.xml..����ʲô����.class����ʲô����.hbm.xml����ǰ�õĽӿڣ�����Person.hbm.xml
        configuration.addClass(PlanetImpl.class);       //ͬ��
        
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
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
        if(sessionFactory.isOpen())
        {
            sessionFactory.close();
        }
    }
    
    @Test
    public void testTest()
    {
        Person p = session.get(Person.class, 2);
        Planet pl = session.get(PlanetImpl.class, 3);
        System.out.println(p.getName() + ", " + pl.getName());
    }
    
}
