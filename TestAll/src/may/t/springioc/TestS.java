package may.t.springioc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations  = "classpath*:springTest.xml")
public class TestS extends AbstractJUnit4SpringContextTests  {
//�������Ҫ�õ����ݿ�ġ�Ҫ����dataSource��
//public class TestS extends AbstractTransactionalJUnit4SpringContextTests  {

	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//��ô�Զ�ע�룿...@Before...��
	private BeTested springAction;
	
	//����Ҳ���Զ�ȡxmlȻ��ע��ɣ���ȻapplicationContextҪ�����еġ�
	@Before
	public void in()
	{
		springAction = applicationContext.getBean("springAction", BeTested.class);
	}
	
	@Test
	public void testDTest()
	{
		//assertû��ʾ��������ֱ��return�ˡ�
//		assert (bt == null);
		System.out.println("-------------------------------");
		System.out.println(springAction);
		springAction = applicationContext.getBean("springAction", BeTested.class);
		System.out.println(springAction);
//		assert (springAction) != null;
	}
	
	@After
	public void efde()
	{
		System.out.println("at the last of last, we all ,who know who care");
	}

	/**
	 * @return the springAction
	 */
	public BeTested getSpringAction() {
		return springAction;
	}

	/**
	 * @param springAction the springAction to set
	 */
	public void setSpringAction(BeTested springAction) {
		this.springAction = springAction;
	}

}
