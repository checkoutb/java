package com.wb.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wb.model.Person;
import com.wb.model.PersonImpl;

/**
 */
public class BaseServiceImplTest {

	protected BaseService baseService;
	
	@After
	public void end()
	{
		System.out.println("\n\n" + this.getClass().getName() + " over...");
	}
	
	@Before
	public void setUp() throws Exception {
		//�ƺ�ֻд��������д�ļ���������ǰ����û��/��һ��
		//Ҫ����jdk1.8��java compiler�����Ժ󣬻�Ҫ��java build path���libraries���Ѽ��ص������汾jdkɾ��������project facets
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"spring/serviceSpring.xml", "spring/serviceTestSpring.xml"});
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/serviceSpring.xml");
		this.baseService = ctx.getBean("BaseServiceIOC", BaseService.class);
		System.out.println(this.getClass().getName() + " start...");
	}

	
	@Test
	public void testFindByClassAndId() {
		System.out.println("findByClassAndId start");
		Class<?> clazz = PersonImpl.class;
		int id = 2;
		Object result = baseService.findByClassAndId(clazz, id);
		if(result == null)
		{
			System.out.println("findByClassAndId return null...");
		}
		else
		{
			System.out.println("\nfindByClassAndId return: " + result);
		}
		assertEquals(((Person)result).getId(), id);			//����s,assertEqualssss
	}

	/**
	 * @return the baseService
	 */
	public BaseService getBaseService() {
		return baseService;
	}

	/**
	 * @param baseService the baseService to set
	 */
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

}
