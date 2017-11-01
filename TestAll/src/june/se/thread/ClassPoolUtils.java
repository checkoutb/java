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
  


// copy from Internet..i am not TangCai


/**   
 * @Title: ClassPoolUtils.java 
 * @Package com.sgfm.scsm.util 
 * @Description: ��̬�޸�ʵ����ע���е�ֵ(���ᳫ����ʹ��) 
 * @author TangCai 
 * @date 2016��11��16�� ����3:08:56 
 * @version V1.0   
 */  
public class ClassPoolUtils {  
    /**  
     * ����ʱ��̬ORM��ӳ��  
     * @param entityClass   ʵ���� 
     * @param annotation    ע���� 
     * @param atMethodName  ע���෽�� 
     * @param atMethodVal   ע���෽���ĸ���ֵ 
     * @return              �޸�ע��ֵ��ʵ����  
     */    
    @SuppressWarnings("unchecked")  
    public static Class<?> setPool(Class<?> entityClass, Class<?> annotation,  
            String atMethodName, Object atMethodVal){    
        Class<?> c = null;  
        try {    
            ClassPool classPool = ClassPool.getDefault();    
  
            CtClass clazz = classPool.getCtClass(entityClass.getName());  
            ClassFile classFile = clazz.getClassFile();  
            //clazz.freeze();//����  
  
            ConstPool constPool = classFile.getConstPool();    
            Class<java.lang.annotation.Annotation> cl = (Class<java.lang.annotation.Annotation>)annotation;  
            Annotation newAnnotation = createJavassistAnnotation(constPool,entityClass.getAnnotation(cl),atMethodName,atMethodVal);  
              
            AnnotationsAttribute attribute = (AnnotationsAttribute)classFile.getAttribute(AnnotationsAttribute.visibleTag);    
            attribute.addAnnotation(newAnnotation);    
            classFile.addAttribute(attribute);   
            ClassLoader parent = entityClass.getClassLoader();  
            EntityClassLoader loader = new ClassPoolUtils().new EntityClassLoader(parent);  
            //clazz.toClass();//ͬһ��ClassLoader���ܶ�μ���ͬһ����  
            c = clazz.toClass(loader , null);//�滻Class��ʱ��  ���ظ�Class��ClassLoaderҲ�������µ�  
            //clazz.defrost();//�������  
            clazz.detach(); //ע��class  
        } catch (Exception e) {    
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
     * @Title: EntityClassLoader.java 
     * @Package com.sgfm.scsm.util 
     * @Description:  ʵ���������   
     * �ü�������Ҫ��������ʱ��̬�޸�ʵ�������װ��ʵ��  
     * @author TangCai 
     * @date 2016��11��16�� ����3:18:55 
     * @version V1.0   
     */  
    public class EntityClassLoader extends ClassLoader {  
         private ClassLoader parent;  
           
         public EntityClassLoader(ClassLoader parent){    
             this.parent = parent;    
         }    
  
         @Override    
         public Class<?> loadClass(String name) throws ClassNotFoundException {    
             return this.loadClass(name, false);    
         }    
           
         @Override    
         protected synchronized Class<?> loadClass(String name, boolean resolve)    
                 throws ClassNotFoundException {  
             Class<?> clazz = this.findLoadedClass(name);    
             if(null != parent)  
                 clazz = parent.loadClass(name);      
             if(null == clazz)  
                 this.findSystemClass(name);    
             if(null == clazz)  
                 throw new ClassNotFoundException();    
             if(null != clazz && resolve)  
                 this.resolveClass(clazz);  
             return clazz;    
         }    
    }  
}  