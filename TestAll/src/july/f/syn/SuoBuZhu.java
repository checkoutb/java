package july.f.syn;

/**
 */
public class SuoBuZhu extends Thread{

	/**
	 * 。。这里在run里新建了对象，导致默认的锁对象锁不住。
	 * .CaoZuo2里 直接锁类，就可以了。锁this也是不行的，this==对象。
	 * SuoZhu也可以  因为是 static，静态的方法中不能用this，所以会把class锁住。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 0; i < 5; i++)
		{
			Thread t = new SuoBuZhu();
			t.start();
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		SuoBuZhu sbz = new SuoBuZhu();
//		sbz.CaoZuo();
//		System.out.println("\n\n");
//		sbz.CaoZuo2();
//		System.out.println("\n\n");
		sbz.SuoZhu();			//y因为static，不能锁this，只会锁class，所以可以锁住
	}

	private synchronized void CaoZuo()
	{
		System.out.println(Thread.currentThread().getName() + "kaishi11");
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "jieshu11");
	}
	
	private void CaoZuo2()
	{
		synchronized(SuoBuZhu.class)
		{
			System.out.println(Thread.currentThread().getName() + "kaishi22");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "jieshu22");
		}
	}
	
	private static synchronized void SuoZhu()
	{
		System.out.println(Thread.currentThread().getName() + "kaishi33");
		try
		{
			Thread.sleep(300);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "jieshu33");
	}
}
