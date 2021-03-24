package homework3.PostService;

import homework3.Packages.Package;

/**
 * Внешний сервис отправки посылки - имитирует отправки, передаем в качестве параметра интерфейс
 */
public abstract class PostService {
    public abstract String sendPackage(Package packageData);
}
