package homework3.Packages;

import junit.framework.TestCase;
import org.junit.Before;

public class LetterTest extends TestCase {
    private final double CORRECT_COST = 1267200.00;
    private double distance, weight, height, length, width;
    boolean fragile, oversize;

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
        Package packageData = new Letter(weight, length, height, width, fragile, oversize);
        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setDistance(distance);
        int resultCompare = Double.compare(packageData.countCost(packageDetails), CORRECT_COST);
        assertTrue("Значения равны", resultCompare == 0);
    }
}