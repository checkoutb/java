
public class LT0201
{

	public static void main(String[] args)
	{
		LT0201 lt = new LT0201();
		
		int m = 5;	//min
		int n = 7;	//max
		
		m = 5;
		n = 7;
//		System.out.println(lt.lt201b(m, n));
		m = 0;
		n = 0;
//		System.out.println(lt.lt201b(m, n));
		m = 1;
		n = 1;
//		System.out.println(lt.lt201b(m, n));
		m = 1;
		n = 2;
//		System.out.println(lt.lt201b(m, n));
//		m = 0;
//		n = 1;
		
//		m = 2;
//		n = 3;
		m = 2;
		n = 2;
		m = 2;
		n = 3;
//		System.out.println(lt.lt201c(m, n));
		m = 3;
		n = 3;
		
		m = 3;
		n = 4;
		m = 0;
		n = 2;
		m = 5;
		n = 6;
		m = 2147483646;
		n = 2147483647;
		m = 1;
		n = 3;
		m = 6;
		n = 7;
		System.out.println(lt.lt201c(m, n));
	}

	
	// beats 3.47%....
	public int lt201c(int m, int n)
	{
//		System.out.println(Integer.MAX_VALUE);
		if(m == n)
		{
			return m;
		}
		long[] arr = new long[33];
		long a = 1;
		arr[0] = 0;
		for(int i = 1; i < arr.length; i++)
		{
			arr[i] = a;
			a = a<<1;
		}
		
		
//		for(int i = 0; i < arr.length; i++)
//		{
//			System.out.print(arr[i] + ", ");
//		}
		
		int indexOfm = -2;
		int indexOfn = -2;
		boolean eqM = false;
		boolean eqN = false;
		for(int i = 0; i < arr.length; i++)
		{
			if(m <= arr[i] && indexOfm == -2)
			{
				indexOfm = i-1;
				if(m == arr[i])
				{
					indexOfm ++;
					eqM = true;
				}
			}
			if(n <= arr[i] && indexOfn == -2)
			{
				indexOfn = i-1;
				if(n == arr[i])
				{
					indexOfn ++;
					eqN = true;
				}
			}
		}
		
		System.out.println(indexOfm + ", " + indexOfn + ", " + eqM + ", " + eqN);
		int result = 0;
		if(eqM && eqN)
		{
			return 0;
		}
		
		if(eqM && n<m)
		{
			return 0;
		}
//		if(eqM && n>m && indexOfm==indexOfn-1)
//		{
//			return (int) arr[indexOfm];
//		}
		if(eqM && n==m+1)
		{
			result = (int) arr[indexOfm];
		}
		if(eqN && n>m)
		{
			return 0;
		}
//		if(eqN && n<m && indexOfm==indexOfn+1)
//		{
//			return (int) arr[indexOfn];
//		}
		if(eqN && n==m-1)
		{
			result = (int) arr[indexOfn];
		}
		if(indexOfm != indexOfn)
		{
			return 0;
		}
		result = (int) arr[indexOfn];
		return result + lt201c(m-result, n-result);
	}
	
	public int lt201b(int m, int n)
	{
		if(m == n)			//........
		{
			return m;
		}
		
		int result = 0;
		int i = 0;
		int j = 30;
		int max = -1;
		int min = -1;
		
		if(n > Short.MAX_VALUE)
		{
			max = Integer.MAX_VALUE - (Integer.MAX_VALUE>>1);
		}
		else
		{
			max = Short.MAX_VALUE - (Short.MAX_VALUE>>1);
		}
		
		
		while(max >= n && max != 0)			// >=
		{
			max >>= 1;
		}
		max <<= 1;
		if(max == 0)
			max = 1;
		
		if(m > Short.MAX_VALUE)
		{
			min = Short.MAX_VALUE - (Short.MAX_VALUE>>1);
		}
		else
		{
			if(m == 0)
			{
				min = 0;
			}
			else
			{
				min = 1;
				while(min <= m && min != 0)		// <=
				{
					min <<= 1;
				}
				min >>= 1;
			}
		}
		
		System.out.println("max : " + max + ", min : " + min);
		
		
		if(min<<1 == max)
		{
			if(m == min && n == max)
			{
				result = 0;
			}
			else
			{
				result = min;
			}
		}
		else if(min == 0)
		{
			if(max == 1 && n != 0 && m != 0)
			{
				result = 1;
			}
		}
		else if(m == n)
		{
			result = min;
		}
		
		return result;
	}
	
	
	//error...question is AND of ALL NUMBERS IN [m, n]...not m AND n...
	public int lt201a(int m, int n)
	{
		int result = 0;
		
		int k, j;
		
		for(int i = 0; i < 11; i++)
		{
			k = m%2;
			j = n%2;
			System.out.println(k + ", " + j);
			if(k == 1 && j == 1)
			{
				result += 1<<i;
			}
			m /= 2;
			n /= 2;
		}
		
		return result;
	}
	
	//error
	public int lt201(int m, int n)
	{
		int result = 0;
		
		int big = m > n ? m : n;
		
		if(big == 0)		//...
		{
			return 0;
		}
		
		int i = (int) Math.pow(2, 30);
		for(; i >= big ; i >>= 1)
		{
			;
		}
		i <<= 1;
		
		if(i == 0)		//....
		{
			i = 1;
		}
		
		
		System.out.println(i);
		
		for(; i > 0; i >>= 1)
		{
			if(m >= i && n >= i)
			{
				result += i;
				m -= i;
				n -= i;
			}
		}
		
		return result;
	}
}
