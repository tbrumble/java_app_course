package homework3.Packages;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoxTest extends TestCase {
    private final double CORRECT_COST = 2112000.00;
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
        Package packageData = new Box(weight, length, height, width, fragile, oversize);
        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setDistance(distance);
        int compareResult = Double.compare(packageData.countCost(packageDetails), CORRECT_COST);
        assertTrue("Значения равны", compareResult == 0);
    }
}