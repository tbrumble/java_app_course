package homework3.Packages;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
/**
 * Тип посылки коробка - переопределяет рассчет стооимости с учетом своего коэффициаента
 */
public class Box extends PackageImpl{
    private static double BOX_PRICE = 2;
    @Override
    public double countCost(PackageDetails packageDetails) {
        return super.countCost(packageDetails) * BOX_PRICE;
    }
}
