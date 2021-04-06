package homework3.Packages;

/**
 * Тип посылки письмо - переопределяет рассчет стооимости с учетом своего коэффициаента
 */
public class Letter extends PackageImpl{
    private static double LETTER_PRICE = 1.2;

    public Letter(double weight, double length, double height, double width, boolean fragile, boolean oversize) {

        super(weight, length, height, width, fragile, oversize);
    }

    @Override
    public double countCost(PackageDetails packageDetails) {
        return super.countCost(packageDetails) * LETTER_PRICE;
    }
}
