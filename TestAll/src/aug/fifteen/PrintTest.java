package aug.fifteen;

import java.math.BigDecimal;

public class PrintTest {

    public static void main(String[] args) {
        
        int a = 1;
        System.out.println(a++ + ", " + a++ + ", " + a++ + ", " + a++ + ", " + a++);
        System.out.println(a);
        System.out.println(++a + ", " + ++a + ", " + ++a + ", " + ++a + ", " + ++a);
        
        a = 1;
        System.out.printf("%d %d %d %d %d%n", a++, a++, a++, a++, a++);
        System.out.println(a);
        System.out.printf("%d %d %d %d %d%n", ++a, ++a, ++a, ++a, ++a);
        
        
        System.out.println("%n\n" + BigDecimal.valueOf(0, 2));
    }

}
