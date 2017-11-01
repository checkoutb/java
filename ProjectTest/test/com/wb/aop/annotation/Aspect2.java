package com.wb.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Aspect2 {          //和 @Aspect重名了，，@的时候就要包名+Aspect

    
    // pointcut
    
    @Pointcut("execution(public * print*Cut1(..))")
    private void pointCut1(){}               // must void
    
    @Pointcut("execution(* com.wb.aop.*.*Cut*(..))")            //不知道 不写() 是什么
    public void pointCut(){}
    
    //这个也挺深的，还可以合并。不写了。
    
    
    
    
    
    
    
    
    
    
    
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
    
    
//    @After("com.wb.aop.annotation.PointCut.printPointCut2()")         //这种会报错，好像是aspec,jdk，spring版本的问题
    @After("execution(* com.wb.aop..*.*Cut*(..))")
    public void after()
    {
        ++a;
        System.out.println("this is after " + a);
    }
    
    @Before("execution(* com.wb.aop..*.*Cut*(..))")     // .. 就是 包+子包
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
