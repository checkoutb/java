package com.wb.aop.annotation;

public class PointCut {

    public void printPointCut1()
    {
        System.out.println("this is pointCut 1");
    }
    
    public void printPointCut2()
    {
        System.out.println("this is pointCut 2");
        throw new NullPointerException();
    }
}
