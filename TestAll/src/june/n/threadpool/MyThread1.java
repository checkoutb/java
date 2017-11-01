package june.n.threadpool;

/**
 */
public class MyThread1 extends Thread{

	/**
	 */
	public static void main(String[] args) {
		
	}

	private int i;
	
	public MyThread1(int i)
	{
		this.i = i;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		System.out.println(this.getI());
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getI()
	{
		return this.i;
	}

}
