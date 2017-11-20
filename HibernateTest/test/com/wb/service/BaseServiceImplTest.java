package com.wb.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StandardBasicTypes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


import com.wb.model.Person;
import com.wb.model.PersonImpl;
import com.wb.model.Planet;
import com.wb.model.PlanetImpl;
import com.wb.model.m2m.M2MElder;
import com.wb.model.m2m.M2MElderImpl;
import com.wb.model.m2m.M2MJunior;
import com.wb.model.m2m.M2MJuniorImpl;


/**
 */
public class BaseServiceImplTest {

	private static SessionFactory sf;
	private static Session session;
	private static Transaction tr;
	
	
	
	
	
	
//	@Ignore
	@Test
	public void debugTest()
	{
	    Person p = session.get(PersonImpl.class, 13);
	    
	    System.out.println(p);
	}
	
	@Ignore
	@Test
	public void listNullTest()
	{
//	    String sql = "select id from person where id<-10";
	    
	    String hql = " from PersonImpl where id<-10";
	    Query q = session.createQuery(hql);
	    
	    List<Person> result = q.list();
	    
	    System.out.println(result.size());
	    
	}
	
	
	@Ignore
	@Test
	public void m2mTest()
	{
	    //error

        M2MElder eld1 = new M2MElderImpl();
        eld1.setAge((short) 55);
        eld1.setName("e_AAA");
        
        M2MElder eld2 = new M2MElderImpl();
        eld2.setAge((short) 66);
        eld2.setName("e_BBB");
        
        M2MJunior j1 = new M2MJuniorImpl();
        j1.setAge((short) 11);
        j1.setName("j_EEE");
        j1.setId(10);
        
        M2MJunior j2 = new M2MJuniorImpl();
        j2.setAge((short) 15);
        j2.setName("j_FFF");
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
        
	}
	
	
	@Ignore
	@Test
	public void testTest()
	{
	    System.out.println("test");
	}
	
	@Ignore
	@Test
	public void finalLazyTest()
	{
	    final Person p = (Person) session.get(PersonImpl.class, 100);
	    System.out.println(p.getPlanet().getId());
	    
	    System.out.println(p.getPlanet().getName());           //可以的，final并不能限制。
	    
	    p.setAge(11);      //可以的，final 是 类对象不能变，里面的属性可以变
	    
//	    p = new PersonImpl();
	}
	
	
	@Ignore
	@Test
	public void evictResultTest()
	{
	    Person p = (Person) session.get(PersonImpl.class, 1);
	    session.evict(p);
	    System.out.println(p.getPlanet().getId());         //z 这个不需要session。因为id是外键，所以session.get的时候就已经获得这个id。
	    System.out.println(p.getPlanet().getName());   //报错，lazyInitializationException、
	                                                //看来懒加载，必须是在session中存在的才能懒加载到，session中evict掉以后，
	                                        //只在内存中存在的 是没办法 懒加载的。
	}

