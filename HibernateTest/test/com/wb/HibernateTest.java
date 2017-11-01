package com.wb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;

import com.wb.model.Person;
import com.wb.model.PersonImpl;

/**
 */
public class HibernateTest {

	/**
	 * ֻ�����У�����junit��test��
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration conf = new Configuration();
		conf.configure("hibernate/hibernate.cfg.xml");		//���أ��и��޲η��������������configure("hibernate.hbm.xml")
		SessionFactory sf = conf.buildSessionFactory();
//		Session session = sf.openSession();				//������hibernate.current_session_context_class��ֻ��������������ã���getCurrentSession�ᱨ��
		Session session = sf.getCurrentSession();		//hibernate.cfg.xml����hibernate.current_session_context_class
		
		Transaction tr = session.beginTransaction();
		Person p = (Person)session.get(PersonImpl.class, 2);
		System.out.println(p);		//�������println���һ��
		tr.commit();
		System.out.println(p);
		session = sf.getCurrentSession();
		tr = session.getTransaction();
		if(tr == null)
		{
			System.out.println("nullll");
		}
		else
		{
			tr.begin();
		}
		p = (Person)session.get(PersonImpl.class, 3);
		
		try
		{
		session.close();
		session.close();
		sf.close();
		ThreadLocalSessionContext.unbind(sf);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void getCurrentSessionCloseTest()
	{
		Configuration conf = new Configuration();
		conf.configure("hibernate/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.getCurrentSession();
	}
}
