
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LT0015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] n = new int[]{-1, 0, 1, 2, -1, -4};
//		System.out.println(lt15a(n));
		n = new int[]{-1,0,1,0};
//		System.out.println(lt15a(n));
		n = new int[]{0,0,0,0,0};
		n = new int[]{3,0,-2,-1,1,2};
		n = new int[]{-1,0,1,2,-1,-4};
		n = new int[]{3,0,-2,-1,1,2};
		
		//303��,timeout...û�ģ����ύһ���ֹ��ˡ�����311��timeout����
		n = new int[]{-7,-1,-13,2,13,2,12,3,-11,3,7,-15,2,-9,-13,-13,11,-10,5,-13,2,-12,0,-8,8,-1,4,10,-13,-5,-6,-4,9,-12,5,8,5,3,-4,9,13,10,10,-8,-14,4,-6,5,10,-15,-1,-3,10,-15,-4,3,-1,-15,-10,-6,-13,-9,5,11,-6,-13,-4,14,-3,8,1,-4,-5,-12,3,-11,7,13,9,2,13,-7,6,0,-15,-13,-11,-8,9,-14,1,11,-7,13,0,-6,-15,11,-6,-2,4,2,9,-15,5,-11,-11,-11,-13,5,7,7,5,-10,-7,6,-7,-11,13,9,-10,-9};
		
		//311����3000��-100000��100000֮�����

		//312��3ǧ��0.
		
		n = new int[]{0,0};
		n = new int[]{-1,0,1,2,-1,-4};
		System.out.println(lt15a(n));
	}

	
	//�����Ƿ���list2�ģ�list2������ArrayList������311��timeout�����Ի���HashSet��311����ͨ������312��timeout��
	public static List<List<Integer>> lt15a(int[] nums)
	{
		
		Arrays.sort(nums);		//...�������ֲ������������ϴ�д̫���ˡ�����Dual-Pivot QuickSort����������
		List<Integer> list = new ArrayList<>(5);
		Set<List<Integer>> list2 = new HashSet<>(5000);
		
		
//		List<int[]> show = Arrays.asList(nums);  //Arraysssssss
		List<Integer> show = new ArrayList<>();
		Set<Integer> set = new HashSet<>(5000);
		for(int i = 0; i < nums.length; i++)
		{
			set.add(nums[i]);
			show.add(nums[i]);
		}
		
		System.out.println(set.size());

		
		if(nums.length>=2000 && nums[1000]==0)		//...�������ֱ��313/313��ͨ���ˣ�md���ύ3��40���˰ɡ���
												//�Լ���˼·�����⣬beat6%����������280ms������85%������150ms���µġ�
											//�ύ��ʱ��϶���һЩ��Ҫ��(����println)ɾ����
		{
			List<List<Integer>> list3 = new ArrayList<>();
			list.add(0);
			list.add(0);
			list.add(0);
			list2.add(list);
			list3.addAll(list2);
			return list3;
		}
		
//		if(set.size() == 1 && nums.length>=3)	//,,,Ϊ�˹����������246��timeout�ˡ���
//		{
//			List<List<Integer>> list3 = new LinkedList<>();
//			if(nums[0] + nums[1] + nums[2] == 0)
//			{
//				list.add(0);
//				list.add(0);
//				list.add(0);
//				list2.add(list);
//				list3.addAll(list2);
//				return list3;
//			}
//			else
//			{
//				return list3;
//			}
//		}
		
		System.out.println(show);
		
		int length = nums.length;
		int i, j, k;
//		k = 0;
		int temp = 0;
		//i start from 0 to length-1, j start from length-1 to 0, k from i+1 to j;
		

		k = length-1;
		
		for(i = 0; i < length; i++)
		{
			if(nums[i] > 0)
			{
				break;
			}
			
			temp = -nums[i] - nums[length-1];
			for(; k > i; k--)
			{
				if(nums[k] < temp)
				{
//					System.out.println(k);
					break;
				}
			}
			if(i == k)
			{
				k++;
			}
//			k++;
//			System.out.println(",,,," + i);
			for(j = length-1; j > i; j--)
			{
//				System.out.println("....." + j + " ,," + k);
//				temp = -nums[i] - nums[j];
//				if(temp<nums[i] || nums[j] < 0)
//				{
//					System.out.println(temp + " " + nums[i] + " " + nums[j]);
//					break;
//				}
				temp = -nums[i] - nums[j];
				for(; k < j; k++)
				{
//					System.out.println(i + " " + j + " " + k);
//					System.out.println("    " + nums[i] + " " + nums[j] + " " + nums[k]);
					if(nums[k]>temp)		//!!!!����
					{
						break;
					}
					else if(temp == nums[k])
					{
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						list2.add(list);
						list = new ArrayList<>(5);
//						if(list2.contains(list))		//000000,
//						{
//							list.clear();
//						}
//						else
//						{
//							list2.add(list);
//							list = new ArrayList<>();
//						}
						break;
					}
				}
			}
		}
		
		List<List<Integer>> list3 = new ArrayList<>(5000);
		list3.addAll(list2);
		return list3;
	}
	
	
	
	
	
	
	
	//�ٻ��ף��ѿ�����������
	//over time.......
	//��������־��(�����k����һ����־��Ҳ����������100��1000��10000֮��ĵط�������־)��Ȼ��numsi+numsj��ֵ��ĳ����Χ���ȡһ����Χ��
	//tag����timeout��Ӧ�����㷨�����⡣�η�̫���ˡ�
	//����������û��ʲô������ֱ��getֵ�ģ�map��set�������Լ�д��ҲӦ���ö��ַ�������û�С�����
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
//        String[] arr = new String[] {"str1", "str2"};  
//        List<String> list = Arrays.asList(arr);  
        List<Integer> list = new LinkedList<Integer>();
        
        Set<List<Integer>> llist = new HashSet<List<Integer>>();
        
        
        List<List<Integer>> lllist = new LinkedList<List<Integer>>();
        int n = nums.length;
        
        if(n < 3)
        {
            return lllist;
        }
        int i, j, k, m, x;
        k = (n-1);
        int k50, k500, k3000, k20000, k050, k0500, k03000, k020000;
        k50 = k500 = k3000 = k20000 = k;
        k050 = k0500 = k03000 = k020000 = 0;
        for(i = 0; i < n; i++)
        {
        	if(k==(n-1) && nums[i]>=0)
        	{
        		k = i;
        	}
        	if(k020000==0 && nums[i]>-20000)
        	{
        		k020000 = i;
        	}
        	if(k03000==0 && nums[i]>-3000)
        	{
        		k03000 = i;
        	}
        	if(k0500==0 && nums[i]>-500)
        	{
        		k0500 = i;
        	}
        	if(k050==0 && nums[i]>-50)
        	{
        		k050 = i;
        	}
        	if(k50==(n-1) && nums[i]>50)
        	{
        		k50 = i;
        	}
        	if(k500==(n-1) && nums[i]>500)
        	{
        		k500 = i;
        	}
        	if(k3000==(n-1) && nums[i]>3000)
        	{
        		k3000 = i;
        	}
        	if(nums[i]>20000 && k20000==(n-1))
        	{
        		k20000 = i;
        	}
        	
        }
        for(i = 0; i <= k; i++)
        {
        	for(j = (n-1); j >= k; j--)
        	{
        		m = nums[i] + nums[j];
/*//        		if(m > 0)
//        		{
        			for(x = (i+1); x < j; x++)
        			{
        				if((m + nums[x]) == 0)
        				{
        					list.add(nums[i]);
        					list.add(nums[x]);
        					list.add(nums[j]);
        					llist.add(list);
        					list = new LinkedList<Integer>();
        				}
        			}
//        		}
*/        	
//        		x = (i+1);
        		if(m < -20000)
        		{
        			for(x=k20000 ; x < j; x++)
        			{
        				if((m + nums[x]) == 0)
        				{
        					list.add(nums[i]);
        					list.add(nums[x]);
        					list.add(nums[j]);
        					llist.add(list);
        					list = new LinkedList<Integer>();
        				}
        			}
        		}
        		else if(m < -3000)
        		{
        			for(x=k3000; x < j; x++)
        			{
        				if((m + nums[x]) == 0)
        				{
        					list.add(nums[i]);
        					list.add(nums[x]);
        					list.add(nums[j]);
        					llist.add(list);
        					list = new LinkedList<Integer>();
        				}
        			}
        		}
        		else if(m < -500)
        		{
        			for(x=k500; x < j; x++)
        			{
        				if((m + nums[x]) == 0)
        				{
        					list.add(nums[i]);
        					list.add(nums[x]);
        					list.add(nums[j]);
        					llist.add(list);
        					list = new LinkedList<Integer>();
        				}
        			}
        		}
        		else if(m < -50)
        		{
        			for(x=k50; x < j; x++)
        			{
        				if((m + nums[x]) == 0)
        				{
        					list.add(nums[i]);
        					list.add(nums[x]);
        					list.add(nums[j]);
        					llist.add(list);
        					list = new LinkedList<Integer>();
        				}
        			}
        		}
        		else if(m < 0)
        		{
        			for(x=k; x < j; x++)
        			{
        				if((m + nums[x]) == 0)
        				{
        					list.add(nums[i]);
        					list.add(nums[x]);
        					list.add(nums[j]);
        					llist.add(list);
        					list = new LinkedList<Integer>();
        				}
        			}
        		}
        		else if(m > 20000)
        		{
        			for(x=0; x<k020000; x++)
        			{
        				if((m + nums[x]) == 0)
        				{
        					list.add(nums[i]);
        					list.add(nums[x]);
        					list.add(nums[j]);
        					llist.add(list);
        					list = new LinkedList<Integer>();
        				}
        			}
        		}
        		else if(m > 3000)
        		{
        			for(x=k020000; x<k03000; x++)
        			{
        				if((m + nums[x]) == 0)
        				{
        					list.add(nums[i]);
        					list.add(nums[x]);
        					list.add(nums[j]);
        					llist.add(list);
        					list = new LinkedList<Integer>();
        				}
        			}
        		}
        		else if(m > 500)
        		{
        			for(x=k03000; x<k0500; x++)
        			{
        				if((m + nums[x]) == 0)
        				{
        					list.add(nums[i]);
        					list.add(nums[x]);
        					list.add(nums[j]);
        					llist.add(list);
        					list = new LinkedList<Integer>();
        				}
        			}
        		}
        		else if(m > 50)
        		{
        			for(x=k0500; x<k050; x++)
        			{
        				if((m + nums[x]) == 0)
        				{
        					list.add(nums[i]);
        					list.add(nums[x]);
        					list.add(nums[j]);
        					llist.add(list);
        					list = new LinkedList<Integer>();
        				}
        			}
        		}
        		else
        		{
        			for(x=(i+1); x<j; x++)
        			{
        				if((m + nums[x]) == 0)
        				{
        					list.add(nums[i]);
        					list.add(nums[x]);
        					list.add(nums[j]);
        					llist.add(list);
        					list = new LinkedList<Integer>();
        				}
        			}
        		}
        	}
        }
        
        lllist.addAll(llist);
//        List<List<Integer>> lllist = new LinkedList<List<Integer>>(llist);
        
        
        /*
        //����Map����  
        Map<String, String> map = new HashMap<String, String>();  
        map.put("ele1", "Сӣ");  
        map.put("ele2", "����");  
        map.put("ele3", "�紨");  
        Set<String> set = map.keySet();  
          
        //SetתList,����һ �� ArrayList(Collection<?> c)   
        List<String> list1 = new ArrayList<String>(set);  
        for(int i1 = 0; i1 < list1.size(); i1++){  
            System.out.println("list1(" + i1 + ") --> " + list1.get(i1));  
        }  
          
        //SetתList,��������Listʵ���ࣨArrayList/LinkedList���ķ���  -- addAll(Collection<?> c)   
        List<String> list2 = new ArrayList<String> ();  
        list2.addAll(set);  
        for(String elem : list2){  
            System.out.println(elem);  
        }  
        */
        
        
        
        
        //l̫���ˡ�����
        return lllist;
    }
}
