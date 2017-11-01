package com.wb.aop;

public class Fun_PointCut {

    
    public void printPointCut1()
    {
        System.out.println("this is pointCut 1");
    }
    
    @SuppressWarnings("unused")
    public void printPointCut2()
    {
        int x = 4;
        System.out.println("this is pointcut 2");
//        throw new ClassNotFoundException();
        throw new NullPointerException();
    }
    
    public void printPointCut3()
    {
        System.out.println("this is pointcut 3");
    }
}
