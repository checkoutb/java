package com.wb.aop.annotation;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAnnoTest {

    
    
//    @Ignore
    @Test
    public void aopAnnoTest()
    {
        
        BeanFactory apx = new ClassPathXmlApplicationContext("com/wb/aop/annotation/aopConfig3.xml");
        
        PointCut pc = apx.getBean("pointCut", PointCut.class);
        
        
        pc.printPointCut1();
        
        System.out.println("\n\n");
        
        
        pc.printPointCut2();
        
        
    }
}
