package ss.week3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.io.PrintStream;

import ss.week3.hotel.*;

public class BillTest {
	
	private Bill bill;
	private TestItem soap;
	
	@Before
	public void setUp() {
		bill = new Bill(null);
		soap = new TestItem("soap", 2000.95);
	}

	@Test
	public void testInitialState() {
		assertEquals(0.0, bill.getSum(), 0.001);
	}
	
	@Test
	public void testNewItem() {
		bill.newItem(soap);
		assertEquals(2000.95, bill.getSum(), 0.001);
		bill.newItem(soap);
		assertEquals(4001.90, bill.getSum(), 0.001);
	}

}
