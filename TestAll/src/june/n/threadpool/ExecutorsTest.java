package june.n.threadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 */
public class ExecutorsTest {

	/**
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exe = Executors.newFixedThreadPool(5);			//�̳߳صĴ�С	����һ��ֻ��������ô������
		
		for(int i = 0; i < 50; i++)
		{
			exe.execute(new MyThread1(i));
			System.out.println(".......");				//ǰn(�̳߳ش�С)���Ǹ���....����ģ�Ȼ��������е�....Ȼ����ʣ���̵߳����
		}
		exe.shutdown();						//�����߳�ִ����ģ�50��....�����������shutdow��Ȼ����ʣ�µ��߳�
/*		List<Runnable> lt = exe.shutdownNow();		//ֱ��ֹͣ�����̣߳�δִ�еĲ���ִ�С�����δִ�е��̵߳�list��
		for(Runnable r : lt)							//��������ִ�е�Ҳ�᳢��ֹͣ�����Իᵼ���̵߳�sleep���������������Ժ��Ҳ����Լ�(�µġ�)
		{
			System.out.println(r.toString());
		}*/
		
		System.out.println("````````");
		while(true)
		{
			if(exe.isTerminated())				//�������shutdown����������Զfalse�ġ��޷���������
			{
				System.out.println("done...");
				break;
			}
			Thread.sleep(1000);
		}
	}

}
