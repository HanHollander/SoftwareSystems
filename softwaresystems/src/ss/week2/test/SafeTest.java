package ss.week2.test;

import static org.junit.Assert.*;
import ss.week2.hotel.Safe;
import ss.week2.hotel.Password;

import org.junit.Before;
import org.junit.Test;

public class SafeTest {
	
	private Safe safe;

	@Before
	public void setUp() throws Exception {
		safe = new Safe();
	}
	
	@Test
	public void testInitialState() {
		assertFalse(safe.isActive());
		assertTrue(safe.getPassword().testWord("password"));
		assertFalse(safe.isOpen());
	}
	
	@Test
	public void testActivation() {
		assertFalse(safe.activate("falsepassword"));
		assertFalse(safe.isActive());
		assertFalse(safe.isOpen());
		assertTrue(safe.activate("password"));
		assertTrue(safe.isActive());
		assertFalse(safe.isOpen());
	}
	
	@Test
	public void testDeactivation() {
		assertFalse(safe.deactivate());
		assertFalse(safe.isOpen());
		assertTrue(safe.activate("password"));
		assertFalse(safe.isOpen());
		assertTrue(safe.isActive());
		assertTrue(safe.deactivate());
		assertFalse(safe.isOpen());
		assertFalse(safe.isActive());
		
		safe.activate("password");
		safe.open("password");
		
		assertTrue(safe.isOpen());
		assertTrue(safe.deactivate());
		assertFalse(safe.isOpen());
	}
	
	@Test
	public void testOpening() {
		assertFalse(safe.open("falsepassword"));
		assertFalse(safe.isOpen());
		assertFalse(safe.isActive());
		assertFalse(safe.open("password"));
		assertFalse(safe.isOpen());
		assertFalse(safe.isActive());
		
		safe.activate("password");
		assertTrue(safe.open("password"));
		assertTrue(safe.isOpen());
		assertTrue(safe.isActive());
	}
	
	@Test
	public void testClosing() {
		assertFalse(safe.close());
		safe.activate("password");
		assertTrue(safe.open("password"));
		assertTrue(safe.isOpen());
		assertTrue(safe.close());
		assertFalse(safe.isOpen());
		assertTrue(safe.isActive());
	}
}