	@Ignore
	@Test
	public void samePropertyTest()
	{
	    Person p = session.get(PersonImpl.class, 5);
	    String s = p.getName();
	    String s1 = new String(s);
	    p.setName(s1);
	    System.out.println(".............");
	    p.setName("myL");
	    System.out.println(",,,,,,,,,,,,");
	    p.setAge(22);
	    System.out.println("--------------");                  //update 语句在 tr is active 后发出。只有一条。
	}
	
	
	@Ignore
	@Test
	public void sameCriteriaTest()
	{
	    Criteria c = session.createCriteria(PersonImpl.class);
	    Criteria c1 = c.createAlias("id", "a");            // c1 == c
	    Criteria c2 = c.createCriteria("name");            // c2 != c
	    
	    System.out.println(c == c1);
	    System.out.println(c2 == c);

	}
	
	
	
	
	@Ignore
	@Test
	public void dateOfdbTest()
	{
	    String hql = " from " + PersonImpl.class.getName() + " where date(birth)='2017-9-4'";
	    List<Person> pL = session.createQuery(hql).list();
	    System.out.println(pL.size());
	    System.out.println(pL.get(0).getId());
	}
	
	
	@Ignore
	@Test
	public void detachedCriteriaTest()
	{
	    DetachedCriteria c = DetachedCriteria.forClass(Person.class);
	    c.add(Restrictions.ge("id", 6));
	    List<Person> pL = c.getExecutableCriteria(session).setMaxResults(5).list();
	    for(Person p : pL)
	    {
	        System.out.println(p);
	    }
	}
	
	
	@Ignore
	@Test
	public void aliasCriteriaTest()
	{
	    Criteria c = session.createCriteria(Person.class);
//	    c.add(Restrictions.sqlRestriction(" {alias}.person_id>55"));           //...sql!!!
//	    c.add(Restrictions.sqlRestriction("{alias}.person_BIR>2000"));
//	    c.add(Restrictions.sqlRestriction("{alias}.person_bir>?", 2000, IntegerType.INSTANCE));    //hibernate 4.1开始，不能用Hibernate.String这种作为type了，要用StringType.INSTANCE
	    //...上面怎么直接用时间和int比了。。
//	    c.add(Restrictions.sqlRestriction("year({alias}.person_BIR)>?", 2000, IntegerType.INSTANCE));
	    
	    c.add(Restrictions.sqlRestriction("year({alias}.person_bir)>?", 2000, StandardBasicTypes.INTEGER));  //这个比较好。对IntegerType.INSTANCE做了封装

	    List<Person> pL = c.list();
	    
	    for(Person p : pL)
	    {
	        System.out.println(p);
	    }
	}
	
	
	@Ignore
	@Test
	public void sqlYearTest()
	{
	    String hql = "from " + PersonImpl.class.getName() + " where year(birth)>100";
	    List<Person> pL = session.createQuery(hql).list();
	    System.out.println(pL.size());
	}
	
	
	@Ignore
	@Test
	public void updateTTtest()
	{
	    Planet pl = (Planet) session.get(PlanetImpl.class, 4);     //没有proxy，不能Planet.class
	    Person p = new PersonImpl();
	    p.setAge(11);
	    p.setName("test");
	    pl.getPerson().add(p);
	    session.update(pl);            //没有级联，不会保存 p。.有级联以后，先去数据库搜一把person的主键是否重复。然后才会去保存pl 和 p
	    System.out.println("================");
	    session.saveOrUpdate(p);
	    
	}
	
	
	
	@Ignore
	@Test
	public void getClassTest()
	{
	    Person p = (Person) session.get(Person.class, 4);  //在cms系统里没办法直接用接口。。不知道是不是版本的问题，都有proxy啊
	    System.out.println(p.getName());
	}
	
	@Ignore
	@Test
	public void hqlSqlTest()
	{
        String sql = "from " + PersonImpl.class.getName() + " b, " + PlanetImpl.class.getName() + " a  where a.id=4 and a.id=b.planet";
        Object o;
        Person person;
//        session = sessionFactory.getCurrentSession();
        
//        List result = session.createQuery(sql).list();
//        System.out.println(result.size());
        ScrollableResults cursor = session.createQuery(sql).scroll(ScrollMode.FORWARD_ONLY);
        System.out.println("aaaaaaaaaaaaa");

        while(cursor.next())
        {
            o = cursor.get(0);
            person = (Person) o;
            System.out.println(person.toString());
        }
	}
	
	
	@Ignore
	@Test
	public void hqlTest()
	{
	    StringBuilder hql = new StringBuilder("from ").append(PersonImpl.class.getName()).append(" where id=?");   //最后用id=2或者person_id=2都可以。
	    List<Person> p = session.createQuery(hql.toString()).setParameter(0, 1).list();
	    System.out.println(p.size());
	    System.out.println(p.get(0).getName());
	}
	
	
	@Ignore
	@Test
	public void sqlStatmantTest()
	{
	    String sql = "select * from Person where person_name=?";
	    
	}

	
	@Ignore
	@Test
	public void criteriaInNullTest()
	{
	    Criteria c = session.createCriteria(PersonImpl.class);
	    Set s = new HashSet();
	    if(s == null || s.isEmpty())
	    {
	        System.out.println("nullllllllllllll");
	    }
	    s.add(1000);
	    c.add(Restrictions.in("id", s));
	    List re = c.list();
	    System.out.println(re.size());
	    System.out.println(re);
//	    System.out.println(re.get(0));       //size is 0,,so ..get 0  will out of range
	}
	
