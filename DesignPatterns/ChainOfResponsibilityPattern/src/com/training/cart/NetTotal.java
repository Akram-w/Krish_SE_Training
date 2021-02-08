package com.training.cart;

public class NetTotal extends Handler{
    @Override
    public double calculateFinalTotal(Cart cart) {
        System.out.println("Beginning NetTotal");
        return successor.calculateFinalTotal(cart);
    }
}
