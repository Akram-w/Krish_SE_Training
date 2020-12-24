package com.lptraining.packages;

import com.lptraining.products.AmazonPrime;
import com.lptraining.products.Netflix;
import com.lptraining.products.YouTube;

public class EntertainmentPackageMax extends Package {
    @Override
    protected void createPackage() {
        products.add(new YouTube());
        products.add(new AmazonPrime());
        products.add(new Netflix());
    }
}
