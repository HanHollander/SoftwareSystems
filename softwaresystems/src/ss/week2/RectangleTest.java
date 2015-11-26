package ss.week2;

import org.junit.Before;
import org.junit.Test;
import ss.week2.Rectangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Testprogram for Rectangle.
 * @author Weidse en Solo
 * @version $Revision: 4.20$
 */
public class RectangleTest {
	/** Testvariable for a <tt>Rectangle</tt>-object. */
	private Rectangle rect;
	/**
     * Sets initial variables to a well-defined initial value.
     * <p>
     * Assigns a <tt>Rectangle</tt> object to the <tt>ot</tt> instance variable
     */
    @Before
    public void setUp() {
        // initialization of Rectangle
        rect = new Rectangle(10,10);
    }

    /**
     * Test if the initial condition complies to the specification.
     */
    @Test
    public void testInitialcondition() {
        assertEquals(10, rect.length());
        assertEquals(10, rect.width());
        assertEquals(100, rect.area());
        assertEquals(40, rect.perimeter());
    }

}
