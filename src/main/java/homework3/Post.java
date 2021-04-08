package homework3;

import homework3.Packages.*;
import homework3.Packages.Package;
import homework3.PostService.RussianPostService;

import java.util.Scanner;

public class Post {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //вводим данные посылки
        System.out.println("Введите данные посылки:вес(гм),длина(см),высота(см),ширина(см),хрупкий(true/false),неформат(true/false)");
        String[] packageStringData = scanner.nextLine().split(",");
        if (packageStringData.length != 6){
            System.out.println("Ошибка ввода данных");
            System.exit(0);
        }

        //вводим тип посылки и прокидываем данные посылки
        System.out.println("Введите тип посылки: 1 - письмо 2 - коробка");
        //относительно типа создает класс и заполняем данными
        PackageCreator packageCreator = new PackageCreatorImpl();
        Package packageData = packageCreator.createPackageByType(scanner.nextByte(),
                Double.parseDouble(packageStringData[0]),
                Double.parseDouble(packageStringData[1]),
                Double.parseDouble(packageStringData[2]),
                Double.parseDouble(packageStringData[3]),
                Boolean.parseBoolean(packageStringData[4]),
                Boolean.parseBoolean(packageStringData[5])
                );

        //вводим расстояние до получателя
        System.out.println("Введите расстояние до адресата:расстояние(км)");
        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setDistance(scanner.nextByte());

        //выводим стоимость доставки
        System.out.printf("Стоимость доставки будет равна: %.2f%n",
                packageData.countCost(packageDetails));
        //имитируем отправку
        System.out.printf("Посылка отправлена, идентификатор: %s%n",
                new RussianPostService().sendPackage(packageData));
    }
}
