package test.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DemoJUnit {

	@Before
	public void setUp() throws Exception {
		
		System.out.println("We are in the setUp method : ");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("We are in the tearDown method : ");
	}

	@Test
	public void test() {
		assertEquals(10,1+9);
	}

}
