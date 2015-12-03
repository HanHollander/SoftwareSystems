package ss.week4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week4.math.Function;
import ss.week4.math.Polynomial;

public class PolynomialTest {
	
	public static final double DELTA = 0.01;
	private Polynomial poly;

	@Before
	public void setUp() {
		double[] parts = new double[]{7,9,3,6};
		poly = new Polynomial(parts);
	}

	@Test
	public void testApply() {
		assertEquals(877, poly.apply(5), DELTA);
		assertEquals(25, poly.apply(1), DELTA);
	}
	
	@Test
	public void testDerivative() {
		Function deriv = poly.derivative();
		assertEquals(489, deriv.apply(5), DELTA);
		assertEquals(33, deriv.apply(1), DELTA);
	}
	
	@Test
	public void testIntegrand() {
		Function integ = poly.integrand();
		assertEquals(1210, integ.apply(5), DELTA);
		assertEquals(14, integ.apply(1), DELTA);
		
	}

}
