package com.training.cart;

public class SeasonalOffer extends Handler{

    @Override
    public double calculateFinalTotal(Cart cart) {
        System.out.println("Beginning SeasonalOffer");
        cart.setNetTotal(cart.getTotal()-cart.getTotal()*0.05);
        System.out.println("Net Total :"+cart.getNetTotal());
        return successor.calculateFinalTotal(cart);
    }
}
