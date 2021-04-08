package homework3.Packages;

import homework3.DeliverTypes.DeliverType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Базовый класс для посылки считает стоимость относительно своих размеров, типов доставки и содержим параметры
 * вес, размер и т.д.
 */
@RequiredArgsConstructor
public class PackageImpl implements Package {
    private static int SYSTEM_C_METER = 1000000;

    private double weight;
    private double length;
    private double height;
    private double width;
    private boolean fragile;
    private boolean oversize;

    public PackageImpl(@NonNull double weight, @NonNull double length, @NonNull double height, @NonNull double width,
                       @NonNull boolean fragile, @NonNull boolean oversize) {
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.width = width;
        this.fragile = fragile;
        this.oversize = oversize;
    }

    private Double calcDeliverTypes(List<DeliverType> deliverTypes){
        double cost = 0;
        for (DeliverType deliverType: deliverTypes){
                cost += deliverType.getDeliverCostByType(deliverType) * getVolume() * weight;
                if (fragile) {
                    cost += cost * 0.1;
                }
                if (oversize) {
                    cost += cost * 0.5;
                }
            }
            return cost;
        }

    private Double getVolume(){
        return length*height*width/SYSTEM_C_METER;
    }

    @Override
    public double countCost(PackageDetails packageDetails) {
        return calcDeliverTypes(packageDetails.deliverTypes) * packageDetails.distance;
    }

    @Override
    public UUID sendPackage() {
        return UUID.randomUUID();
    }


}
