package com.wb.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Aspect2 {          //�� @Aspect�����ˣ���@��ʱ���Ҫ����+Aspect

    
    // pointcut
    
    @Pointcut("execution(public * print*Cut1(..))")
    private void pointCut1(){}               // must void
    
    @Pointcut("execution(* com.wb.aop.*.*Cut*(..))")            //��֪�� ��д() ��ʲô
    public void pointCut(){}
    
    //���Ҳͦ��ģ������Ժϲ�����д�ˡ�
    
    
    
    
    
    
    
    
    
    
    
    private int a;
    
    @Around("execution(* com.wb.aop..*.*Cut*(..))")
    public void around(ProceedingJoinPoint pointCut) throws Throwable
    {
        ++a;
        System.out.println("this is around start " + a);
        
        try {
            pointCut.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
//            throw e;
        }
        
        ++a;
        System.out.println("this is around end " + a);
    }
    
    
//    @After("com.wb.aop.annotation.PointCut.printPointCut2()")         //���ֻᱨ��������aspec,jdk��spring�汾������
    @After("execution(* com.wb.aop..*.*Cut*(..))")
    public void after()
    {
        ++a;
        System.out.println("this is after " + a);
    }
    
    @Before("execution(* com.wb.aop..*.*Cut*(..))")     // .. ���� ��+�Ӱ�
    public void before()
    {
        ++a;
        System.out.println("this is before " + a);
    }
    
    public void returning()
    {
        ++a;
        System.out.println("this is returning " + a);
    }
    
//    @AfterThrowing("com.wb.aop.annotation.PointCut.printPointCut2()")         //error
    @AfterThrowing("execution(* com.wb.aop..*.*Cut*(..))")
    public void throwing()
    {
        ++a;
        System.out.println("this is throwing " + a);
    }
    

}
