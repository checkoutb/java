package june.se.thread;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.ArrayMemberValue;
import javassist.bytecode.annotation.BooleanMemberValue;
import javassist.bytecode.annotation.IntegerMemberValue;
import javassist.bytecode.annotation.MemberValue;
import javassist.bytecode.annotation.StringMemberValue;

/**
 */
public class MyAnnotationTest {

	
	public static Class<?> setPool(Class<?> entityClass, Class<?> annotation, String atMethodName, Object atMethodValue)
	{
		Class<?> c = null;
		
		try
		{
			ClassPool cp = ClassPool.getDefault();
			CtClass clazz = cp.getCtClass(entityClass.getName());
			ClassFile cf = clazz.getClassFile();
			
			ConstPool constpool = cf.getConstPool();
			Class<java.lang.annotation.Annotation> cl = (Class<java.lang.annotation.Annotation>) annotation;
			Annotation newAnnotation = createJavassistAnnotation(constpool, entityClass.getAnnotation(cl), atMethodName, atMethodValue);
			
			AnnotationsAttribute attribute = (AnnotationsAttribute)cf.getAttribute(AnnotationsAttribute.visibleTag);
			attribute.addAnnotation((javassist.bytecode.annotation.Annotation) newAnnotation);
			cf.addAttribute(attribute);
			ClassLoader parent = entityClass.getClassLoader();
//			EntityClassLoader loader = new ClassPoolUtils().new EntityClassLoader(parent);
			EntityClassLoader loader = new EntityClassLoader(parent);
			
			
			c = clazz.toClass(loader, null);
			clazz.detach();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
	
	
	
	
    public static Annotation createJavassistAnnotation(ConstPool constpool,  
            java.lang.annotation.Annotation annotation,String atMethodName, Object atMethodVal) throws Exception {  
        Annotation annotationCopy = new Annotation(annotation.annotationType().getName(), constpool);  
        String typeName = null;  
        MemberValue mv = null;  
        for (Method m : annotation.annotationType().getDeclaredMethods()) {  
                Object value = m.invoke(annotation);  
                typeName = m.getReturnType().getSimpleName();  
                if(atMethodName.equals(m.getName())) value = atMethodVal;  
                if(typeName.equals("int"))  
                    mv = new IntegerMemberValue(constpool,(Integer)value);  
                else if(typeName.equals("String[]")){  
                    String[] stres = (String[])value;  
                    StringMemberValue[] elements = new StringMemberValue[stres.length];  
                    for(int i=0;i<stres.length;i++)  
                        elements[i] = new StringMemberValue(stres[i],constpool);  
                    ArrayMemberValue amv = new ArrayMemberValue(constpool);  
                    amv.setValue(elements);  
                    mv = amv;  
                }  
                else if(typeName.equals("boolean"))  
                    mv = new BooleanMemberValue((Boolean)value,constpool);  
                else mv = new StringMemberValue(value.toString(),constpool);  
                annotationCopy.addMemberValue(m.getName(),mv);  
        }  
        return annotationCopy;  
    }  













	/**
	 */
	public static void main(String[] args) {
		
		/*Class<MyAnnotation> a = MyAnnotation.class;
		Annotation[] anno = a.getAnnotations();
//		System.out.println(anno);
		for(Annotation aa : anno)
		{
			System.out.println(aa);
		}
		
		System.out.println("\n");
		
		Field[] f = a.getFields();		//受访问控制符的限制。getDeclaredFields不受访问控制限制。
		for(Field ff : f)
		{
			System.out.println(ff);
			anno = ff.getAnnotations();
			for(Annotation aa : anno)
			{
				System.out.println(aa);
			}
		}
		
		System.out.println("\n");
		
		Method[] m = a.getMethods();
		for(Method mm : m)
		{
//			System.out.println(mm);
			for(Annotation aa : mm.getAnnotations())
			{
				System.out.println(aa);
			}
		}*/
		
		/*Class<MyAnnotation> c = MyAnnotation.class;
		MyAnnotation ma = new MyAnnotation();
		
		Annotation[] a = c.getAnnotations();
		for(Annotation aa : a)
		{
//			System.out.println(aa.annotationType().getDeclaredAnnotations()[0]);
			System.out.println(aa.annotationType().getSimpleName());
		}*/
		
		
		
		
		
		
		
		
		
		
		
	}

}
