package homework3.Packages;

import lombok.experimental.Accessors;

import java.util.UUID;

public interface Package {
    double countCost(PackageDetails packageDetails);
    UUID sendPackage();
}
