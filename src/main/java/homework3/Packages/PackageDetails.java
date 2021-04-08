package homework3.Packages;

import homework3.DeliverTypes.DeliverType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;

/**
 * Класс деталей доставки - пока тут только расстояние до пункта назначения
 * выставляем случайным образом типы доставки в зависимости от введенного расстояния до получателя
 */
@Data
@Accessors(chain = true)
public class PackageDetails {
    ArrayList<DeliverType> deliverTypes;

    public void setDistance(double distance) {
        this.distance = distance;

        if ((distance > 0) && (distance <= 15)) {
            deliverTypes.add(DeliverType.PostMan);
        } else if ((distance > 15) && (distance <= 30)) {
            deliverTypes.add(DeliverType.Car);
        } else if ((distance > 30) && (distance <= 60)) {
            deliverTypes.add(DeliverType.PostMan);
            deliverTypes.add(DeliverType.Train);
        } else if ((distance > 60) && (distance <= 100)) {
            deliverTypes.add(DeliverType.PostMan);
            deliverTypes.add(DeliverType.Train);
            deliverTypes.add(DeliverType.Car);
        } else if (distance > 100) {
            deliverTypes.add(DeliverType.PostMan);
            deliverTypes.add(DeliverType.Train);
            deliverTypes.add(DeliverType.Car);
            deliverTypes.add(DeliverType.Deers);
            deliverTypes.add(DeliverType.Airplane);
        }

    }

    double distance;

    public PackageDetails(){
        deliverTypes = new ArrayList<>();
    }

}
