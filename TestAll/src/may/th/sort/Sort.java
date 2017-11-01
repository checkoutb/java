package may.th.sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 */
public class Sort {

	private static int[] array;
	
	private static int[] array2;
	
	private static int[] t;
	
	private static int time = 0;
	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a z");
		System.out.println(sdf.format(d));
//		createData(200);
		
//		for(int i : array)
//		{
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
//		array2 = new int[20];
//		System.out.println(array2.length);
		
		array2 = new int[2000];
		for(int i = 0; i < 10; i++)
		{
			createData(2000);
			for(int j = 0; j < array.length; j++)
			{
				array2[j] = array[j];
			}
			Long t = System.currentTimeMillis();
			bubbleSort();
			System.out.println(System.currentTimeMillis() - t);
			
			for(int j = 0; j < array.length; j++)
			{
				array[j] = array2[j];
			}
			t = System.currentTimeMillis();
			searchSort();
			System.out.println(System.currentTimeMillis() - t);
			
			for(int j = 0; j < array.length; j++)
			{
				array[j] = array2[j];
			}
			t = System.currentTimeMillis();
			insertSort();
			System.out.println(System.currentTimeMillis() - t);
			
			for(int j = 0; j < array.length; j++)
			{
				array[j] = array2[j];
			}
			t = System.currentTimeMillis();
			insertSort2();
			System.out.println(System.currentTimeMillis() - t);
			
			for(int j = 0; j < array.length; j++)
			{
				array[j] = array2[j];
			}
			t = System.currentTimeMillis();
			mergeSort(0, array.length-1);
			System.out.println(System.currentTimeMillis() - t);
			
			for(int j = 0; j < array.length; j++)
			{
				array[j] = array2[j];
			}
			t = System.currentTimeMillis();
			shellSort();
			System.out.println(System.currentTimeMillis() - t);
			
			for(int j = 0; j < array.length; j++)
			{
				array[j] = array2[j];
			}
			t = System.currentTimeMillis();
//			quickSort(0, array.length-1);
			System.out.println(System.currentTimeMillis() - t);
			
			
		}
//		for(int i : array)
//		{
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		for(int i : array2)
//		{
//			System.out.print(i + " ");
//		}
//		System.out.println("\n" + time);
	}

	
	public static void quickSort(int left, int right)
	{
		if(right-left <= 0)
			return;
		else
		{
			int i = left;
			int j = right;
			int k = array[left];
			while(i < j)
			{
				while(i<j && k <= array[j])
				{
					j--;
				}
				array[i] = array[j];
				while(i<j && k >= array[i])
				{
					i++;
				}
				array[j] = array[i];
			}
			array[i] = k;
			quickSort(left, i-1);
			quickSort(i+1, right);
		}
	}
	
	public static void shellSort()
	{
		int i;
		int j=0;
		int temp;
		int step = 1;
		while(step <= array.length/3)
		{
			step = step*3 + 1;
		}
		while(step > 0)
		{
			for(i = step; i < array.length; i++)
			{
				temp = array[i];
				j = i;
				//不能一遍step到底，一遍的话还是无序的，这里是先选2个作比较，然后选3个作比较...做完。。也不对。。。
				//j是以step往后缩小。i是递增。如果i和j都是增加，是不对的。
				while(j > step-1 && array[j-step] >= temp)
				{
//					System.out.print("w ");
					array[j] = array[j-step];
					j -= step;
				}
//				System.out.print("f ");
				array[j] = temp;
			}
//			System.out.println(j);
			step = (step-1)/3;
		}
	}
	
	public static void mergeSort(int s, int e)
	{
		if(s == e && s >= e)
		{
			return;
		}
		else
		{
			int m = (s+e)/2;
//			System.out.println(s + " : " + (m-1) + " " + e);
			mergeSort(s, m);
			mergeSort(m+1, e);
			merge(s, m+1, e);
		}
	}
	public static void merge(int a, int m, int e)
	{
		time++;
//		System.out.print(a + " " + m + " " + e + ":");
		int i=a, j=m, k=a;
		while(i<m && j<=e)
		{
			if(array[i] < array[j])
			{
//				System.out.print("a");
				array2[k++] = array[i++];
			}
			else
			{
//				System.out.print("b");
				array2[k++] = array[j++];
			}
		}
		while(i<m)
		{
//			System.out.print("c");
			array2[k++] = array[i++];
		}
		while(j<=e)
		{
//			System.out.print("d");
			array2[k++] = array[j++];
		}
		for(int q = a; q<=e; q++)
		{
//			System.out.print(" " + array2[q]);
			array[q] = array2[q];
		}
//		System.out.println();
	}
	
	public static void insertSort()
	{
		int k = 0;
		int length = array.length;
		int temp = 0;
		
		int in, out;
		
		for(out = 1; out < length; out++)
		{
			temp = array[out];
			in = out;
			while(in > 0 && array[in-1] >= temp)
			{
				array[in] = array[in-1];
				in--;
			}
			array[in] = temp;
		}
		
//		System.out.println(k);
	}
	
	
	public static void insertSort2()
	{
		int length = array.length;
		int temp;
		int j;
		int k;
		for(int i = 1; i < length; i++)
		{
			temp = array[i];
			/*//先判断下标月结，再取值。
			for(j = i-1; j>=0 && array[j]>=temp ; j--)
			{
				array[j+1] = array[j];
			}
			array[j+1] = temp;*/
			
			/*for(j = i; j>0 && array[j-1]>temp; j--)
			{
				array[j] = array[j-1];
			}
			array[j] = temp;*/
			
			for(j=0; j<i && array[j]<temp; j++)
			{
				
			}
			k = j;
			for(; j<i; j++)
			{
				array[i+k-j] = array[i+k-j-1];
			}
			array[k] = temp;
		}
	}
	
	public static void searchSort()
	{
		int k = 0;
		int length = array.length;
		int temp = 0;
		
		for(int i = 0; i < length-1; i++)
		{
			temp = i;
			for(int j = i; j < length; j++)
			{
				if(array[temp] > array[j])
				{
//					k = k + 1;
					temp = j;
				}
			}
			if(temp != i)
			{
				k += 1;
				array[i] = array[i] + array[temp];
				array[temp] = array[i] - array[temp];
				array[i] = array[i] - array[temp];
			}
		}
//		System.out.println(k);
	}
	
	public static void bubbleSort()
	{
		int k = 0;
		int length = array.length;
		for(int i = 0; i < length-1; i++)
		{
			for(int j = 0; j < length-1-i; j++)
			{
				if(array[j] > array[j+1])
				{
					k += 1;
					array[j+1] = array[j+1] + array[j];
					array[j] = array[j+1] - array[j];
					array[j+1] = array[j+1] - array[j];
				}
			}
		}
//		System.out.println(k);
	}
	
	
	
	public static void createData(int n)
	{
		if(n<1)
			return;
		array = new int[n];
		
		Random r = new Random();
		int j = 0;
		for(int i : array)
		{
			array[j] = r.nextInt(n*10);
//			i = r.nextInt(n*10);
//			System.out.print(i + " ");
			j++;
		}
//		System.out.println();
	}
}
