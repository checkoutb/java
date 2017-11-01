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
        // ������������� BeanFactory�ӿ� �� ApplicationContext�ӿڵ� ���ӿڵĸ��ӿڡ�
        BeanFactory bf = new ClassPathXmlApplicationContext("com/wb/aop/aopConfig.xml");
        
        
        
        Fun_PointCut cut = new Fun_PointCut();
        cut = bf.getBean("funPointCut1", Fun_PointCut.class);           //woca,�������spring�еĲ��ܻ��aop���Լ�new��û�á�
        
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
