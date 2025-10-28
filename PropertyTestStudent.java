/*
 * Class: CMSC203 
 * Instructor:Shah Madhvi
 * Description: This Property Management application allows users to manage 
 * and analyze rental properties through a graphical interface built with JavaFX. 
 * It supports adding, viewing, and calculating property details such as rent 
 * and plot size, demonstrating object-oriented design and GUI development.
 * Due: 10/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here:Ray Leika Joseph
*/




import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyTestStudent {

    @Test
    public void testDefaultConstructor() {
        Property p = new Property();
        assertEquals("", p.getPropertyName());
        assertEquals("", p.getCity());
        assertEquals("", p.getOwner());
        assertEquals(0.0, p.getRentAmount(), 0.01);
    }

    @Test
    public void testConstructorWithPlot() {
        Property p = new Property("Home", "Town", 1800.0, "Sam", 2, 3, 4, 5);
        assertEquals("2,3,4,5", p.getPlot().toString());
    }

    @Test
    public void testCopyConstructor() {
        Property p1 = new Property("Apt", "City", 2200.0, "Alex", 1,1,2,2);
        Property p2 = new Property(p1);
        assertEquals(p1.toString(), p2.toString());
        assertNotSame(p1.getPlot(), p2.getPlot());
    }

    @Test
    public void testToString() {
        Property p = new Property("House", "Metro", 1500.0, "Taylor");
        assertEquals("House,Metro,Taylor,1500.0", p.toString());
    }
}