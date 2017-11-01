package june.n.threadpool;

/**
 */
public class SelfInstanceOfSelf {

	/**
	 */
	public static void main(String[] args) {
		
		MyThread1 mt1 = new MyThread1(3);
		MyThread1 mt2 = new MyThread1(2);
		
		if(mt1 instanceof MyThread1)
		{
			System.out.println("11111");
		}
		else
		{
			System.out.println("22");
		}
		
	}

}
