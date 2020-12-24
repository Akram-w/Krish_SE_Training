package com.lptraining;

import com.lptraining.packages.*;
import com.lptraining.packages.Package;

public class PackageFactory {
    public static Package createPackage(PackageCode packageCode){

        switch (packageCode){
            case ENTERTAINMENT_LITE:
                return new EntertainmentPackageLite();
            case ENTERTAINMENT_MAX:
                return new EntertainmentPackageMax();
            case WFH_LITE:
                return new WorkFromHomeLite();
            case WFH_MAX:
                return new WorkFromHomeMax();
            default:
                return null;
        }
    }
}
