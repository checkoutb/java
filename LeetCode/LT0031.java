package No1_No50;

public class LT31
{
	public static void showArray(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		int a[] = new int[]{3,2,1};
		//use 21543,121,1,321,,,2,2,7,5,4,3,2,2,1
		lt31a(a);
		showArray(a);
//		System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " + a[4]);
//		System.out.println(a[0]);
//		System.out.println(a[0] + " " + a[1] + " " + a[2]);
	}

	//������Ҫ�Ǻ���������ǽ������еģ�ֻҪ��������������оͿ����ˡ�����sort��sort�Ļ��ǶԵ������򣬣��ٶȿ϶�������
	//...���Ӳ����á�����������ִ����ǵͼ�������Ҫ��2������������дһ�������ʹ�һ���������б߽�ֵ��
	public static void lt31a(int[] nums)
	{
		//beat 10%,60%,60%.
		int length = nums.length;
		int i = length - 1;
		int j = i;
//		System.out.println(length);
//		length--;
		for(; i > 0; i--)
		{
			if(nums[i] > nums[i-1])
			{
				break;
			}
		}
		
		int t1, k;
		int t = nums[i];		//����,Ҳ�����ֵ
//		j = i++ - 1;			//2,1,5,,i is 2,,i++ is 3.but won't make a error,before i use k=i,....,after use k=i,,it will make indexOutOfBounds..
		j = i - 1;
		
		System.out.println(i + " " + j);
		if (j < 0) // ...nums.length==1..or321...
		{
			System.out.println(nums[0] + " " + nums[1] + " " + nums[2] + " ");
			for(i = 0; i < length/2; i++)
			{
				t1 = nums[i];
				nums[i] = nums[length-1-i];
				nums[length-1-i] = t1;
			}
			System.out.println(nums[0] + " " + nums[1] + " " + nums[2] + " ");
		} else
		{
			showArray(nums);
			t1 = nums[j];
			
			k = i; // !!! not 0..

			for (; i < length; i++)
			{
				if (nums[i] <= t1)		//!! ==!!
				{
					t = nums[i-1];
					k = i-1;
					break;
				}
			}
			if(i == length && nums[j]!=nums[i-1])
			{
				System.out.println("  zzzzz  ");
				k = i-1;
				t = nums[k];
			}
			nums[k] = t1;
			nums[j] = t;
			showArray(nums);
			System.out.println(k + " " + j);
			i = 1;
			j++;
			k = j + (length-j)/2;
			for(; j < k; i++, j++)
			{
				t1 = nums[j];
				nums[j] = nums[length-i];
				nums[length-i] = t1;
			}
		}
		
	}
	
	
	//ȫtm����j=-1���ˣ���һ���Ǿ�ֻ��1�����ֵģ���ôi��ȻΪ0��j�͵���-1�ˡ��ᱨ����Խ�硣�ͼ���һ���ж�jС��0����Ϊ0.
	//�ڶ����Ǵ���3,2,1�������������123����������ʱ��û��ifj<0��eles���ֵġ�������j<0�͵���0������ֻ�к�2��������
	//����j<0�͵���0�е���֡����Ժ����͸ĳɣ�j<0������Ѱ��j��������д���nums[j]����С���������Ͳ���Խ���ˡ�
	public static void lt31(int[] nums)
	{
		//beat 6%...����е㡣�����ڶ����ύ10%����������վ���������
		int length = nums.length;
		int i = length - 1;
		int j = i;
//		System.out.println(length);
//		length--;
		for(; i > 0; i--)
		{
			if(nums[i] > nums[i-1])
			{
				break;
			}
		}
		
		int t1, k;
		int t = nums[i];		//����,Ҳ�����ֵ
//		j = i++ - 1;			//2,1,5,,i is 2,,i++ is 3.but won't make a error,before i use k=i,....,after use k=i,,it will make indexOutOfBounds..
		j = i - 1;
		
		System.out.println(i + " " + j);
		if (j < 0) // ...nums.length==1.....
		{
			;
		} else
		{
			t1 = nums[j];
			k = i; // !!! not 0..

			for (; i < length; i++)
			{
				if (nums[i] < t && nums[i] > t1)
				{
					t = nums[i];
					k = i;
				}
			}
			nums[k] = t1;
			nums[j] = t;
		}
		
		//sort
		for(i = j+1; i < length-1; i++)
		{
			t = i;
			for(k = i; k < length; k++)
			{
				if(nums[t] > nums[k])
				{
					t = k;
				}
			}
			if(t != i)
			{
				t1 = nums[t];
				nums[t] = nums[i];
				nums[i] = t1;
			}
		}
		
	}
}
