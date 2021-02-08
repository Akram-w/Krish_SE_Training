package com.training.packages;

import com.training.products.YouTube;

public class EntertainmentPackageLite extends Package {
    @Override
    protected void createPackage() {
        products.add(new YouTube());
    }
}
