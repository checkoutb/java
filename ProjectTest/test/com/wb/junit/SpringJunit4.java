package com.wb.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
//        "hibernate/hibernate.cfg.xml"         //当前包继续往下找的
        "/hibernate/hibernate.cfg.xml",
        "classpath:/hibernate/model.hbm.xml",
        "/spring/serviceSpring.xml",
        "classpath:/spring/serviceTestSpring.xml"
})
public class SpringJunit4 extends AbstractTransactionalJUnit4SpringContextTests {


    
    @Test
    public void testTest()
    {
        System.out.println("O.K.");
    }
}
