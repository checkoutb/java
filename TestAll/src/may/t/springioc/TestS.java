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
//下面这个要用到数据库的。要设置dataSource。
//public class TestS extends AbstractTransactionalJUnit4SpringContextTests  {

	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//怎么自动注入？...@Before...和
	private BeTested springAction;
	
	//这里也可以读取xml然后注入吧？当然applicationContext要用已有的。
	@Before
	public void in()
	{
		springAction = applicationContext.getBean("springAction", BeTested.class);
	}
	
	@Test
	public void testDTest()
	{
		//assert没提示，不满足直接return了。
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
