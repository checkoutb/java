
public class LT0086
{
	public static void main(String[] args)
	{
		int[] array = { 1, 4, 3, 2, 5, 2 };
		int x = 3;

		array = new int[] { 1 };
		x = 0;
		
		
		ListNode head = LTUtil.array2ListNode(array);
		LTUtil.printListNode(head);
		
		
		
		ListNode result = lt86(head, x);
		
		LTUtil.printListNode(result);
		
	}
	
	//1ms, and 95% is 1ms...
	public static ListNode lt86(ListNode head, int x)
	{
		ListNode result = null;
		ListNode last = new ListNode(0);
		last.next = head;
		ListNode tail = head;
		ListNode temp = new ListNode(-1);
		ListNode big = temp;
		while(tail != null)
		{
			if(tail.val >= x)
			{
				temp.next = tail;
				temp = temp.next;
				
				last.next = tail.next;
				tail = last.next;
				
				temp.next = null;
			}
			else
			{
				if(result == null)
				{
					result = tail;
				}
				last = tail;
				tail = tail.next;
			}
		}
		
		last.next = big.next;
		
		if(result == null)		//...{1} 0..
		{
			result = head;
		}
		
		return result;
	}
	
}
