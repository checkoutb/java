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
        configuration = new Configuration().configure();        //src下的cfg,网上说这个cfg不能有mapping，但是可以啊。.
                                                                //网上说的是，mapping相同名字的xml，这里mapping的和下面的并不一样，所以不会有问题的。
                                                                //网上说报的错是重复定义，懒得测了。
        System.out.println("...");
        configuration.addClass(PersonImpl.class);       //要在com.wb.model里放Person.hbm.xml..反正什么名字.class就是什么名字.hbm.xml。以前用的接口，所以Person.hbm.xml
        configuration.addClass(PlanetImpl.class);       //同上
        
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
