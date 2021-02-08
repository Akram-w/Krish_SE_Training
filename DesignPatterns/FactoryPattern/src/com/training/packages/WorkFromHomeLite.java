package com.training.packages;

import com.training.products.Zoom;

public class WorkFromHomeLite extends Package {

    @Override
    protected void createPackage() {
        products.add(new Zoom());
    }
}
