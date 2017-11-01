package com.wb.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Fun_Aspect {

    private int a;          // ���룬�����������������Ƕ��٣�
    
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
//            throw e;                //throw�������������������������ݲ��������throwing��around֮ǰ������throw�Ļ�throwing��ץ��
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
