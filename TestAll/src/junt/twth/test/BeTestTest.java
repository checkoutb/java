package junt.twth.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 */
@RunWith(Parameterized.class)		//要自己手动导入的。
public class BeTestTest {

	private static BeTest b = new BeTest();
	
	private int param;
	private int result;
	
	@Parameters
	public static Collection data()
	{
		return Arrays.asList(new Object[][]{{2,4},{3,9},{11,121}});
	}
	
	public BeTestTest(int param, int result)
	{
		this.param = param;
		this.result = result;
	}
	
	
	@Test		//批量test，要类上的@RunWith(Parameterized.class),和构造方法，param，result，@Parameters
	public void square()
	{
		b.square(param);
		assertEquals(result, b.getReault());
	}
	
	/**
	 */
	@Before
	public void setUp() throws Exception {
		b.clear();
	}

	/**
	 * Test method for {@link junt.twth.test.BeTest#add(int)}.
	 */
	@Test
	public void testAdd() {
		b.add(3);
		b.add(3);
		assertEquals(3, b.getReault());
	}

	/**
	 * Test method for {@link junt.twth.test.BeTest#substract(int)}.
	 */
	@Test
	public void testSubstract() {
		b.add(10);
		b.substract(4);
		assertEquals(6, b.getReault());
	}

	/**
	 * Test method for {@link junt.twth.test.BeTest#square(int)}.
	 */
	@Test
	public void testSquare() {
		b.square(4);
		assertEquals(13, b.getReault());
	}

	/**
	 * Test method for {@link junt.twth.test.BeTest#forever()}.
	 */
//	@Ignore
	@Test(timeout=1000)
	public void testForever() {
		b.forever();
	}

	/**
	 * Test method for {@link junt.twth.test.BeTest#clear()}.
	 */
	@Ignore
	@Test
	public void testClear() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link junt.twth.test.BeTest#getReault()}.
	 */
	@Ignore
	@Test
	public void testGetReault() {
		fail("Not yet implemented");
	}

}
