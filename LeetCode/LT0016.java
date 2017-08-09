

import java.util.Arrays;

public class LT0016 {

	public static void main(String[] args) {
		
		int[] nums = new int[]{-1, 2, 1, 4};
		int target = 1;
		nums = new int[]{4,-8,98,-51,73,12,-31,39,87,-16,20,69,18,59,54,44,-58,40,-36,22,-60,-8,-43,83,88,1,-25,71,-53,33,60,32,61,-5,28,38,-28,45,25,-68,-60,-87,5,-94,-19,-31,-35,-29,0,24,-62,-84,-7,-94,-89,12,97,-32,-89,92,-50,-54,-18,12,84,-81,-99,67,24,-4,-88,61,48,-17,-17,-44,65,-18,-47,68,0,-7,78,36,0,-15,23,-4,1,-74,-64,-53,-82,-10,34,-57,-93,65,-3,-73,-8,-59,96,35,51,49,92,-8,-4,-100,-64,5,-86,-26,71,60,-85,-42,-13,-10,17,-11,59,-14,-5,34,-36,24,9,78,48,24,-88,-46,-76,31,-47,-68,29,34,-97,-69,-41,-87,-42,96,0,-90,51,-55,57,86,-61,41,1,-90,-9,63,84,-32,80,-15,-12,0,72,-22,-6,-64,94,23,-80,-25,-37,-38,69,12,-64,-95,-65,5,15,-31,-68,-55,-100,-89,-24,-66,33,-14,-40,-50,-19,-79,-4};
		target = -76;
		nums = new int[]{0,1,2};
		target = 0;
		nums = new int[]{1,1,-1};
		target = 2;
		nums = new int[]{-3,-2,-5,3,-4};
		target = -1;
		
		nums = new int[]{1,2,4,8,16,32,64,128};
		target = 82;
		
		nums = new int[]{47,-48,-72,97,-78,50,-22,18,9,24,28,-53,44,-96,50,45,86,11,21,-44,67,83,55,-86,-33,0,-53,-94,-60,57,-72,-73,-27,13,91,80,18,-80,-29,-69,-74,-90,54,22,3,91,-47,-32,80,-55,69,-95,62,-92,4,-86,62,3,23,-30,-4,0,49,24,10,-32,79,-99,-66,-30,-83,-13,90,-27,9,-4,9,98,-70,-19,32,24,-77,83,11,-78,-94,4,41,61,20,96,-36,54,-46,-51,91,54,30,-42,82,0,9,24,-2,32,-16,-18,87,23,78,-10,-82,-67,68,-18,-61,91,-90,-53,67,-48,12,1,-71,-99,31,82,39,-56,23,-89,-58,19,-60,39,-23,-76,-85,67,-33,69,-74,-8,-99,52,-70,-71,85,-8,28,-3,-100,18,88,5,-16,17,91,-35,22,-76};
		target = 298;
		System.out.println(threeSumClosest(nums, target));
	}

	//beat 6%,,,边界值一直错，各种越界。。
    public static int threeSumClosest(int[] nums, int target) {
//        int s = nums[0]*3;
        Arrays.sort(nums);
//        int s = nums[nums.length-1]*3;
        if(nums.length < 3)
        	return 1;
        int s = nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3];
        
        for(int qq = 0; qq < nums.length; qq++)
        {
        	System.out.print(nums[qq] + ", ");
        }
        System.out.println();
        
        	
        int l = nums.length;
//        int zero = findCloseIndex(nums, 0, l-1, target);
        int k = 0;
        int index = 0;
//        System.out.println("zz " + zero);
        for(int i = 0; i <= l-3; i++)
        {
        	for(int j = (l-1); j >= i; j--)
        	{
        		k = target - nums[i] - nums[j];
//        		System.out.println("kkk " + k);
        		if(i+1 > j-1)
        			break;
        		index = findCloseIndex(nums, i+1, j-1, k);
//        		System.out.println("index .." + index + "." + i + ".." + j);
        		if(nums[index] == k)
        		{
        			System.out.println(i + " " + j + " " + k);
        			return target;
        		}
        		k = nums[i] + nums[j] + nums[index];
        		System.out.println("kk.." + k);
        		if(Math.abs(k-target) <= Math.abs(s-target))
        		{
        			s = k;
        			System.out.println(".." + s);
        		}
        	}
        }
        
        
        
        return s;
    }
    
    
    public static int findCloseIndex(int[] nums, int s, int e, int t)
    {
    	int step = (e-s)/2;
    	int cl = s;
    	if(nums[s] >= t)
    	{
    		return s;
    	}
    	if(nums[e] <= t)
    	{
    		return e;
    	}
    	
    	if(step < 6)
    	{
    		for(cl = s; cl <= e; cl++)
    		{
    			if(nums[cl] >= t)
    			{
    				break;
    			}
    		}
    		if(cl > 0 && nums[cl]-t >= t-nums[cl-1])
    		{
    			return cl-1;
    		}
    		else
    		{
    			return cl;
    		}
    	}
    	
    	while(step > 5 && cl+step >= s && cl+step <= e)
    	{
    		if(nums[cl+step] > t)
    		{
    			step /= 2;
    			cl -= step;
    		}
    		else if(nums[cl+step] < t)
    		{
    			step /= 2;
    			cl += step;
    		}
    		else
    		{
    			return cl+step;
    		}
    	}
    	
    	System.out.println("```" + s + " .." + e);
    	step = cl + 5;
    	if(cl-6 < 0)
    	{
    		cl = 0;
    	}
    	else
    	{
    		cl -= 6;
    	}
    	if(step+6 > e)
    	{
    		step = e;
    	}
    	else
    	{
    		step += 6;
    	}
    	for(; cl <= step; cl++)
    	{
    		if(nums[cl] >= t)
    		{
    			break;
    		}
    	}
    	if(cl > 0 && nums[cl]-t <= t-nums[cl-1])
		{
			return cl-1;
		}
		else
		{
			return cl;
		}
    }
    
    //返回>=0中最小的下标，这个错的。应该是>=target的最小下标。。这个方法没有用到。
    public static int findZero(int[] nums)
    {
    	int l = nums.length;
    	int step = l/3;
    	int zero = step+1;
    	if(nums[0] >= 0)
    	{
    		return 0;
    	}
    	if(nums[l-1] <= 0)
    	{
    		return (l-1);
    	}
    	
    	if(step <= 5)
    	{
    		for(zero = 0; zero < l; zero++)
    		{
    			if(nums[zero] >= 0)
    			{
    				return zero;
    			}
    		}
    	}
    	while(step > 5 && zero+step >= 0 && zero+step < l)
    	{
    		if(nums[zero + step] > 0)
    		{
    			step /= 2;
    			zero -= step;
    		}
    		else if(nums[zero + step] < 0)
    		{
    			step /= 2;
    			zero += step;
    		}
    		else
    		{
    			//==0
    			return (zero + step);
    		}
    	}
    	step = zero;
    	if(zero-6 < 0)
    	{
    		zero = 0;
    	}
    	else
    	{
    		zero -= 6;
    	}
    	if(step+6 > l-1)
    	{
    		step = l-1;
    	}
    	else
    	{
    		step += 6;
    	}
    	for(; zero < step; zero++)
    	{
    		if(nums[zero] >= 0)
    		{
    			break;
    		}
    	}
    	return zero;
    }
}
