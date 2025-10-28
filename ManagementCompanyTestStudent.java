import static org.junit.Assert.*;
import org.junit.Test;

public class ManagementCompanyTestStudent {

    @Test
    public void testAddProperty() {
        ManagementCompany mc = new ManagementCompany("TestCo", "12345", 5);
        int index = mc.addProperty("Home","City",2000,"Owner",1,1,2,2);
        assertEquals(0, index);
    }

    @Test
    public void testPropertiesFull() {
        ManagementCompany mc = new ManagementCompany("TestCo", "12345", 5);
        for(int i=0; i<ManagementCompany.MAX_PROPERTY; i++)
            mc.addProperty("H"+i,"C",1000+i,"O",i,0,1,1);
        assertTrue(mc.isPropertiesFull());
    }

    @Test
    public void testGetTotalRent() {
        ManagementCompany mc = new ManagementCompany("TestCo", "12345", 5);
        mc.addProperty("A","X",1000,"O",1,1,2,2);
        mc.addProperty("B","Y",2000,"O",4,1,2,2);
        assertEquals(3000.0, mc.getTotalRent(), 0.01);
    }

    @Test
    public void testHighestRentProperty() {
        ManagementCompany mc = new ManagementCompany("TestCo", "12345", 5);
        mc.addProperty("Cheap","X",900,"O",1,1,2,2);
        mc.addProperty("Expensive","Y",5000,"O",4,1,2,2);
        assertEquals("Expensive", mc.getHighestRentProperty().getPropertyName());
    }
}