	@Ignore
	@Test
	public void criteriaInTest()
	{
	    @SuppressWarnings("deprecation")
        Criteria c = session.createCriteria(PersonImpl.class);
	    Set s = new HashSet();
	    s.add(0);
	    s.add(2);
	    s.add(3);
	    c.add(Restrictions.in("id", s));
	    List re = c.list();
	    for(Object p : re)
	    {
	        System.out.println(p);     //加载了planet。。所以有sql
	    }
	}
	
	
	@Ignore
	@Test
	public void criteria2RestrictionsAndSeeSQLTest()
	{
	    Planet pl3 = session.load(PlanetImpl.class, 3);        //load获得代理对象，不发出sql，这个对象的id是3
	    System.out.println("==============");
	    Planet pl4 = session.get(PlanetImpl.class, 4);         //获得对象，发出sql
	    Criteria c = session.createCriteria(PersonImpl.class);
	    c.add(Restrictions.ne("planet", pl3));       //要写对象。。
	    c.add(Restrictions.eq("planet", pl4));
	    List<Person> rs = c.list();
	    System.out.println("-----------------------------------");
	    for( Person d : rs)
	    {
	        System.out.println(d);
	    }
	}
	
	
	@Ignore
	@Test
	public void testPersonSexOfNull()
	{
		Person p = (Person)session.get(PersonImpl.class, 5);
//		System.out.println(p);
		char n = p.getSex();
//		System.out.println(n + "\n" + " ");
		if(n == '\u0000')
		{
			//fk.i forget what i set 
			System.out.println("fk...");
			
		}
	}
	
	@Ignore
	@Test
	public void testSFcloseBeforeSessionClose()
	{
		sf.close();
		session.close();	//exception,No operations allowed after connection closed
		
	}
	
	
	@Ignore
	@Test
	public void testCommitAfterClose()
	{
		//commit after close,commit will throw exception,java.lang.IllegalStateException: org.hibernate.resource.jdbc.internal.LogicalConnectionManagedImpl@37d3d232 is closed
		//so you must commit before close
		//sth strange,after close,tr.isAvtive is true,..,my mistake,commit is not close.
		session.close();
		if(tr.isActive())
		{
			System.out.println("tr is still active after session.close()");
		}
		else
		{
			System.out.println("tr has dead after session.close()");
		}
		try
		{
//			tr.rollback();			//rollback and commit throw the same exception
			tr.commit();
		}
		catch(Exception e)
		{
			System.out.println("oh, it error");
			e.printStackTrace();
		}
	}
	
	
	@Ignore
	@Test
	public void testMySqlDecimal()
	{
		Planet p = (Planet)session.get(PlanetImpl.class, 5);
		System.out.println(p);
		p.setAge(2101121);
		session.saveOrUpdate(p);
		session.flush();
		tr.commit();		//加了这句就报java.lang.IllegalStateException.session已关闭
							//exception because getCurrentSession,session will auto close after commit()
							//if use OpenSession,it will not throw exception
		
		session.evict(p);		//update语句还没发出。。要先flush，如果commit的话，session就关闭了
		p = (Planet)session.get(PlanetImpl.class, 5);
		System.out.println(p);
		
		p.setAge(12345);
		session.update(p);
//		session.flush();	//tr has commited,flush will throw exception:no transaction is in progress
							//only update,no flush,it won't throw exception,and won't send sql.
		session.evict(p);		//if evict,hibernate will send sql,get the 210xxxx
								//if not evict,hibernate won't send sql,and p is 12345
		p = (Planet)session.get(PlanetImpl.class, 5);
		System.out.println(p);
	}
	
	
	@Ignore
	@Test
	public void testCascadeOfSaveUpdate()
	{
		Planet p = (Planet)session.get(PlanetImpl.class, 4);
		//...below is the test of saveupdate.
	}
	
	@Ignore
	@Test
	public void testCascadeOfNotDefault()
	{
		Planet p = (Planet)session.get(PlanetImpl.class, 4);
//		p.setAge(43);
		Person pp = new PersonImpl();
		pp.setAge(22);
		pp.setId(13);
		pp.setName("Marer");
		pp.setPlanet(p);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
		p.getPerson().add(pp);		//漏了这句,,应该就是这句的问题，导致save只saveplanet，没有插入pp。。
									//你保存的只是p，但是你p没改，hibernate怎么可能自动帮你加个人呢。
									//这里会有一条sql来查询Perosn，不知道为什么
		System.out.println("<<<<<<<<<<<<<<<<<");
		session.save(p);			//this function still will saveorupdate,see the code ,and the sql
									//整个方法3个select 一个insert，第二次运行就insert不进去了，毕竟id相同的已经有了
									//这里也有一句select，来查询person，为什么？，，其他的save不会去select一下啊，难道是cascade的问题？??????????
						//如果没有cascade，会有2个select，1一个update，，update是最后的save发出的。,update bscause inverse=false
									
	}
	
