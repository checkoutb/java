package junt.twth.test;

/**
 */
public class BeTest {

	private static int result;
	
	public void add(int n)
	{
		result += n;
	}
	
	public void substract(int n)
	{
		result -= n;
	}
	
	public void square(int n)
	{
		result = n * n;
	}
	
	public void forever()
	{
		while(true);
	}
	
	public void clear()
	{
		result = 0;
	}
	
	public int getReault()
	{
		return result;
	}
}
