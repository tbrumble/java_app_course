package homework3.Packages;

/**
 * Тип посылки коробка - переопределяет рассчет стооимости с учетом своего коэффициаента
 */
public class Box extends PackageImpl{
    private static double BOX_PRICE = 2;

    public Box(double weight, double length, double height, double width, boolean fragile, boolean oversize) {
        super(weight, length, height, width, fragile, oversize);
    }

    @Override
    public double countCost(PackageDetails packageDetails) {
        return super.countCost(packageDetails) * BOX_PRICE;
    }
}
