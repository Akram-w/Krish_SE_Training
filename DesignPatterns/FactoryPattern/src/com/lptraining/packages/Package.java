package com.lptraining.packages;

import com.lptraining.products.PackageProducts;

import java.util.ArrayList;
import java.util.List;

public abstract class Package {
    protected List<PackageProducts> products=new ArrayList<>();
    public Package(){
        createPackage();
    }
    protected abstract void createPackage();

    @Override
    public String toString() {
        return "Packages{" +
                "products=" + products +
                '}';
    }
}
