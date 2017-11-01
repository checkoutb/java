package june.th.reflect;

/**
 */
public class InterfaceOfTestImpl implements InterfaceOfTest {

	/* (non-Javadoc)
	 * @see june.th.reflect.InterfaceOfTest#Say(java.lang.String, int)
	 */
	@Override
	public String Say(String name, int age) {
		return name + " is " + age + " years old";
	}

	public String Say(int age, String name)
	{
		return "zxcvbnmm,";
	}
}
