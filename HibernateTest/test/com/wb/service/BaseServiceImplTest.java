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
	    
	    System.out.println(p.getPlanet().getName());           //���Եģ�final���������ơ�
	    
	    p.setAge(11);      //���Եģ�final �� ������ܱ䣬��������Կ��Ա�
	    
//	    p = new PersonImpl();
	}
	
	
	@Ignore
	@Test
	public void evictResultTest()
	{
	    Person p = (Person) session.get(PersonImpl.class, 1);
	    session.evict(p);
	    System.out.println(p.getPlanet().getId());         //z �������Ҫsession����Ϊid�����������session.get��ʱ����Ѿ�������id��
	    System.out.println(p.getPlanet().getName());   //����lazyInitializationException��
	                                                //���������أ���������session�д��ڵĲ��������ص���session��evict���Ժ�
	                                        //ֻ���ڴ��д��ڵ� ��û�취 �����صġ�
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
	    System.out.println("--------------");                  //update ����� tr is active �󷢳���ֻ��һ����
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
//	    c.add(Restrictions.sqlRestriction("{alias}.person_bir>?", 2000, IntegerType.INSTANCE));    //hibernate 4.1��ʼ��������Hibernate.String������Ϊtype�ˣ�Ҫ��StringType.INSTANCE
	    //...������ôֱ����ʱ���int���ˡ���
//	    c.add(Restrictions.sqlRestriction("year({alias}.person_BIR)>?", 2000, IntegerType.INSTANCE));
	    
	    c.add(Restrictions.sqlRestriction("year({alias}.person_bir)>?", 2000, StandardBasicTypes.INTEGER));  //����ȽϺá���IntegerType.INSTANCE���˷�װ

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
	    Planet pl = (Planet) session.get(PlanetImpl.class, 4);     //û��proxy������Planet.class
	    Person p = new PersonImpl();
	    p.setAge(11);
	    p.setName("test");
	    pl.getPerson().add(p);
	    session.update(pl);            //û�м��������ᱣ�� p��.�м����Ժ���ȥ���ݿ���һ��person�������Ƿ��ظ���Ȼ��Ż�ȥ����pl �� p
	    System.out.println("================");
	    session.saveOrUpdate(p);
	    
	}
	
	
	
	@Ignore
	@Test
	public void getClassTest()
	{
	    Person p = (Person) session.get(Person.class, 4);  //��cmsϵͳ��û�취ֱ���ýӿڡ�����֪���ǲ��ǰ汾�����⣬����proxy��
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
	    StringBuilder hql = new StringBuilder("from ").append(PersonImpl.class.getName()).append(" where id=?");   //�����id=2����person_id=2�����ԡ�
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
	        System.out.println(p);     //������planet����������sql
	    }
	}
	
	
	@Ignore
	@Test
	public void criteria2RestrictionsAndSeeSQLTest()
	{
	    Planet pl3 = session.load(PlanetImpl.class, 3);        //load��ô�����󣬲�����sql����������id��3
	    System.out.println("==============");
	    Planet pl4 = session.get(PlanetImpl.class, 4);         //��ö��󣬷���sql
	    Criteria c = session.createCriteria(PersonImpl.class);
	    c.add(Restrictions.ne("planet", pl3));       //Ҫд���󡣡�
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
		tr.commit();		//�������ͱ�java.lang.IllegalStateException.session�ѹر�
							//exception because getCurrentSession,session will auto close after commit()
							//if use OpenSession,it will not throw exception
		
		session.evict(p);		//update��仹û��������Ҫ��flush�����commit�Ļ���session�͹ر���
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
		p.getPerson().add(pp);		//©�����,,Ӧ�þ����������⣬����saveֻsaveplanet��û�в���pp����
									//�㱣���ֻ��p��������pû�ģ�hibernate��ô�����Զ�����Ӹ����ء�
									//�������һ��sql����ѯPerosn����֪��Ϊʲô
		System.out.println("<<<<<<<<<<<<<<<<<");
		session.save(p);			//this function still will saveorupdate,see the code ,and the sql
									//��������3��select һ��insert���ڶ������о�insert����ȥ�ˣ��Ͼ�id��ͬ���Ѿ�����
									//����Ҳ��һ��select������ѯperson��Ϊʲô������������save����ȥselectһ�°����ѵ���cascade�����⣿??????????
						//���û��cascade������2��select��1һ��update����update������save�����ġ�,update bscause inverse=false
									
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
		//��������inverse=true�ˣ����ǻ�update������update4��(planet��setPerson����4��)������ֻҪ����ˣ�hibernate�ͻ�˳��������һ�¡�
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
		session.save(p);		//����������Ǹ�һ���ġ���ԭ��
	}
	
	@Ignore
	@Test
	public void testPersonGetPlanet()
	{
		Person p = (Person) session.get(PersonImpl.class, 3);
		System.out.println(p.getPlanet().getPerson());				//��stackoverflow......why??????
																	//Ӧ����getPerson�����⣬�ظ��ģ�person����planet��planet��person
																	//baidu������toString����д�û�����ã����´���
																	//��planet��toString�е�Person�����Ժ󣬵�ȷ�����ˣ�
																	//�ԣ���ʹ���ֻ��getPerson������������Ļ���Person��toString����
																	//���ң�perseon��planet��ȫ������(����setPerson)������ˡ��ó��ó�����
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
//			System.out.println(pp.getPlanet());		//�ᱨstackoverflow......why?????? ���档toString������
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
		System.out.println(p);		//��sql����ȡ�������ڴ��б�û�б仯�����ᷢ��sqlupdate
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
		session.update(p2);		//������ζ�����sql����ʹû�б仯
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
		session.update(p2);			//��junit�ı���cmdû�б�����NonUniqueObjectException
	}
	
	
	@Ignore
	@Test
	public void testSave()
	{
		//�������ɲ���д�Ĳ��ԣ���Ȼ��֪��Ϊʲô���ԣ�����hibernate���������������Ļ������ݿ�ҲҪ��������������
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
		String hql = "from PersonImpl where id>=1 and id<3";				//...��дʵ���࣬��һ��д�˱������ڶ���д�˽ӿ�������
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
			System.out.println(o.toString());		//�޷��������
//			System.out.println(Arrays.toString((Object[])o));
		}
	}
	
	@Ignore
	@Test
	public void testSelect3()
	{
		//testSelect2����ȷ�汾
		//���������PersonImpl�ࡣ
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
//			System.out.println(Arrays.toString((Object[])o));		//personimpl����תΪobject����ȻĬ��personimpl�ˡ���
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
		//��ô�õڶ���get�ӻ����л�ã�Ҫ�����������棿..�����Ǹ��Ͷ������ˡ��������õķ����йء�
		//session��update����˳������ڴ棬����query��executedUpdate��������ڴ档
		//...md������ݾ�û�н����ݿ⣬����update�ˡ�
		Person person = (Person) session.get(PersonImpl.class, 12);
		System.out.println(person.toString());
		person.setName("zx222csdww");
		session.update(person);
		tr.commit();				//����Ժ�Ż����õ����ݿ⣬�Żᷢ��update��䡣����Ȼ�������Ǿ�ͱ����ˣ���Ϊsession�ر��ˡ���Ҫ+2��
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
		session.refresh(person);					//�������оͲ����ȡ��ǰ�������ˡ������ǣ����������Ժ󣬻ᷢ��sql��ѯ��䣬���ӣ�û�в�ѯ���,&&��update���
		//refresh����Ӧ�������ݿ�����ݸ��µ����ص�personʵ����..yes,refresh send a select
		System.out.println("\n\n\n\n");
		person = (Person) session.get(PersonImpl.class, 13);
		System.out.println(result + ", " + person.toString());
	}
	
	@Ignore
	@Test
	public void testLoad()
	{
		//ǰ���� hbmxml��������lazy=true��or proxy="com.wb.model.PersonImpl"/com.wb.model.Person/PersonImpl/Person,,ֱ��""�������������Ϲд�����ü��ز��ˡ�
		//..����Ҫǰ�ᣬд��д ���������ء���
		//get�Ļ���д��д ���� ֱ�Ӽ��أ�
		//����lazyֻ�����������ʱ�����ð���
		Person person = (Person) session.load(PersonImpl.class, 13);
		System.out.println("--------------------------------");
		System.out.println(person.getId());			//ֻ��id�����ﲻ�ᷢ��sql
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println(person.toString());		//����sql
	}
	
	@Ignore
	@Test
	public void testGet()
	{
		Person person = (Person) session.get(PersonImpl.class, 13);		//����sql
		System.out.println("-------------------------------");
		System.out.println(person.toString());
	}
	
	@Ignore
	@Test
	public void testLoadNull()
	{
		//ObjectNotFoundException..��println��ʱ��
		Person person = (Person) session.load(PersonImpl.class, 11111);
//		System.out.println(person.toString());
	}
	
	@Ignore
	@Test
	public void testGetNull()
	{
		//NullPointerException...��println��ʱ��
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
		//hibernate������ס����cmd�޷�update������cmd�޷���ס����hibernate�޷�update
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
//      session = sf.getCurrentSession();       //Ҫ����"hibernate.current_session_context_class">thread
        session = sf.openSession();
        tr = session.beginTransaction();        //���뿪��session��������session.xxx,����query.xxx...what is query...?
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
