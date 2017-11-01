package june.se.thread;

/**
 */
public class MyThread1 extends Thread {

	private int i = 0;
	
	public void run()
	{
		for(; i < 20; i++)
		{
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}
