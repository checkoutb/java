package june.ts;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

/**
 */
public class ForThePersonSayDonotKickIt {

	/**
	 */
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++)
		{
			l.add(i);
		}
		int size = l.size();
		for(int i = 0; i < size; i++)
		{
			out.println(l.get(i));
		}
	}
}
