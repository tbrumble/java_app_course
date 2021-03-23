package homework3;

import homework3.Packages.Package;

/**
 * Внешний сервис отправки посылки - имитирует отправки, передаем в качестве параметра интерфейс
 */
public class PostService {
    public String sendPackage(Package packageData){
        return packageData.sendPackage().toString();
    }
}
