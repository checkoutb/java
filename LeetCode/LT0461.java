


public class LT0461
{
	public static void main(String[] args)
	{
		int x = 4, y = 1;
		System.out.println(lt461b(x, y));
		
	}
	
	public static int lt461b(int x, int y)
	{
		//beat 17,71,46...3runtimes...
		int result = 0;
		int a = x^y;
		for(; a != 0; a = a>>4)
		{
			switch(a%16)
			{
			case 1:
			case 2:
			case 4:
			case 8:
				result++;
				break;
			case 0:
				break;
			case 3:
			case 5:
			case 6:
			case 9:
			case 10:
			case 12:
				result += 2;
				break;
			case 7:
			case 11:
			case 13:
			case 14:
				result += 3;
				break;
			case 15:
				result += 4;
			}
		}
		
		return result;
	}
	
	public static int lt461a(int x, int y)
	{
		//beat 44.93%...
		int result = 0;
		int a = x^y;
		
		for(; a != 0; a = a>>1)
		{
			if(a%2 != 0)
			{
				result++;
			}
		}
		return result;
	}
	
	public static int lt461(int x, int y)
	{
		//too slow, beat 26%
		int result = 0;
//		if(x<0&&y>=0 || x>=0&&y<0)		//用不着的。确定大于0
//		{
//			result++;
//		}
		
		while(x != 0 || y != 0)
		{
			if(x%2 != y%2)
			{
				result++;
			}
			x /= 2;
			y /= 2;
//			System.out.println(x + ", " + y);
		}
		return result;
	}
}