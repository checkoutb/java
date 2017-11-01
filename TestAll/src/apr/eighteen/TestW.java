package apr.eighteen;

/**
 * 
 */
public class TestW {

	/**
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestSubSup a = new TestSubSup();
		TestNullEuqals t = (TestNullEuqals)a;
		t = new TestSubSup();
		((TestSubSup) t).Re();
		
	}

}
