package aug.tn.springformat;

public class SpringFormat {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String s1 = "asd";
        String s2 = String.format("%10s",s1);
        String s3 = s1.format("%10s", s1);          //�������βΡ����Ӧ����static������
        String s4 = s1.format("%10s", s1);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
