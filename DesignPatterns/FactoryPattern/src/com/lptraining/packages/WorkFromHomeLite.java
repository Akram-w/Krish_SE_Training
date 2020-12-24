package com.lptraining.packages;

import com.lptraining.products.Zoom;

public class WorkFromHomeLite extends Package {

    @Override
    protected void createPackage() {
        products.add(new Zoom());
    }
}
