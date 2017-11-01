package com.wb.sth;

import javax.annotation.Resource;

import org.junit.experimental.theories.Theories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StaticIOC {

//    @Autowired
//    @Value("asd")
//    private String str;

//    public String getStr() {
//        return str;
//    }
//
//    public void setStr(String str) {
//        this.str = str;
//    }

//    @Resource(name="AsAA")          //写名字以后，必须这个名字，。不会 按类型
//    @Resource(type=AAA.class)       //依然优先name，把a那个bean改名 会报 不是唯一bean，因为还有个AAA也是这个类型的。
//    @Autowired                  //ca,这个还是按名字的，如果把a改名，就报不是唯一，，不知道是 按名字，还是按类型+有2个类型的再看名字？
    @Autowired
//    @Qualifier("AAA")
    private AAA a;
    
    public AAA getA() {
        return a;
    }

//    @Resource
    public void setA(AAA a) {
        this.a = a;
    }

    public static void main(String[] args)
    {
//        ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext2.xml");         // src下
        
        ApplicationContext apc = new ClassPathXmlApplicationContext("com/wb/sth/applicationContext3.xml");      //包名
        StaticIOC si = apc.getBean("StaticIOC", StaticIOC.class);
//        StaticIOC s = new StaticIOC();
        System.out.println(si.getA().getA() + ", " + si.getA().getS());
        System.out.println();
    }
}
