package homework3.Packages;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
/**
 * Тип посылки письмо - переопределяет рассчет стооимости с учетом своего коэффициаента
 */
public class Letter extends PackageImpl{
    private static double LETTER_PRICE = 1.2;
    @Override
    public double countCost(PackageDetails packageDetails) {
        return super.countCost(packageDetails) * LETTER_PRICE;
    }
}
