package july.t.clone;

import java.io.Serializable;

/**
 */
public class Clone2 implements Serializable{

	private static final long serializable = -26538904146832L;
	private int id;
	private Clone1 c1;
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
	 * @return the c1
	 */
	public Clone1 getC1() {
		return c1;
	}
	/**
	 * @param c1 the c1 to set
	 */
	public void setC1(Clone1 c1) {
		this.c1 = c1;
	}
	
	
}