	@Ignore
	@Test
	public void testHibernateAutoUpdate()
	{
		Planet p = (Planet)session.get(PlanetImpl.class, 4);
		p.setAge(41);				//yes,hibernate will auto update the change .
	}
	
	
	@Ignore
	@Test
	public void testCascadeOfDefault()
	{
		//..althrough cascade="none" or default(no cascade),it still will update the person.
		//看不懂，inverse=true了，还是会update，还是update4个(planet的setPerson里有4个)，看来只要你改了，hibernate就会顺便帮你更新一下。
		//after the testHibernateAutoUpdate,this function has not relation with cascade and inverse.
		Planet p = (Planet)session.get(PlanetImpl.class, 4);
		Set<Person> plist = p.getPerson();
		System.out.println("=======================");
		
		int i = 1;
		for(Person pp : plist)
		{
			pp.setName("Mars" + i);
			i++;
		}
		System.out.println("```````````````````````");
		session.save(p);
	}
	
	
	@Ignore
	@Test
	public void testDoubleInverseFalse()
	{
		Planet p = (Planet)session.get(PlanetImpl.class, 4);
		System.out.println(p);
		p.setPerson(null);
		session.save(p);		//和下下面的那个一样的。的原因
	}
	
	@Ignore
	@Test
	public void testPersonGetPlanet()
	{
		Person p = (Person) session.get(PersonImpl.class, 3);
		System.out.println(p.getPlanet().getPerson());				//报stackoverflow......why??????
																	//应该是getPerson的问题，重复的，person里有planet，planet有person
																	//baidu到的是toString方法写得互相调用，导致错了
																	//把planet的toString中的Person改了以后，的确可以了，
																	//对，即使这边只是getPerson，但是你输出的还是Person的toString啊。
																	//而且，perseon的planet的全部属性(包括setPerson)都输出了。好长好长。。
		session.evict(p);
		p.setId(12);
//		p.setAge(32);
		p.setName("default");
//		p.setPlanet(null);
//		session.save(p);		//planet_id not null ,so cannot insert into table
		
		Person p1 = new PersonImpl();
		p1.setId(12);
		p1.setName("default");
		p1.setPlanet(p.getPlanet());
		session.save(p1);
	}
	
	@Ignore
	@Test
	public void testAddPlanetWithPerson()
	{
		Planet p = (Planet)session.get(PlanetImpl.class, 2);
//		System.out.println("11111111111111111");
		System.out.println(p.getPerson().size());
//		System.out.println("1111111111111111");
		Criteria c = session.createCriteria(PersonImpl.class);
		c.add(Restrictions.between("id", 8, 11));
		List<Person> plist = c.list();
		for(Person pp : plist)
		{
			System.out.println("------------------");
//			System.out.println(pp.getPlanet());		//会报stackoverflow......why?????? 上面。toString的问题
			pp.setAge(22);
//			p.getPerson().add(pp);
			
		}
		Set<Person> pSet = new HashSet();			//if inverse="true",do nothing.if inverse="false",it will error for person's planet_id is not null
		p.setPerson(pSet);
		System.out.println(p.getPerson().size());
		p.setAge(22);
	}
	
	@Ignore
	@Test
	public void testAddPersonPlanetWithSetPerson()
	{
		/*Planet pp = (Planet)session.get(PlanetImpl.class, 2);
		Person p = new PersonImpl();
		p.setAge(22);
		p.setId(11);
		p.setName("beauty3");
		p.setPlanet(pp);
		session.save(p);*/
	}
	
	@Ignore
	@Test
	public void testPlanetNoSetPerson()
	{
		Planet p = (Planet)session.get(PlanetImpl.class, 1);
		System.out.println(p);
		Person pp = (Person)session.get(PersonImpl.class, 5);
		System.out.println(pp);
	}
	
	@Ignore
	@Test
	public void testSelectUpdateDeleteAfterAlter()
	{
		Person p = (Person)session.get(PersonImpl.class, 5);
		System.out.println(p);
	}
	
	
	@Ignore
	@Test
	public void testNoNonUnique()
	{
		Person p = (Person)session.get(PersonImpl.class, 5);
		System.out.println(p);
		
		Person p2 = new PersonImpl();
		p2.setId(5);
		p2.setName(p.getName());
		p2.setAge(4);
		session.merge(p2);
		System.out.println(p);		//比sql语句先。如果和内存中比没有变化，不会发出sqlupdate
	}
	
