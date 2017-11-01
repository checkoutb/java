package july.e.enumm;

import java.util.LinkedList;
import java.util.List;

public class EffectiveTest {

    boolean ture;
	
	/**
     * @return the ture
     */
    public boolean isTure() {
        return ture;
    }

    /**
     * @param ture the ture to set
     */
    public void setTure(boolean ture) {
        this.ture = ture;
    }

    public static void main(String[] args) {
		
		String s = "111";
		String s2 = null;
		int a = 3;
		List<?> l = new LinkedList();
		l.add(null);
		float f = 2.3f;
		int i = 3;
		Integer aa = new Integer(i);
		
		System.out.println(Object.class.cast(a));
		System.out.println(Object.class.cast(s));
		System.out.println(Object.class.cast(s2));
		System.out.println(Integer.class.cast(a));
		System.err.println(Number.class.cast(f));
		System.err.println(Number.class.cast(i));
		if(aa instanceof Object)
		{
			System.err.printf("koleiwa %d\n%d%n%f", i,a,f);
		}
//		System.err.println(Float.class.cast(aa));
//		System.err.println(Integer.class.cast(f));
//		System.out.println(String.class.cast(a));	//exception,classcastexception
	}
	
	public  static <E> E swap(List<E> list, int i, int j)
	{
		return list.set(i, list.set(j, list.get(i)));
	}

/*	public static void swap2(List<?> list, int i, int j)
	{
		list.set(i, list.set(j, list.get(i)));
	}*/
}
