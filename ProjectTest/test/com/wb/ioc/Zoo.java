package com.wb.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Zoo {

    @Autowired
    private Monkey m;

//    public Monkey getM() {
//        return m;
//    }
//
//    public void setM(Monkey m) {
//        this.m = m;
//    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Zoo [m=" + m + "]";
    }
    
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/wb/ioc/IOCtest.xml");
        Zoo z = new Zoo();
        System.out.println(z.toString());
    }
    
}
