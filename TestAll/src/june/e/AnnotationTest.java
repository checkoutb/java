package june.e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import june.se.thread.MyAnnotation;

/**
 */
public class AnnotationTest {

	/**
	 */
	public static void main(String[] args) {
		
		Class c = MyAnnotation.class;
		Method[] ms = c.getMethods();
		
		for(Method m : ms)
		{
			Annotation[] anno = m.getAnnotations();
			for(Annotation an : anno)
			{
				System.out.println(m.getName() + " : " + an);
			}
		}
		
		
		MyAnnotation ma = new MyAnnotation();
		
	}

}
