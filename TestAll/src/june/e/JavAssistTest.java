package june.e;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ConstPool;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;
import june.se.thread.MyAnnotation;

/**
 */
public class JavAssistTest {

	/**
	 */
	public static void main(String[] args) {
		try {
			AnnoTest();
			System.out.println("\n");
			ChangeTest();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//。。。
	public static void ChangeTest() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, IOException
	{
		ClassPool cp = ClassPool.getDefault();
		CtClass ct = cp.get("june.se.MyAnnotation");
		CtMethod[] cms = ct.getDeclaredMethods();
		CtMethod cm = cms[0];
		System.out.println(cm.getName());
		MethodInfo mi = cm.getMethodInfo();
		
		CtField cf = ct.getField("aa");
		FieldInfo fi = cf.getFieldInfo();
		System.out.println(cf.getName());
		
		ConstPool conp = fi.getConstPool();
		AnnotationsAttribute attr = new AnnotationsAttribute(conp, AnnotationsAttribute.visibleTag);
		Annotation anno = new Annotation("june.se.wb", conp);
		
		anno.addMemberValue("name", new StringMemberValue("changeeddd", conp));
		attr.setAnnotation(anno);
		fi.addAttribute(attr);			//加载
		
		Annotation anno2 = attr.getAnnotation("june.se.wb");
		String text = ((StringMemberValue)anno2.getMemberValue("name")).getValue();
		
		System.out.println("the last of last : " + text + "\n\n");
		
		
		
		
		Class<?> c = MyAnnotation.class;
		java.lang.annotation.Annotation[] annos = c.getAnnotations();
		for(java.lang.annotation.Annotation a : annos)
		{
			System.out.println(a);		//类的注解
		}
		
		Field[] f = c.getDeclaredFields();
		for(Field ff : f)
		{
			System.out.println(ff.getName());
			if("aa" == ff.getName())
			{
				java.lang.annotation.Annotation[] aaa = ff.getAnnotations();
				System.out.println("if " + aaa[0] + " sum " + aaa.length);			//没有变。
			}
		}
		
		System.out.println("-----------------------\n");
		
		
	/*	//可以，输出后的class反编译，被改了。。。但是我想要的是修改对象的。而不是修改类的。在对象上增加/减少注解，并可以修改注解的值。
		//
		byte[] b = ct.toBytecode();
		FileOutputStream fos = new FileOutputStream(new File("e://asd.class"));
		fos.write(b);
		fos.close();*/
		
		
		Class<?> cla = ct.toClass();		//。。。
//		Object ob = cla.newInstance();
		System.out.println(".......");
		c = cla.getClass();
		f = c.getDeclaredFields();
		for(Field ff : f)
		{
			System.out.println(ff.getName());
			if("aa" == ff.getName())
			{
				java.lang.annotation.Annotation[] aaa = ff.getAnnotations();
				System.out.println("22  " + aaa[0] + " s " + aaa.length);
			}
		}
	}
	
	public static void AnnoTest() throws NotFoundException
	{
		ClassPool cp = ClassPool.getDefault();
		CtClass ct = cp.get("june.se.MyAnnotation");
		CtMethod[] cms = ct.getDeclaredMethods();
		CtMethod cm = cms[0];
		System.out.println(cm.getLongName());		//longname带包。
		MethodInfo mi = cm.getMethodInfo();
		System.out.println(mi);
		
		CtField cf = ct.getField("aa");
		FieldInfo fi = cf.getFieldInfo();
		System.out.println(cf.getName());
		System.out.println(fi);
		
		AnnotationsAttribute attr = (AnnotationsAttribute) fi.getAttribute(AnnotationsAttribute.visibleTag);
		System.out.println(attr);
		
		Annotation anno = attr.getAnnotation("june.se.wb");
		System.out.println(anno);
		
		String text = ((StringMemberValue)anno.getMemberValue("name")).getValue();
		System.out.println(text);
	}

}
