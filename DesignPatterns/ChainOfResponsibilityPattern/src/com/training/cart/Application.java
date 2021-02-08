package com.training.cart;

public class Application {

    public static void main(String[] args) {

        NetTotal netTotal=new NetTotal();
        SeasonalOffer seasonalOffer=new SeasonalOffer();
        VoucherCode voucherCode=new VoucherCode();
        SalesTax salesTax=new SalesTax();

        netTotal.setSuccessor(seasonalOffer);
        seasonalOffer.setSuccessor(voucherCode);
        voucherCode.setSuccessor(salesTax);

        Cart cart=new Cart(1,100,"CA001");
        System.out.println("Total :"+cart.getTotal());
        System.out.println("Calculated NetTotal :"+netTotal.calculateFinalTotal(cart));
    }
}
