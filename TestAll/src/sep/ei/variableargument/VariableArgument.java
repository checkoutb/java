package sep.ei.variableargument;

public class VariableArgument {

    public static void main(String[] args) {

        VariableArgument va = new VariableArgument();
        va.kebian("aaa", 4,3,2,6,6,6,6,0);
        System.out.println();
        va.kebian("bb", 1, 3);      //不可变的那个
        System.out.println();
        va.kebian("ccc", new int[]{3,2,1,7,8,9,5,6,7});     //调用 可变的那个。
        System.out.println();
        va.kebian("zzz");
    }

    
    public void kebian(String str, int...arr)
    {
        System.out.println(str);
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + ", ");
        }
    }
    
    public void kebian(String str, int a, int b)
    {
        System.out.println("bukebian" + str + ", " + a + ", " + b);
    }
}
