package june.th.reflect;

/**
 */
public class TargetClass {

	public int id;
	private String name;
	private int age;
	
	public void Say()
	{
		System.out.println("hello, world!");
	}
	
	public void Say(String a, int b)
	{
		System.out.println(a + b);
	}
	
	public void Say(int a, String b)
	{
		System.out.println(a + b + "..........");
	}
	
	public TargetClass()
	{
		
	}
	
	public TargetClass(int id, String name, int age)
	{
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TargetClass [id=" + id + ", name=" + name + ", age=" + age + "]";
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
	 * @return the name
	 */
	public String getName() {
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
