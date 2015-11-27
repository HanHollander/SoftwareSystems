package ss.week3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week3.hotel.*;

public class BillTest {
	
	private Bill bill;
	private TestItem soap;
	
	@Before
	public void setUp() {
		bill = new Bill(new java.io.PrintStream(System.out));
		soap = new TestItem("soap", 2000.95);
	}

	@Test
	public void testNewItem() {
		assertEquals(0, bill.getSum());
	}

}