	@Ignore
	@Test
	public void testNoNonUnique2()
	{
		Person p = (Person)session.get(PersonImpl.class, 5);
		System.out.println(p);
		
		Person p2 = new PersonImpl();
		p2.setId(5);
		p2.setName(p.getName());
		p2.setAge(1);
		session.evict(p);
		session.update(p2);		//无论如何都会打出sql。即使没有变化
		System.out.println(p);
	}
	
	
	
	@Ignore
	@Test
	public void testNonUnique()
	{
		Person p = (Person) session.get(PersonImpl.class, 5);
		System.out.println(p);
		
		Person p2 = new PersonImpl();
		p2.setId(5);
		p2.setName(p.getName());
		p2.setAge(31);
		session.update(p2);			//看junit的报错，cmd没有报错。。NonUniqueObjectException
	}
	
	
	@Ignore
	@Test
	public void testSave()
	{
		//主键生成策略写的不对，虽然不知道为什么不对，而且hibernate配置主键是自增的话，数据库也要设置主键自增。
		Person p = new PersonImpl();
		p.setId(5);
		p.setAge(21);
		p.setName("bbbg");
		session.save(p);
//		session.flush();
	}
	
	
	
	@Ignore
	@Test
	public void testDelete()
	{
		Person p = (Person) session.get(PersonImpl.class, 5);
		System.out.println(p);
		session.delete(p);
//		PersonImpl p2 = new PersonImpl();
////		p2.setId(5);
//		p2.setAge(33);
//		p2.setName("zzzz");
//		p2.setPhoneNumber("next");
//		session.save(p2);
	}
	
	
	/**
	 * Test method for {@link com.wb.service.BaseServiceImpl#findByClassAndId(java.lang.Class, int)}.
	 */
	@Ignore
	@Test
	public void testFindByClassAndId() {
		Person p = (Person) session.get(PersonImpl.class, 2);
		System.out.println(p);
//		tr.commit();
//		System.out.println(p);
	}

	@Ignore
	@Test
	public void testFindByClassAndId2()
	{
		Person p = (Person) session.get(PersonImpl.class, 1);
		System.out.println(p);
//		tr.commit();
//		System.out.println(p);
	}
	
	@Ignore
	@Test
	public void testSelect()
	{
		String hql = "from PersonImpl where id>=1 and id<3";				//...得写实体类，第一次写了表名，第二次写了接口名。。
		Query<?> query = session.createQuery(hql);
		List<Person> persons = (List<Person>) query.list();
		for(Object o : persons)
		{
			System.out.println(o.toString());
		}
	}
	
	@Ignore
	@Test
	public void testSelect2()
	{
		String hql = "select a.name,a.id from PersonImpl a where id>=1 and id<3";
		Query query = session.createQuery(hql);
		List<PersonImpl> list = query.list();
		System.out.println(list.size());
		for(PersonImpl o : list)
		{
			System.out.println(o.toString());		//无法输出。。
//			System.out.println(Arrays.toString((Object[])o));
		}
	}
	
	@Ignore
	@Test
	public void testSelect3()
	{
		//testSelect2的正确版本
		//这个不能用PersonImpl类。
		String hql = "select a.name,a.id,a.sex from PersonImpl as a where id>=1 and id<3";
		Query q = session.createQuery(hql);
		List list = q.list();
		for(Object o : list)
		{
			System.out.println(o.toString());
			System.out.println(Arrays.toString((Object[])o));
		}
	}
	
	@Ignore
	@Test
	public void testSelect4()
	{
		String hql = "from PersonImpl";
		Query q = session.createQuery(hql);
		q.setFirstResult(0);
		q.setMaxResults(4);
		List<?> list = q.list();
		for(Object o : list)
		{
//			System.out.println(Arrays.toString((Object[])o));		//personimpl不能转为object。竟然默认personimpl了。。
			System.out.println(o.toString());
		}
	}
	
	@Ignore
	@Test
	public void testSelect5()
	{
		String hql = "from PersonImpl where id>? and id<=?";
		Query query = session.createQuery(hql).setParameter(0, 0).setParameter(1, 4);
		List list = query.list();
		for(Object o : list)
		{
			System.out.println(o.toString());
		}
	}
	
	@Ignore
	@Test
	public void testSelect6()
	{
		String hql = "from " + PersonImpl.class.getName() + " where id in (:asd)";
		Query query = session.createQuery(hql);
		query.setParameterList("asd", new Object[]{1,2,3,4});
		List list = query.list();
		for(Object o : list)
		{
			System.out.println(o.toString());
		}
	}
	
