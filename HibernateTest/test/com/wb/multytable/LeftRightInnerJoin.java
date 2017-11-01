package com.wb.multytable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

import com.wb.model.Person;
import com.wb.model.PersonImpl;
import com.wb.model.Planet;
import com.wb.model.PlanetImpl;

public class LeftRightInnerJoin {


    public static Session session;
    
    public static SessionFactory sessionFactory;
    
    public static Transaction transaction;
    
    public static Configuration configuration;
    
    static
    {
        configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        System.out.println("start...");
    }
    
    @AfterClass
    public static void stop()
    {
        if(transaction.isActive())
            transaction.commit();
        if(session.isConnected())
            session.close();
        if(sessionFactory.isOpen())
            sessionFactory.close();
        System.out.println("end...");
    }
    
    /**
     * 没有proxy="Planet"，但是hql中依然可以Planet.class.getName
     * */
    
    
    
    
    @Ignore
    @Test
    public void leftJoin5Test()
    {
        String hql = "from " + Person.class.getName() + " as a left join " + Planet.class.getName() + " as b on a.planet.id=b.id where a.id>10";
        this.executeSQLAndShow(hql);
    }
    
    @Ignore
    @Test
    public void leftJoin4Test()
    {
        String hql = "from " + Person.class.getName() + " as a left join a.planet as b on a.planet.id=b.id where a.id>10";
        this.executeSQLAndShow(hql);
    }
    
    @Ignore
    @Test
    public void leftJoin3Test()
    {
        String hql = "from " + Person.class.getName() + " as a left join a.planet as b on a.planet=b where a.id>10";
        this.executeSQLAndShow(hql);
    }
    
    @Ignore
    @Test
    public void letJoin2Test()
    {
        String hql = "from " + Person.class.getName() + " as a left join " + Planet.class.getName() + " as b on a.planet=b where a.id>10";
        //必须 on a.planet=b
        this.executeSQLAndShow(hql);
    }
    
    @Ignore
    @Test
    public void leftJoinTest()
    {
        String hql = "from " + Person.class.getName() + " as a left join a.planet where a.id>10";
        this.executeSQLAndShow(hql);
    }
    
    @Ignore
    @Test
    public void rightJoin2Test()
    {
        String hql = "from " + Person.class.getName() + " as a right join a.planet where a.id>10 and year(a.birth)>100";
        executeSQLAndShow(hql);
    }
    
    public void executeSQLAndShow(String sql)
    {
        List<Object[]> list = executeSQL(sql);
        for(Object[] o : list)
        {
            System.out.println(o[0] + ", " + o[1]);
        }
    }
    
    @Ignore
    @Test
    public void rightJoinTest()
    {
        String hql = "from " + Person.class.getName() + " as a right join " + Planet.class.getName() + " as b on a.planet=b where a.id>10";
        //必须加  on a.planet=b ，不然就是 执行时报错。
        List<Object[]> list = executeSQL(hql);
        for(Object[] o : list)
        {
            System.out.println(o[0] + ", " + o[1]);
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Object[]> executeSQL(String sql)
    {
        return session.createQuery(sql).list();
    }
    
    
    @Ignore
    @Test
    public void innerJoin3Test() throws SQLException
    {
        String hql = "from " + Person.class.getName() + " as a inner join " + Planet.class.getName() + " as b on a.planet=b where a.id>10 and a.birth>'2011-1-1'";
        //用外键的话(innerJoin2Test)，就不同 on a.planet=b。这里不是外键所以要加。
        
        List<Object[]> list = session.createQuery(hql).list();
        for(Object[] o : list)
        {
            System.out.println(o[0] + ", " + o[1]);
        }
    }
    
    @Ignore
    @Test
    public void innerJoin2Test() throws SQLException
    {
        String hql = "from " + Person.class.getName() + " as a inner join a.planet as b where a.id>10 and a.birth>'2010-1-1'";
        List<Object[]> list = session.createQuery(hql).list();
        for(Object[] o : list)
        {
            System.out.println(o[0] + ", " + o[1]);         //可以的。。。object[0]就是一个Person，object[1]就是一个Planet
        }
    }
    
    @Deprecated
    @Ignore
    @Test
    public void innerJoinTest() throws SQLException
    {
//        String hql = "from " + Person.class.getName() + " as a inner join " + PlanetImpl.class.getName() + " as b on a.planet=b where a.id>10";
//        String hql2 = "from " + Person.class.getName() + " as a inner join a.planet";
//        List<Person> pList = session.createQuery(hql).list();
////        show(pList, Person.class);
//        for(Person p : pList)             //也报了不能转换
//        {
//            System.out.println(p.toString());
//        }
//        List<Object> objList = session.createQuery(hql).list();
//        for(Object o : objList)
//        {
//            System.out.println(o);          //这里可以的。但是没用啊，不能取出其中的属性。
//        }
        
//        List<ResultSet> rsList = session.createQuery(hql).getResultList();
//        for(ResultSet rs : rsList)
//        {
//            String c1 = rs.getString(1);
//            String c2 = rs.getString(2);
//            String c3 = rs.getString(3);
//            String c4 = rs.getString(4);
//            String c5 = rs.getString(5);
//            String c6 = rs.getString(6);
//            String c7 = rs.getString(7);
//            String c8 = rs.getString(8);
//            String c9 = rs.getString(9);
//            System.out.println(c1 + "," + c5 + ", " + c9);
//        }
        
//        List<Person> pL = session.createQuery(hql2).list();     //还是说object 不能转为Person
//        for(Person p : pL)
//        {
//            System.out.println(p.toString());
//        }
    }
    
    @Deprecated
    public void show(Collection<?> collections, Class clazz)
    {
        if(collections != null && !collections.isEmpty())
        {
            for(Object c : collections)
            {
//                System.out.println(((Person)c).toString());           //转不过去。.擦，直接也不行，本来就是不是Person。。
            }
        }
        else
        {
            System.out.println("null or empty...");
        }
    }
    
    @Ignore
    @Test
    public void criteriaYearTest()
    {
        Criteria c = session.createCriteria(Person.class);
//        c.add(Restrictions.ge("year(birth)", 100));           //不行
        c.add(Restrictions.sqlRestriction(" year(person_bir)>100"));            //这里是sql，不能是birth
        List<Person> pList = c.list();
        if(pList != null && !pList.isEmpty())
        {
            System.out.println(pList.size());
            for(Person p : pList)
            {
                System.out.println(p.getId() + ", " + p.getBirth());
            }
        }
    }
    
    @Ignore
    @Test
    public void sqlYearTest()
    {
        String hql = "from " + Person.class.getName() + " where year(birth)>100";       //刚开始只写了 类属性，没有hbm映射，写的是数据库列名，可以用的，换成属性就不行。
        @SuppressWarnings("unchecked")
        List<Person> pList = session.createQuery(hql).list();
        
        if(pList != null && !pList.isEmpty())
        {
            System.out.println(pList.size());
            for(Person p : pList)
            {
                System.out.println(p.getId() + ", " + p.getBirth());
            }
        }
    }
}
