import static org.junit.Assert.*;
import org.junit.Test;

public class PlotTestStudent {

    @Test
    public void testDefaultConstructor() {
        Plot p = new Plot();
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
        assertEquals(1, p.getWidth());
        assertEquals(1, p.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        Plot p = new Plot(2, 3, 4, 5);
        assertEquals("2,3,4,5", p.toString());
    }

    @Test
    public void testCopyConstructor() {
        Plot p1 = new Plot(1, 1, 3, 3);
        Plot p2 = new Plot(p1);
        assertEquals(p1.toString(), p2.toString());
        assertNotSame(p1, p2);
    }

    @Test
    public void testOverlaps() {
        Plot a = new Plot(0, 0, 4, 4);
        Plot b = new Plot(2, 2, 4, 4);
        Plot c = new Plot(4, 0, 2, 2);
        assertTrue(a.overlaps(b));
        assertFalse(a.overlaps(c));
    }

    @Test
    public void testEncompasses() {
        Plot big = new Plot(0, 0, 10, 10);
        Plot small = new Plot(2, 2, 3, 3);
        assertTrue(big.encompasses(small));
        assertFalse(small.encompasses(big));
    }
}