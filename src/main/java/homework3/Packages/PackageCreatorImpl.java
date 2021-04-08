package homework3.Packages;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PackageCreatorImpl implements PackageCreator {
    public Package createPackageByType(@NonNull int packageType, @NonNull double weight, @NonNull double length,
                                       @NonNull double height, @NonNull double width, @NonNull boolean fragile,
                                       @NonNull boolean oversize){
        if (packageType == 1) {
            return new Letter(weight, length, height, width, fragile, oversize);
        } else {
            return new Box(weight, length, height, width, fragile, oversize);
        }
    }
}
