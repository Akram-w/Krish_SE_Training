package com.lptraining;

import com.lptraining.packages.Package;
import com.lptraining.packages.PackageCode;

public class Application {

    public static void main(String[] args) {
        Package entertainmentLite=PackageFactory.createPackage(PackageCode.ENTERTAINMENT_LITE);
        System.out.println(entertainmentLite);

        Package entertainmentMax=PackageFactory.createPackage(PackageCode.ENTERTAINMENT_MAX);
        System.out.println(entertainmentMax);
    }
}
