package com.lptraining.packages;

import com.lptraining.products.Teams;
import com.lptraining.products.WebSearch;
import com.lptraining.products.Zoom;

public class WorkFromHomeMax extends Package {
    @Override
    protected void createPackage() {
        products.add(new Zoom());
        products.add(new Teams());
        products.add(new WebSearch());
    }
}
