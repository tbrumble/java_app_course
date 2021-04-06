package homework3.Packages;

import lombok.NonNull;

public interface PackageCreator {
    Package createPackageByType(@NonNull int packageType, @NonNull double weight, @NonNull double length,
                                @NonNull double height, @NonNull double width, @NonNull boolean fragile,
                                @NonNull boolean oversize);
}
