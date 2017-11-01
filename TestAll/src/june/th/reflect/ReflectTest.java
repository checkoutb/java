package june.th.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javassist.Modifier;

/**
 */
public class ReflectTest {

	/**
	 * getFields()���ĳ��������еĹ�����public�����ֶΣ��������ࡣ 

getDeclaredFields()���ĳ����������������ֶΣ�������public��private��proteced��
���ǲ���������������ֶΡ�
�����private�����౾���Ϳ�������ֻ������ϧprotected���� ��д
	 */
	public static void main(String[] args) {
		
		Class c1;
		Class c2;
		Class c3;
		try {
			c1 = Class.forName("june.th.reflect.TargetClass");		//Ҫ������
			Object o1 = c1.newInstance();
			Field[] fs = c1.getFields();			//ֻ�ܻ��public�����ԣ�����������
			
			StringBuffer sb = new StringBuffer();
			sb.append(Modifier.toString(c1.getModifiers()) + " class " + c1.getSimpleName() + "{\n");
			for(Field f : fs)
			{
				sb.append("\t");
				sb.append(Modifier.toString(f.getModifiers()) + " ");
				sb.append(f.getType().getSimpleName() + " ");
				sb.append(f.getName() + ";\n");
			}
			sb.append("}");
			System.out.println(sb);
			
			Field[] fss = c1.getDeclaredFields();			//���Ի��private������
			sb.delete(0, sb.length()-1);
			sb.append(Modifier.toString(c1.getModifiers()) + " class " + c1.getSimpleName() + "{\n");
			
			for(Field f : fss)
			{
				sb.append("\t");
				sb.append(Modifier.toString(f.getModifiers()) + " ").append(f.getType().getSimpleName() + " ").append(f.getName() + ";\n");
			}
			sb.append("}");
			System.out.println(sb);
			
			sb.setLength(0);
			Field f = c1.getField("id");
			Object o4 = c1.newInstance();
//			f.setAccessible(true);			//����Ҫ��Ҫ����ν����Ϊ�����getField�ģ���public��
			f.set(o4, 5);
			System.out.println(f.get(o4));
			
			Field f2 = c1.getDeclaredField("name");
			Object o5 = c1.newInstance();
			f2.setAccessible(true);			//need
			f2.set(o5, "Neo");			//usually,o5.f2="Neo",..o5 is an instance of TargetClass
			System.out.println(f2.get(o5));
			
			TargetClass tc = new TargetClass();
			tc.setAge(11);
			tc.setId(12);
			tc.setName("zxc");
			
			System.out.println(f2.get(tc));			//666666666666
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c2 = TargetClass.class;
		
		TargetClass tc = new TargetClass();
		c3 = tc.getClass();
		
		
		try {
			System.out.println("\n\n--------------------------\n");
			Object o2 = c2.newInstance();
			Method[] ms = c2.getDeclaredMethods();
			Method m = c2.getMethod("Say");
			m.invoke(o2, null);			//o2�������m�Ƿ�����null���βΡ�
			m = c2.getMethod("Say", int.class, String.class);		//int is right ,Integer is wrong..different order means different function
			if(m == null)
			{
				System.out.println("nulllllll");
			}
			System.out.println(m);
			m.invoke(o2, 4, "adsdd");
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Object o3 = c3.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\n-------------------------------\n");
		Class c4 = new TargetClass().getClass();
		Class parentClass = c4.getSuperclass();
		System.out.println(parentClass.getName());
		Class intes[] = c4.getInterfaces();
		for(int i = 0; i < intes.length; i++)
		{
			System.out.println(intes[i]);
		}
		
		try {
			TargetClass tc2 = (TargetClass) c4.newInstance();						//-------------------------
			Constructor cons[] = c4.getConstructors();
			tc2 = (TargetClass) cons[0].newInstance(11,"asd",22);		//..0��3�������ġ�����
			//...???  add a common function (like:say(string,int)) , above will throw exception..need change index
			//it seem odd and even 's  for i add second common function, the index should be the initial value
			System.out.println(tc2.toString());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
