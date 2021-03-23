package homework3.Packages;

import junit.framework.TestCase;
public class PackageImplTest extends TestCase {

    public void testCountCost() {
        Package packageData = new PackageImpl()
                .setFragile(false)
                .setOversize(false)
                .setWeight(1000)
                .setHeight(100)
                .setLength(200)
                .setWidth(100);

        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setDistance(88);
        packageData.countCost(packageDetails);
        assertTrue("Значения равны", packageData.countCost(packageDetails) == 1056000.00);
    }

    public void testSendPackage() {
        assertFalse("guid присвоен", new PackageImpl().sendPackage().toString().equals(""));
    }

}