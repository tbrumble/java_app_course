package homework3.PostService;

import homework3.Packages.Package;

public class RussianPostService extends PostService{

    @Override
    public String sendPackage(Package packageData) {
        return packageData.sendPackage().toString().concat(" P.S: Мы не гарантируем доставку вашей посылки!");
    }
}
