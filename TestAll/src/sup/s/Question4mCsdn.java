package sup.s;

public class Question4mCsdn {

    /**
     * http://bbs.csdn.net/topics/392218055
     *  ����һ��Ǹ�������ɵ�����h������һ����״ͼ�ĸ߶ȣ�����ÿ�����ӵĿ�ȶ�Ϊ1�� ��������״ͼ���ҵ�����ɵ������ε������ ���hΪһ���������飬����ÿ�����ӵĸ߶ȣ����������ֵ�� 
        ��������: 
        �����������,��һ�а���һ������n(1 �� n �� 10000) 
        �ڶ��а���n������,��ʾh�����е�ÿ��ֵ,h_i(1 �� h_i �� 1,000,000) 
        �������: 
        ���һ������,��ʾ���ľ�������� 
        ʾ��1 
        ���� 
        6 
        2 1 5 6 2 3 
        ��� 
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
    
    //���ˣ�5,4,5�޷�������ȷ�Ľ��
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
