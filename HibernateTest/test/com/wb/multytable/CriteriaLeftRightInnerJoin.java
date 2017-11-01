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
            System.out.println(p);              //和testTest的区别是：内连接，所以person_id=10的那个就不会被搜索到。。toString没有发出sql。。就是planet的属性已经被缓存下来了。
                                                //但是好像没有办法直接获得planet，而不是通过person来获得planet
                                                //还有就是没有外键关系的两个表如何用criteria内/左/右联结？
        }
    }
    
    @Ignore
    @Test
    public void innerJoin2Test()
    {
        Date date = new Date("2017/5/5");
        Criteria c = join.session.createCriteria(Person.class);
        c.createCriteria("planet", "a");                          //注释好像是说，不写联结类型是inner join？
//        c.add(Restrictions.gt("birth", date));        //可以
//        c.add(Restrictions.ge("a.id", 4));              //ok,,第一次写成a.planet_id了。。报错。
        List<Person> pL = c.list();
        int i = 0;
        for(Person p : pL)
        {
            i++;
            assert(p.getId() != 10);        //10的planet_id为null
            System.out.println(p);      //这里toString也没有发出sql。
        }
        System.out.println(i);      //14个，，应该是Person总共15条，但是id=10的没有planet_id
    }
    
    
//    @Ignore
//    @Test
//    public void innerJoin3Test()
//    {
//        Date date = new Date("2017/5/6");
//        Criteria c = join.session.createCriteria(Person.class);
//        c.createAlias(Planet.class.getName(), "a");           //不能这样的,找不到属性这个属性
//        c.add(Restrictions.eq("a.planet_id", "planet_id"));
//        List<Person> pL = c.list();
//    }
    
    
    /**
     * 看到网上说：criteria不能关联查询没有外键关系的表。。。。
     * 那么criteria肯定没有on这个东西。
     * */
    
    
    @Ignore
    @Test
    public void leftJoinTest()
    {
        Date date = new Date("2017/5/5");
        Criteria c = join.session.createCriteria(Person.class);
//        c.add(Restrictions.eqProperty(propertyName, otherPropertyName))       //这个是属性和属性的对比。
//        c.add(Restrictions.leProperty(propertyName, otherPropertyName));
        c.createAlias("planet", "b", Criteria.LEFT_JOIN);           //找不到可以用的。。
        List<Person> pL = c.list();
        int i = 0;
        for(Person p : pL)
        {
            i++;
            System.out.println(p);
        }
        System.out.println(i);              //15条.这里是person_id按顺序的，内连接不是
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
//        c.createAlias("planet", "b", );           //planet_id是错的。...靠，硬是找不到右连接这个枚举值。。
        
        int i = 0;
        List<Person> pL = c.list();
        for(Person p : pL)
        {
            i++;
            System.out.println(p);
        }
        System.out.println(i);          //....也是没有10，一共14个。因为planet上不存在10。没有，前面是内连接的。右连接没有这个枚举值。
    }
    
    @Ignore
    @Test
    public void testTest()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -3);;
        Date date = cal.getTime();          //直接Date date = new Date("2010-1-1"); 是错误的，运行时无法初始化。应该只有"2011/1/1"这种
        System.out.println(date);
        Criteria c = join.session.createCriteria(Person.class);
        c.add(Restrictions.gt("birth", date));
        List<Person> pL = c.list();
        for(Person p : pL)
        {
            System.out.println(p);      //toString里输出了planet，所以必然会有一条sql来查询planet的，无论是否懒加载
        }
    }
}
