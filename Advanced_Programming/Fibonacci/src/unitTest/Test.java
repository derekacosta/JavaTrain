package unitTest;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test1() {
		assertEquals(1, Fibonacci.calculate1(0));
	}
	
	@Test
	public void test2() {
		assertEquals(1, Fibonacci.calculate1(4));
	}
	
}
