package june.se.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 */
public class MultyThreadAndAnnotation {

	/**
	 * interrupt  yield sleep
	 */
	public static void main(String[] args) {

		for(int i = 0; i < 10; i++)
		{
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i == 5)
			{
				
				/*
				//不共享i 
				MyThread1 t1 = new MyThread1();
				MyThread1 t2 = new MyThread1();
				Thread t3 = new Thread(t1);		//把一个线程包装成2个，就能共享了。。。就是这里和下面的形参换成同一个就ok了,，共享以后，一开始输出2个0
				Thread t4 = new Thread(t2);
				t3.start();		//run会被start调用的感觉。
				t4.start();*/
				
				/*
				//共享i。。。而且开始会输出2个0，。是因为只有一个MyRunnable1.加个r2就能不共享了。。。和上面一样啊，就是一个线程包装成2个就能共享数据了。
				Runnable run = new MyRunnable1();
				Runnable r2 = new MyRunnable1();
				Thread t1 = new Thread(run);
				Thread t2 = new Thread(run);
				t1.start();
				t2.start();*/
				
				/*
				MyThread1 t = new MyThread1();
				Thread t1 = new Thread(t, "调动");		//第二个形参就是 线程的名字。
				Thread t2 = new Thread(t, "各个");
				t1.start();
				t2.start();
				*/
				
				
			}
		}
		
/*
		//主要是futuretask有get方法，get方法会等线程执行完后才会执行。所以能确切的知道几时结束了。
		//没什么卵用。 thread的isaLive能判断是不是死亡。。getstatus能获得状态，执行，挂起，死亡。。不过get不需要while循环。会降低系统消耗吧？虽然futuretask的资源相当于n个thread的资源了吧？
		Callable<Integer> c1 = new MyCallable1();
		FutureTask<Integer> ft = new FutureTask<Integer>(c1);
		for(int i = 0; i < 10; i++)
		{
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i == 1)
			{
				Thread t1 = new Thread(ft);
				t1.start();
			}
		}
		int sum;
		try {
			sum = ft.get();
			System.out.println("sum " + sum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}*/
		
		
	}

}
