package july.t.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ..Clone2 also can
 * ..这里的深拷贝要用到Serializable接口
 * 有没有不需要串行化就能深拷贝的？
 */
public class CloneTest implements Cloneable,Serializable{

	private static final long serializable = -59106830L;
	private int id;
	private Clone2 c2;
	
	/**
	 */
	public static void main(String[] args) {
		CloneTest ct = new CloneTest();
		Clone1 c1 = new Clone1();
		Clone2 c2 = new Clone2();
		c1.setId(1);
		c2.setC1(c1);
		c2.setId(2);
		ct.setC2(c2);
		ct.setId(3);
		
		CloneTest ct2 = (CloneTest) ct.clone();
		CloneTest ct3 = (CloneTest) ct.deepClone();
		
		System.out.println(ct.toString());
		System.out.println(ct2.toString());
		System.out.println(ct3.toString());
		
		System.out.println(ct.getC2());
		System.out.println(ct2.getC2());
		System.out.println(ct3.getC2());
		
		System.out.println(ct.getC2().getC1());
		System.out.println(ct2.getC2().getC1());
		System.out.println(ct3.getC2().getC1());
		
	}

	public Object clone()
	{
		CloneTest ct = null;
		try {
			ct = (CloneTest) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ct;
	}

	public Object deepClone() {
		try
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this);

			/* 读出二进制流产生的新对象 */
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			return ois.readObject();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the c2
	 */
	public Clone2 getC2() {
		return c2;
	}

	/**
	 * @param c2 the c2 to set
	 */
	public void setC2(Clone2 c2) {
		this.c2 = c2;
	}
}
