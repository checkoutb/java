package junt.twth.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 */
public class BeTestTest2 {

	private static BeTest b = new BeTest();
	
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
		b.add(77);
		assertEquals(80, b.getReault());
	}



}
