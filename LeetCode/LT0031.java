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

	//。。主要是后面的数字是降序排列的，只要互换变成升序排列就可以了。不用sort。sort的话是对倒序排序，，速度肯定慢。。
	//...脑子不够用。。。这个各种错。还是低级错误，主要是2个变量互换，写一个互换就错一个。。还有边界值。
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
		int t = nums[i];		//顶点,也是最大值
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
	
	
	//全tm错在j=-1上了，第一次是就只有1个数字的，那么i必然为0，j就等于-1了。会报数组越界。就加了一个判断j小于0，设为0.
	//第二次是错在3,2,1，这个期望的是123，但是我那时是没有ifj<0的eles部分的。而且是j<0就等于0，导致只有后2个数排序。
	//而且j<0就等于0有点奇怪。所以后来就改成，j<0，不会寻找j后面的数中大于nums[j]的最小数。这样就不会越界了。
	public static void lt31(int[] nums)
	{
		//beat 6%...这个有点。。。第二次提交10%。。而且网站真的慢。。
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
		int t = nums[i];		//顶点,也是最大值
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
