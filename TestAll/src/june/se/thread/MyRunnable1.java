package june.se.thread;

/**
 */
public class MyRunnable1 implements Runnable {

	private int i = 0;
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for(; i < 20; i++)
		{
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
