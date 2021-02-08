package com.training.packages;

import com.training.products.AmazonPrime;
import com.training.products.Netflix;
import com.training.products.YouTube;

public class EntertainmentPackageMax extends Package {
    @Override
    protected void createPackage() {
        products.add(new YouTube());
        products.add(new AmazonPrime());
        products.add(new Netflix());
    }
}
