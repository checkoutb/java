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

//    @Resource(name="AsAA")          //д�����Ժ󣬱���������֣������� ������
//    @Resource(type=AAA.class)       //��Ȼ����name����a�Ǹ�bean���� �ᱨ ����Ψһbean����Ϊ���и�AAAҲ��������͵ġ�
//    @Autowired                  //ca,������ǰ����ֵģ������a�������ͱ�����Ψһ������֪���� �����֣����ǰ�����+��2�����͵��ٿ����֣�
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
//        ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext2.xml");         // src��
        
        ApplicationContext apc = new ClassPathXmlApplicationContext("com/wb/sth/applicationContext3.xml");      //����
        StaticIOC si = apc.getBean("StaticIOC", StaticIOC.class);
//        StaticIOC s = new StaticIOC();
        System.out.println(si.getA().getA() + ", " + si.getA().getS());
        System.out.println();
    }
}
