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
		ExecutorService exe = Executors.newFixedThreadPool(5);			//线程池的大小	。。一次只能运行那么几个。
		
		for(int i = 0; i < 50; i++)
		{
			exe.execute(new MyThread1(i));
			System.out.println(".......");				//前n(线程池大小)个是跟着....输出的，然后输出所有的....然后是剩下线程的输出
		}
		exe.shutdown();						//不等线程执行完的，50个....输出完就是这个shutdow。然后是剩下的线程
/*		List<Runnable> lt = exe.shutdownNow();		//直接停止所有线程，未执行的不再执行。返回未执行的线程的list，
		for(Runnable r : lt)							//而且正在执行的也会尝试停止。所以会导致线程的sleep报错，可能是醒了以后找不到自己(猜的。)
		{
			System.out.println(r.toString());
		}*/
		
		System.out.println("````````");
		while(true)
		{
			if(exe.isTerminated())				//如果不用shutdown，这里是永远false的。无法结束程序
			{
				System.out.println("done...");
				break;
			}
			Thread.sleep(1000);
		}
	}

}
