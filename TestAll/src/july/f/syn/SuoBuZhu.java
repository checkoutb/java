package july.f.syn;

/**
 */
public class SuoBuZhu extends Thread{

	/**
	 * ����������run���½��˶��󣬵���Ĭ�ϵ�����������ס��
	 * .CaoZuo2�� ֱ�����࣬�Ϳ����ˡ���thisҲ�ǲ��еģ�this==����
	 * SuoZhuҲ����  ��Ϊ�� static����̬�ķ����в�����this�����Ի��class��ס��
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
		sbz.SuoZhu();			//y��Ϊstatic��������this��ֻ����class�����Կ�����ס
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
