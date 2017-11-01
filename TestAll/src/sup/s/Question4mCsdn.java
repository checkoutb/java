package sup.s;

public class Question4mCsdn {

    /**
     * http://bbs.csdn.net/topics/392218055
     *  给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。 在这组柱状图中找到能组成的最大矩形的面积。 入参h为一个整型数组，代表每个柱子的高度，返回面积的值。 
        输入描述: 
        输入包括两行,第一行包含一个整数n(1 ≤ n ≤ 10000) 
        第二行包括n个整数,表示h数组中的每个值,h_i(1 ≤ h_i ≤ 1,000,000) 
        输出描述: 
        输出一个整数,表示最大的矩阵面积。 
        示例1 
        输入 
        6 
        2 1 5 6 2 3 
        输出 
        10
     * */    
    public static void main(String[] args) {
        
        int[] nums = {2,1,5,6,2,3};
        nums = new int[]{6, 2, 5, 4, 5, 1, 6};
//        area(nums);
        area2(nums);
    }
    
    
    public static void area2(int[] num)
    {
        int i, j, k, max, m, n, t;
        max = 0;
        for(i = 0; i < num.length; i++)
        {
            j = i;
            k = i;
            while(j < num.length && num[j]>=num[i])
                j++;
            j--;
            while(k >= 0 && num[k]>=num[i])
                k--;
            k++;
            
            t = (j-k+1) * num[i];
            if(t > max)
                max = t;
            
        }
        System.out.println(max);
    }
    
    //错了，5,4,5无法返回正确的结果
    @Deprecated
    public static void area(int[] num)
    {
        int i, j, max, m, n, t;
        max = 0;
        for(i = 0; i < num.length; i++)
        {
            System.out.print("#" + i);
            m = num[i];
            for(j = i; j < num.length; j++)
            {
                n = num[j];
//                System.out.print(m + ", " + n + "...");
                if(n < m)
                {
                    break;      //bushi continue
                }
                t = m * (j-i+1);
                if(t > max)
                {
                    System.out.println(m + ", " + n + "==" + t + ",,,," + i + ",," + j);
                    System.out.println();
                    max = t;
                }
            }
        }
        System.out.println();
        System.out.println(max);
    }

}
