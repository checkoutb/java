package com.wb.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ZooTest {


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wb/ioc/IOCtest.xml");
        Zoo z = ctx.getBean("zoo", Zoo.class);
        System.out.println(z.toString());
    }

}
