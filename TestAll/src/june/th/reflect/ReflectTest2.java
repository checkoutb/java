package june.th.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 */
public class ReflectTest2 {

	/**
	 */
	public static void main(String[] args) {
		
		InvocationHandler2 handler = new InvocationHandler2();
		InterfaceOfTest sub = (InterfaceOfTest) handler.bind(new InterfaceOfTestImpl());
//		Object sub2 = handler.bind(new InterfaceOfTestImpl());
		String info = sub.Say("zxc", 33);
		System.out.println(info);
		
		String arg = "Say";
		Method mm = null;
		Method[] m = sub.getClass().getMethods();
		for(Method m2 : m)
		{
			if(arg.equals(m2.getName()))
			{
				mm = m2;
				break;
			}
		}
		
		try {
//			InterfaceOfTest iot = InterfaceOfTestImpl.class.newInstance();
			info = (String) handler.invoke(sub, mm, new Object[]{"qweqwe", 111});			//....error
			System.out.println(info);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