	@Ignore
	@Test
	public void testUpdate()
	{
		//怎么让第二个get从缓存中获得？要开启二级缓存？..下面那个就读缓存了。看来和用的方法有关。
		//session的update可以顺便更新内存，但是query的executedUpdate不会更新内存。
		//...md这个数据就没有进数据库，就算update了。
		Person person = (Person) session.get(PersonImpl.class, 12);
		System.out.println(person.toString());
		person.setName("zx222csdww");
		session.update(person);
		tr.commit();				//这个以后才会作用到数据库，才会发出update语句。。当然，下面那句就报错了，因为session关闭了。。要+2句
		session = sf.getCurrentSession();
		tr = session.beginTransaction();
		person = (Person) session.get(PersonImpl.class, 12);
		System.out.println(person.toString());
	}
	
	@Ignore
	@Test
	public void testUpdate2()
	{
		Person person = (Person) session.get(PersonImpl.class, 13);
		System.out.println(person.toString());
		String sql = "Update PersonImpl set name=? where id=?";
		int result = session.createQuery(sql).setParameter(0, "youda6").setParameter(1, 13).executeUpdate();
		session.refresh(person);					//加上这行就不会读取以前的数据了。。不是，加上这行以后，会发出sql查询语句，不加，没有查询语句,&&有update语句
		//refresh方法应该是数据库的数据更新到本地的person实体中..yes,refresh send a select
		System.out.println("\n\n\n\n");
		person = (Person) session.get(PersonImpl.class, 13);
		System.out.println(result + ", " + person.toString());
	}
	
	@Ignore
	@Test
	public void testLoad()
	{
		//前提是 hbmxml里配置了lazy=true，or proxy="com.wb.model.PersonImpl"/com.wb.model.Person/PersonImpl/Person,,直接""或者其他类或者瞎写，配置加载不了。
		//..不需要前提，写不写 都是懒加载。。
		//get的话，写不写 都是 直接加载，
		//看来lazy只在外键关联的时候有用啊。
		Person person = (Person) session.load(PersonImpl.class, 13);
		System.out.println("--------------------------------");
		System.out.println(person.getId());			//只有id，这里不会发出sql
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println(person.toString());		//发出sql
	}
	
	@Ignore
	@Test
	public void testGet()
	{
		Person person = (Person) session.get(PersonImpl.class, 13);		//发出sql
		System.out.println("-------------------------------");
		System.out.println(person.toString());
	}
	
	@Ignore
	@Test
	public void testLoadNull()
	{
		//ObjectNotFoundException..是println的时候报
		Person person = (Person) session.load(PersonImpl.class, 11111);
//		System.out.println(person.toString());
	}
	
	@Ignore
	@Test
	public void testGetNull()
	{
		//NullPointerException...是println的时候报
		Person person = (Person) session.get(PersonImpl.class, 1111);
//		System.out.println(person.toString());
	}
	
	@Ignore
	@Test
	public void testGetCache()
	{
		//2get 1 select
		Person person = (Person) session.get(PersonImpl.class, 1);
		System.out.println(person.toString());
		Person person2 = (Person) session.get(PersonImpl.class, 1);
		System.out.println(person2.toString());
	}
	
	@Ignore
	@Test
	public void testLoadCache()
	{
		//2load 1select lazy=true
		Person person = (Person) session.load(PersonImpl.class, 1);
		System.out.println("_________________________");
		System.out.println(person.toString());
		Person person2 = (Person) session.load(PersonImpl.class, 1);
		System.out.println("------------------");
		System.out.println(person2.toString());
	}
	
	@Ignore
	@Test
	public void testLock()
	{
//		Person person = session.get(PersonImpl.class, 13, LockMode.UPGRADE);
		Person person2 = session.get(PersonImpl.class, 13, LockOptions.UPGRADE);
		System.out.println(person2.toString());
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void testCMDLock()
	{
		//hibernate可以锁住，让cmd无法update，但是cmd无法锁住，让hibernate无法update
		Person person = session.get(PersonImpl.class, 13);
		person.setAge(44);
		session.update(person);
	}
	
	   
    /**
     */
    @BeforeClass
    public static void setUp() throws Exception {
        Configuration conf = new Configuration();
        conf.configure("hibernate/hibernate.cfg.xml");
        sf = conf.buildSessionFactory();
//      session = sf.getCurrentSession();       //要配置"hibernate.current_session_context_class">thread
        session = sf.openSession();
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
