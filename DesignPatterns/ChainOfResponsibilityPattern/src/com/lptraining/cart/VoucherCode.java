package com.lptraining.cart;

public class VoucherCode extends Handler{
    @Override
    public double calculateFinalTotal(Cart cart) {
        System.out.println("Beginning VoucherCode");
        if(cart.getVoucherCode().equals("CA001")){
            cart.setNetTotal(cart.getNetTotal()-cart.getTotal()*0.02);
        }
        System.out.println("Net Total :"+cart.getNetTotal());
        return successor.calculateFinalTotal(cart);
    }
}
