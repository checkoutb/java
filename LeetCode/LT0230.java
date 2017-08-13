import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.event.ListSelectionEvent;

public class LT0230
{
	

	public static void main(String[] args)
	{
		int[] a = new int[]{3,1,4,Integer.MIN_VALUE,2,7,9};
		int kth = 3;
		a = new int[]{1,Integer.MIN_VALUE,2};
		kth = 2;
		TreeNode tn = array2TreeNode(a);
		showTreeNode(tn, (int) Math.ceil(Math.log10(a.length) / Math.log10(2)));
////		System.out.println(tn.left.left.val);
		System.out.println(tn.val);
//		System.out.print(tn.left.val);
		System.out.println(tn.right.val);
//		
////		System.out.print(tn.left.left.val);
//		System.out.print(tn.left.right.val);
//		System.out.print(tn.right.left.val);
//		System.out.print(tn.right.right.val);
//		lt230(tn, 3);
//		System.out.println(lt230a(tn, 2));
//		System.out.println(lt230a(tn, 2));
		System.out.println(",," + kthSmallest(tn,2));
	}
	
	static int c = 0;		//��̫��⣬����kthSmallest�ǿ��Եģ����Ƿ���ȥ�Ͳ��У�
	static int r = 0;		//��������2����staticɾ������accepted�ˡ�
	//����bst����
	/*
	 * ����ˣ�ֻҪһ������Ϳ����ˣ���������������Ľڵ�����Ȼ��ѡ�����ĸ���������
	 * */
	public static int lt230a(TreeNode tn, int k)
	{
//		int a;
//		k--;
		if(tn.left != null)
			lt230a(tn.left, k);
		c++;
		if(c == k)
		{
			System.out.println(tn.val + " " + c);
			r = tn.val;
		}
		System.out.println(tn.val + " " + c + " " + k);
//		k+=2;
		if(tn.right != null)
			lt230a(tn.right, k);
		return r;
	}
	
    public static int kthSmallest(TreeNode root, int k) {
    	//beat 47
		if(root.left != null)
    		kthSmallest(root.left, k);
		c++;
		if(c == k)
		{
			r = root.val;
		}
        if(root.right != null)
		    kthSmallest(root.right, k);
		return r;
	}
	
	public static int numOfChildAndItself(TreeNode tn)
	{
		int r = 1;
		if(tn.left != null)
		{
			r += numOfChildAndItself(tn.left);
		}
		if(tn.right != null)
		{
			r += numOfChildAndItself(tn.right);
		}
		return r;
	}
	
	
	
	/*
	 * ����ת����С��ô��ֱ�ӱ�����������������С�ѣ�Ȼ��popk����Ȼ����д�������ٶ�Ӧ�ñ������ܶࡣ
	 * Ū���ˣ���������bst�������Ƕ���������
	 * */
	public static int lt230(TreeNode root, int k)
	{
		//beat...beat1%.........
		int r = 0;
		List<Integer> list = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		TreeNode n = null;
		
		
		while(!stack.empty())
		{
			n = stack.pop();
			list.add(n.val);
			if(n.left != null)
			{
				stack.push(n.left);
			}
			if(n.right != null)
			{
				stack.push(n.right);
			}
		}
		System.out.println(list.size());
		Integer[] a = list.toArray(new Integer[0]);
		Arrays.sort(a);
		r = a[k-1];
		System.out.println(r);
		return r;
	}
	
	public static void showTreeNode(TreeNode n, int h)
	{
		//����ת��int[]�Ϳ����ˡ������ö��С�����
		//...���˺þúþã���˳����ˣ���������ʾ�ļ�����������⣬��Ū�ˡ�
		int w = h;
		int j;
		int k;
		int t;
		TreeNode tn;
		int t2;
		t = 1;
		for(int i = 0; i < h; i++)		//����
		{
			for(j = 0; j < w; j++)
			{
				System.out.print("    ");
			}
			w--;
			for(j = 0; j < (int)Math.pow(2, i); j++)		//һ��Ľڵ���
			{
				tn = n;
				t2 = i;
				for(k = i-1; k >= 0; k--)		//�½�
				{
//					System.out.print("/" + t + "/" + k);
//					System.out.print("." + (( t>>(k-1) )%2) + ".");
					if( 0 == (( t>>(k) )%2) )
					{
						tn = tn.left;
					}
					else
					{
						tn = tn.right;
					}
					
					if(null == tn)
					{
//						System.out.print("   ." +k + ", " + i + "." + t);
						if(k == i-2)
						{
							System.out.printf("%8s", "null");
						}
						else
						{
							break;
						}
					}
				}
				t++;
				if(tn == null)
				{
//					System.out.print(" ");
				}
				else
				{
					System.out.printf("%8d", tn.val);
				}
			}
			System.out.println();
		}
	}
	
	public static TreeNode array2TreeNode(int[] a)
	{
		TreeNode root = new TreeNode(a[0]);
		TreeNode n = root;
		int t = 0;
		int h = 0;
		int temp = 0;
		h = (int) Math.ceil(Math.log10(a.length) / Math.log10(2));
//		System.out.println(h);
		int[] path = new int[h+2];
		int l = 0;
		int index = 0;
		for(int i = 1; i < a.length; i++)
		{
			//���ˣ�3456��ƽ���ġ����������Ļ���56��34��
			//Ӧ����+1��Ȼ��ӵ�һ��1���濪ʼ��
			/* 0 0000
			 * 1 0001 0000 0010
			 * 2 0010 0001 0011
			 * 
			 * 3 0011 0010 0100
			 * 4 0100 0011 0101
			 * 5 0101 0100 0110
			 * 6 0110 0101 0111
			 * 
			 * 7 0111 0110 1000
			 * 8 1000 0111 1001
			 * */
			n = root;
			l = -1;
			temp = i + 1;
//			temp = temp<<1;
//			path[0] = 0;
//			while(true)
//			{
				while(temp > 1)	//����������һ��1
				{
					l++;
					path[l] = temp%2;
					temp = temp>>1;
//					l++;
				}
//				else
//				{
//					break;
//				}
//			}
			
//			l--;
			index = l;
//			System.out.println(l);
//			System.out.println(path[0] + " " + path[1] + " " + path[2] + " " + path[3]);
//			while(true)
//			{
				while(index > 0 )
				{
//					System.out.print(".." + index + "  ");
					n = path[index]==1 ? n.right : n.left;
//					System.out.print("``` " + n.val);
//					if(path[index] == 1)
//					{
//						n = n.right;
//					}
//					else
//					{
//						n = n.left;
//					}
					index--;
				}
//				else
//				{
//					break;
//				}
//			}
			
//			(path[index]==1) ? (n.right=new TreeNode(a[i])) : (n.left=new TreeNode(a[i]));
			if(path[index] == 1)
			{
				if(a[i] == Integer.MIN_VALUE)
				{
					n.right = null;
//					System.out.println("   r null");
				}
				else
				{
					n.right = new TreeNode(a[i]);
//					System.out.println("   r " + a[i]);
				}
			}
			else
			{
				if(a[i] == Integer.MIN_VALUE)
				{
					n.left = null;
//					System.out.println("l   null");
				}
				else
				{
					n.left = new TreeNode(a[i]);
//					System.out.println("l   " + a[i]);
				}
			}
			
//			t++;
		}
		
		return root;
	}
}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val)
	{
		this.val = val;
	}
}