package com.lptraining.broadband;

public class Application {
    public static void main(String[] args) {

        BroadbandPackage.PackageBuilder packageBuilder = new BroadbandPackage.PackageBuilder("Waseem", "962532306v", "70GB");

        System.out.println(packageBuilder.build());

        BroadbandPackage broadbandPackage = packageBuilder.workFromHomePackage("WFH-Lite").entertainmentPackage("Entertainment-Lite").build();

        System.out.println(broadbandPackage);
    }
}
