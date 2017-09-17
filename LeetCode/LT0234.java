import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LT0234
{

	public static void main(String[] args)
	{
		int[] a = new int[]{1,2,2,3,4,5,4,3,2,2,1};
		a = new int[]{-129,-129};
//		a = new int[]{1,2};
		ListNode head = array2ListNode(a);
		showListNode(head);
		System.out.println();
		System.out.println(lt0234a(head));
	}

	
//	public
	
	public static boolean lt0234a(ListNode head)
	{
		//beat 5%...
		if(head == null)
			return true;		//
		boolean r = true;
		List<Integer> list = new ArrayList<>(500);
		list.add(head.val);
		while(head.next != null)
		{
			list.add(head.next.val);
			head = head.next;
		}
		System.out.println(list.toString());
		
		int len = list.size();					//slower then below
		for(int i = 0; i < len/2; i++)
		{
			if(!list.get(i).equals(list.get(len-i-1)))
			{
				return false;
			}
		}
		
		/*
		Integer[] a = list.toArray(new Integer[0]);
		int len = a.length;
		for(int i = 0; i < len/2 ; i++)
		{
			if(!a[i].equals(a[len-i-1]))		//!!!Integer not int...
			{
				System.out.println(a[i] + "    " + a[len-i-1]);
				r = false;
				break;
			}
		}
		*/
		return r;
	}
	
	public static boolean lt0234(ListNode head)
	{
		boolean r = false;
		if(head.next == null)
			return true;
		
		ListNode z = head;
//		ListNode z = new ListNode(1);
//		z.next = head;
//		ListNode w = new ListNode(1);
//		w.next = z;
		ListNode n = head.next;
		while(head.next != null)
		{
			if(n.next == null || n == null)
				break;
			if(n.val == n.next.val)
			{
				System.out.print(n.val + ". ");
				n = n.next.next;
				z.next = n;
//				z = z.next;
			}
			if(n.next.next != null && n.val == n.next.next.val)
			{
				System.out.print(n.val + ".. ");
				n = n.next.next.next;
				z.next.next.next = n;
				z.next = z.next.next;
				z = z.next;
			}
			n = n.next;
			z = z.next;
		}
		showListNode(head);
		return r;
	}
	
	public static void showListNode(ListNode n)
	{
		System.out.print(n.val + ", ");
		while(n.next != null)
		{
			n = n.next;
			System.out.print(n.val + ", ");
		}
	}
	
	public static ListNode array2ListNode(int[] a)
	{
		ListNode r = new ListNode(a[0]);
		ListNode n = r;
		ListNode t;
		for(int i = 1; i < a.length; i++)
		{
			t = new ListNode(a[i]);
			n.next = t;
			n = t;
		}
		
		return r;
	}
}

//class ListNode
//{
//	int val;
//	ListNode next;
//	ListNode(int x)
//	{
//		val = x;
//	}
//}