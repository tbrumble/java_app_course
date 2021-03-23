package homework3;

import homework3.DeliverTypes.DeliverType;
import homework3.Packages.*;
import homework3.Packages.Package;

import java.util.Scanner;

public class Post {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //вводим данные посылки
        System.out.println("Введите данные посылки:длина(см),высота(см),ширина(см),вес(гм),хрупкий(true/false),неформат(true/false)");
        String[] packageStringData = scanner.nextLine().split(",");
        if (packageStringData.length != 6){
            System.out.println("Ошибка ввода данных");
            System.exit(0);
        }

        //вводим тип посылки
        System.out.println("Введите тип посылки: 1 - письмо 2 - коробка");
        PackageImpl packageData = null;
        byte packageType = scanner.nextByte();

        //относительно типа создает класс
        if (packageType == 1) {
          packageData = new Letter();
        } else if (packageType == 2) {
            packageData = new Box();
        } else {
            System.out.println("Ошибка ввода типа посылки");
            System.exit(0);
        }
        //заполняем данными
        packageData.setLength(Double.parseDouble(packageStringData[0]))
                .setHeight(Double.parseDouble(packageStringData[1]))
                .setWidth(Double.parseDouble(packageStringData[2]))
                .setWeight(Double.parseDouble(packageStringData[3]))
                .setFragile(Boolean.parseBoolean(packageStringData[4]))
                .setOversize(Boolean.parseBoolean(packageStringData[5]));

        //вводим расстояние до получателя
        System.out.println("Введите расстояние до адресата:расстояние(км)");
        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setDistance(scanner.nextByte());

        //выводим стоимость доставки
        System.out.printf("Стоимость доставки будет равна: %.2f%n",
                packageData.countCost(packageDetails));
        //имитируем отправку
        System.out.printf("Посылка отправлена, идентификатор: %s%n",
                new PostService().sendPackage(packageData));
    }
}
