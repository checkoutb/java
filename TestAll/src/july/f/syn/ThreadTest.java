package july.f.syn;

/**
 */
public class ThreadTest extends Thread {

	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadTest tt1 = new ThreadTest();
		ThreadTest tt2 = new ThreadTest();
		tt1.start();
		tt2.start();
//		tt1.run();
	}

	
	public void run()
	{
		for(int i = 0; i < 10 ; i++)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("%s %4d\n", Thread.currentThread().getName(), i);
		}
	}
}
