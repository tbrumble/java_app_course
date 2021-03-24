package homework3.Packages;

import junit.framework.TestCase;

public class BoxTest extends TestCase {

    public void testCountCost() {
        Package packageData = new Box()
                .setFragile(false)
                .setOversize(false)
                .setWeight(1000)
                .setHeight(100)
                .setLength(200)
                .setWidth(100);

        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setDistance(88);
        assertTrue("Значения равны", packageData.countCost(packageDetails) == 2112000.00);
    }
}