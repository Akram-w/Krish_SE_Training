package com.lptraining.cart;

public class SalesTax extends Handler{
    @Override
    public double calculateFinalTotal(Cart cart) {
        System.out.println("Beginning SalesTax");
        cart.setNetTotal(cart.getNetTotal()+cart.getTotal()*0.08);

        System.out.println("Net Total :"+cart.getNetTotal());
        return cart.getNetTotal();
    }
}
