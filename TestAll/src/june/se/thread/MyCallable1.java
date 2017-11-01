package june.se.thread;

import java.util.concurrent.Callable;

/**
 */
public class MyCallable1 implements Callable<Integer> {

	private int i = 0;
	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() throws Exception {
		int s = 0;
		for(; i < 15; i++)
		{
			System.out.println(Thread.currentThread().getName() + " " + i);
			s++;
		}
		
		return s;
	}

}
