
public class LTUtil
{
	
	/**
	 * may be return null
	 * */
	public static ListNode array2ListNode(int[] array)
	{
		ListNode head = null;
		ListNode tail = null;
		
		if(array.length > 0)
		{
			head = new ListNode(array[0]);
			tail = head;
		}
		
		for(int i = 1; i < array.length; i++)
		{
			tail.next = new ListNode(array[i]);
			tail = tail.next;
		}
		
		
		return head;
	}
	
	public static void printListNode(ListNode node)
	{
		StringBuilder sb = new StringBuilder();
		int i = 0;
		if(node == null)
		{
			System.out.println("null");
			return ;
		}
		do
		{
			sb.append(node.val);
			sb.append(", ");
			i++;
			if(i == 9)
			{
				sb.append("\n");
				i = 0;
			}
			node = node.next;
		} while(node != null);
		sb.delete(sb.length()-2, sb.length());
		System.out.println(sb.toString());
	}
}
