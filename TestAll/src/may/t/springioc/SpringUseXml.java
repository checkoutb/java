package may.t.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 */
public class SpringUseXml {

	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String p = SpringUseXml.class.getPackage().toString();
		p += "/spring.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/may/t/springioc/spring.xml");
		BeTested bt = ctx.getBean("springAction", BeTested.class);
		System.out.println(bt);
		
		BeTested bt2 = ctx.getBean("springConstructor", BeTested.class);
		System.out.println(bt2);
		
		BeTested bt3 = ctx.getBean("springFactory", BeTested.class);
		System.out.println(bt3);
		
		BeTested bt4 = ctx.getBean("springInstance", BeTested.class);
		System.out.println(bt4);
		
		BeTested bt5 = ctx.getBean("springInstance", BeTested.class);
		System.out.println(bt5);
		
		//scope="prototype",是多例。。没有就是默认的单例。
		bt4.setId(111);
		System.out.println(bt4);
		System.out.println(bt5);
	}

}
