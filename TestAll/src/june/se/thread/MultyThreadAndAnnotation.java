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
				//������i 
				MyThread1 t1 = new MyThread1();
				MyThread1 t2 = new MyThread1();
				Thread t3 = new Thread(t1);		//��һ���̰߳�װ��2�������ܹ����ˡ��������������������βλ���ͬһ����ok��,�������Ժ�һ��ʼ���2��0
				Thread t4 = new Thread(t2);
				t3.start();		//run�ᱻstart���õĸо���
				t4.start();*/
				
				/*
				//����i���������ҿ�ʼ�����2��0��������Ϊֻ��һ��MyRunnable1.�Ӹ�r2���ܲ������ˡ�����������һ����������һ���̰߳�װ��2�����ܹ��������ˡ�
				Runnable run = new MyRunnable1();
				Runnable r2 = new MyRunnable1();
				Thread t1 = new Thread(run);
				Thread t2 = new Thread(run);
				t1.start();
				t2.start();*/
				
				/*
				MyThread1 t = new MyThread1();
				Thread t1 = new Thread(t, "����");		//�ڶ����βξ��� �̵߳����֡�
				Thread t2 = new Thread(t, "����");
				t1.start();
				t2.start();
				*/
				
				
			}
		}
		
/*
		//��Ҫ��futuretask��get������get��������߳�ִ�����Ż�ִ�С�������ȷ�е�֪����ʱ�����ˡ�
		//ûʲô���á� thread��isaLive���ж��ǲ�����������getstatus�ܻ��״̬��ִ�У�����������������get����Ҫwhileѭ�����ή��ϵͳ���İɣ���Ȼfuturetask����Դ�൱��n��thread����Դ�˰ɣ�
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
