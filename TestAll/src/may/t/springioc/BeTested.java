package may.t.springioc;

/**
 */
public class BeTested {

	/**
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("1111");
	}
	
	private int id;
	private String name;
	private int age;
	
	
	public void testS()
	{
		System.out.println("id is: " + this.getId());
		System.out.println("name is: " + this.getName());
		System.out.println("age is:" + this.getAge());
	}
	
//	public static BeTested getFactory()
//	{
//		System.out.println("factory...");
//		return new BeTested(3, "ccc", 333);
//	}
	
	/**
	 * 
	 */
	public BeTested() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param age
	 */
	public BeTested(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		System.out.println("use constructor... " + this.toString());
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BeTested [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	/**
	 * @return the id
	 */
	public int getId() {
		System.out.println("use setter... " + this.toString());
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		System.out.println("use setter... " + this.toString());
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		System.out.println("use setter... " + this.toString());
		return name;
		
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	
}
