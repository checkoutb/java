package com.wb.aop;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    
//    @Ignore
    @Test
    public void aopCut1Test()
    {
        // 看反编译出来的 BeanFactory接口 是 ApplicationContext接口的 父接口的父接口。
        BeanFactory bf = new ClassPathXmlApplicationContext("com/wb/aop/aopConfig.xml");
        
        
        
        Fun_PointCut cut = new Fun_PointCut();
        cut = bf.getBean("funPointCut1", Fun_PointCut.class);           //woca,必须得用spring中的才能获得aop，自己new的没用。
        
        cut.printPointCut1();
        
        System.out.println("\n\n");
        
//        try {
            cut.printPointCut2();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
////            e.printStackTrace();
//        }
        
    }
}
