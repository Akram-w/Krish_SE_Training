package com.lptraining;

public class Application {
    public static void main(String[] args) {
        Properties properties = Properties.getProperties();
        Properties properties1 = Properties.getProperties();

        System.out.println(properties);
        System.out.println(properties1);
//        System.out.println(properties.getUser());
    }
}
