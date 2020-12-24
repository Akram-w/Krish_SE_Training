package com.lptraining.packages;

import com.lptraining.products.YouTube;

public class EntertainmentPackageLite extends Package {
    @Override
    protected void createPackage() {
        products.add(new YouTube());
    }
}
