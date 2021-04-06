package homework3.Packages;


import junit.extensions.TestSetup;
import junit.framework.TestCase;

public class PackageImplTest extends TestCase {
    private final double CORRECT_COST = 1056000.00;

    private double distance, weight, length, height, width;
    private boolean fragile, oversize;

    @Override
    protected void setUp() throws Exception {
        weight = 1000;
        height = 100;
        length = 200;
        width = 100;
        fragile = false;
        oversize = false;
        distance = 88;
        super.setUp();
    }

    public void testCountCost() {
        Package packageData = new PackageImpl(weight, length, height, width, fragile, oversize);
        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setDistance(distance);
        int resultCompare = Double.compare(packageData.countCost(packageDetails), CORRECT_COST);
        assertTrue("Значения равны", resultCompare == 0);
    }

    public void testSendPackage() {
        assertFalse("guid присвоен", new PackageImpl(weight, length, height, width, fragile, oversize).sendPackage().toString().equals(""));
    }

}