package july.f.syn;

public class SynchronizedTest implements Runnable{

	public static void main(String[] args) {
		
		/*SynchronizedTest st1 = new SynchronizedTest();
		Thread t1 = new Thread(st1, "A");
		Thread t2 = new Thread(st1, "b");
		t1.start();
		t2.start();*/
//		SynchronizedTest st2 = new SynchronizedTest();
//		st1.run();
//		st2.run();			//...�������û���á�Ҫstart�Ĳ����̣߳������ֻ�Ǽ򵥵ĵ���run��������
		
		/*SynchronizedTest st2 = new SynchronizedTest();
		for(int i = 1; i < 5; i++)				//�޷����why���϶�˵������ ����ס�ġ�����run����Ĳ�һ��..�������Դֻ��st2һ��������Ĭ�ϵ������������ס��
		{
			Thread t = new Thread(st2);
			t.start();
		}*/
		
		SynchronizedTest st11 = new SynchronizedTest();
		SynchronizedTest st12 = new SynchronizedTest();
		SynchronizedTest st13 = new SynchronizedTest();
		SynchronizedTest st14 = new SynchronizedTest();
		
		Thread t11 = new Thread(st11);
		Thread t12 = new Thread(st12);
		Thread t13 = new Thread(st13);
		Thread t14 = new Thread(st14);
		
		t11.start();
		t12.start();
		t13.start();
		t14.start();				//en ,cannot lock ...
	}

	private int a;

	
	synchronized public void waitTest()
	{
		for(int i = 1; i < 11; i++)
		{
			int a = (int) (Math.random() * 100 + 40);
			try {
				Thread.sleep(a);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(Thread.currentThread().getName() + " " + i + " " + a);
			System.out.printf("%s %4d %4d\n", Thread.currentThread().getName(), i, a);		//...almost forget
		}
	}
	
	public synchronized void haiyouzhezhongcaozuo()
	{
		System.out.println(Thread.currentThread().getName() + "kaishi");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "jieshu");
	}
	
	/**
	 * @return the a
	 */
	public int getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(int a) {
		this.a = a;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		waitTest();
		haiyouzhezhongcaozuo();
	}
}
