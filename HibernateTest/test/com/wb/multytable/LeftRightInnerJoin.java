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
     * û��proxy="Planet"������hql����Ȼ����Planet.class.getName
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
        //���� on a.planet=b
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
        //�����  on a.planet=b ����Ȼ���� ִ��ʱ����
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
        //������Ļ�(innerJoin2Test)���Ͳ�ͬ on a.planet=b�����ﲻ���������Ҫ�ӡ�
        
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
            System.out.println(o[0] + ", " + o[1]);         //���Եġ�����object[0]����һ��Person��object[1]����һ��Planet
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
//        for(Person p : pList)             //Ҳ���˲���ת��
//        {
//            System.out.println(p.toString());
//        }
//        List<Object> objList = session.createQuery(hql).list();
//        for(Object o : objList)
//        {
//            System.out.println(o);          //������Եġ�����û�ð�������ȡ�����е����ԡ�
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
        
//        List<Person> pL = session.createQuery(hql2).list();     //����˵object ����תΪPerson
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
//                System.out.println(((Person)c).toString());           //ת����ȥ��.����ֱ��Ҳ���У��������ǲ���Person����
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
//        c.add(Restrictions.ge("year(birth)", 100));           //����
        c.add(Restrictions.sqlRestriction(" year(person_bir)>100"));            //������sql��������birth
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
        String hql = "from " + Person.class.getName() + " where year(birth)>100";       //�տ�ʼֻд�� �����ԣ�û��hbmӳ�䣬д�������ݿ������������õģ��������ԾͲ��С�
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
