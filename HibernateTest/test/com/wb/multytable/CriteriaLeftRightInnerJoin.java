package com.wb.multytable;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.JoinType;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.wb.model.Person;
import com.wb.model.Planet;

public class CriteriaLeftRightInnerJoin {

    public static LeftRightInnerJoin join;
    
    @AfterClass
    public static void end()
    {
        join.stop();
    }
    
    @Ignore
    @Test
    public void innerJoinTest()
    {
        Date date = new Date("2017/5/4");
        Criteria c = join.session.createCriteria(Person.class);
        c.createAlias("planet", "b");
        c.add(Restrictions.gt("birth", date));
        List<Person> pL = c.list();
        for(Person p : pL)
        {
            System.out.println(p);              //��testTest�������ǣ������ӣ�����person_id=10���Ǹ��Ͳ��ᱻ����������toStringû�з���sql��������planet�������Ѿ������������ˡ�
                                                //���Ǻ���û�а취ֱ�ӻ��planet��������ͨ��person�����planet
                                                //���о���û�������ϵ�������������criteria��/��/�����᣿
        }
    }
    
    @Ignore
    @Test
    public void innerJoin2Test()
    {
        Date date = new Date("2017/5/5");
        Criteria c = join.session.createCriteria(Person.class);
        c.createCriteria("planet", "a");                          //ע�ͺ�����˵����д����������inner join��
//        c.add(Restrictions.gt("birth", date));        //����
//        c.add(Restrictions.ge("a.id", 4));              //ok,,��һ��д��a.planet_id�ˡ�������
        List<Person> pL = c.list();
        int i = 0;
        for(Person p : pL)
        {
            i++;
            assert(p.getId() != 10);        //10��planet_idΪnull
            System.out.println(p);      //����toStringҲû�з���sql��
        }
        System.out.println(i);      //14������Ӧ����Person�ܹ�15��������id=10��û��planet_id
    }
    
    
//    @Ignore
//    @Test
//    public void innerJoin3Test()
//    {
//        Date date = new Date("2017/5/6");
//        Criteria c = join.session.createCriteria(Person.class);
//        c.createAlias(Planet.class.getName(), "a");           //����������,�Ҳ��������������
//        c.add(Restrictions.eq("a.planet_id", "planet_id"));
//        List<Person> pL = c.list();
//    }
    
    
    /**
     * ��������˵��criteria���ܹ�����ѯû�������ϵ�ı�������
     * ��ôcriteria�϶�û��on���������
     * */
    
    
    @Ignore
    @Test
    public void leftJoinTest()
    {
        Date date = new Date("2017/5/5");
        Criteria c = join.session.createCriteria(Person.class);
//        c.add(Restrictions.eqProperty(propertyName, otherPropertyName))       //��������Ժ����ԵĶԱȡ�
//        c.add(Restrictions.leProperty(propertyName, otherPropertyName));
        c.createAlias("planet", "b", Criteria.LEFT_JOIN);           //�Ҳ��������õġ���
        List<Person> pL = c.list();
        int i = 0;
        for(Person p : pL)
        {
            i++;
            System.out.println(p);
        }
        System.out.println(i);              //15��.������person_id��˳��ģ������Ӳ���
    }
    
    
    @Ignore
    @Test
    public void createCriteriaOrAliasTest()
    {
        Date date = new Date("2017/6/5");
        Criteria c = join.session.createCriteria(Person.class);
//        c.createAlias("planet", "b", Criteria.LEFT_JOIN);
//        c.createCriteria("planet").add(Restrictions.idEq(4));     //planet id = 4
//        c.add(Restrictions.idEq(4));          //person id = 4
        
//        c = c.createCriteria("planet");
//        c.add(Restrictions.idEq(4));      //planet id = 4
        
        c = c.createAlias("planet", "b");
        c.add(Restrictions.idEq(4));        //person id = 4
        
        List<Person> pL = c.list();
        int i = 0;
        for(Person p : pL)
        {
            i++;
            System.out.println(p);
        }
        System.out.println(i);
    }
    
    @Ignore
    @Test
    public void rightJoinTest()
    {
        Date date = new Date("2017/6/6");
        Criteria c = join.session.createCriteria(Person.class);
//        c.createAlias("planet", "b", );           //planet_id�Ǵ�ġ�...����Ӳ���Ҳ������������ö��ֵ����
        
        int i = 0;
        List<Person> pL = c.list();
        for(Person p : pL)
        {
            i++;
            System.out.println(p);
        }
        System.out.println(i);          //....Ҳ��û��10��һ��14������Ϊplanet�ϲ�����10��û�У�ǰ���������ӵġ�������û�����ö��ֵ��
    }
    
    @Ignore
    @Test
    public void testTest()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -3);;
        Date date = cal.getTime();          //ֱ��Date date = new Date("2010-1-1"); �Ǵ���ģ�����ʱ�޷���ʼ����Ӧ��ֻ��"2011/1/1"����
        System.out.println(date);
        Criteria c = join.session.createCriteria(Person.class);
        c.add(Restrictions.gt("birth", date));
        List<Person> pL = c.list();
        for(Person p : pL)
        {
            System.out.println(p);      //toString�������planet�����Ա�Ȼ����һ��sql����ѯplanet�ģ������Ƿ�������
        }
    }
}
