package com.wb.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Fun_Aspect {

    private int a;          // 在想，这个在切面里输出会是多少？
    
    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }

    public void aspectAfter()
    {
        System.out.println("this is aspect after" + a);
        a += 1;
    }
    
    public void aspectBefore()
    {
        System.out.println("this is aspect before" + a);
        a += 1;
    }
    
    public void aspectRounding(ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("this is aspect Rounding start " + a);
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
//            throw e;                //throw会结束程序，所以下面的那条数据不会输出。throwing在around之前，这里throw的话throwing能抓到
        }
        System.out.println("this is aspect Rounding end " + a);
        a++;
    }
    
    public void aspectReturning()
    {
        System.out.println("this is aspect after returning " + a);
        a = a + 1;
    }
    
    public void aspectThrowing()
    {
        System.out.println("this is aspect aftr throwing " + a);
        a += 1;
    }
}
