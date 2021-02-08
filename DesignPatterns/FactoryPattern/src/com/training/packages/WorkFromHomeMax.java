package com.training.packages;

import com.training.products.Teams;
import com.training.products.WebSearch;
import com.training.products.Zoom;

public class WorkFromHomeMax extends Package {
    @Override
    protected void createPackage() {
        products.add(new Zoom());
        products.add(new Teams());
        products.add(new WebSearch());
    }
}
