package june.se.thread;

/**
 */
@wb(name="class")
public class MyAnnotation {

	
	@wb(age="111")
	private int a;
	
	@wb(name="aa")
	public int aa;
	
	@wb(name="bbv", age="999")
	private String s;

	/**
	 * @return the a
	 */
	public int getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	@wb(name="method")
	public void setA(int a) {
		this.a = a;
	}

	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(String s) {
		this.s = s;
	}

	
}
