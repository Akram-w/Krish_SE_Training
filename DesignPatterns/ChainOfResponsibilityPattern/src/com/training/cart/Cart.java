package com.training.cart;

public class Cart {
    private int cartNo;
    private double total;
    private double netTotal;
    private String voucherCode;

    protected void setNetTotal(double netTotal){
        this.netTotal=netTotal;
    }

    public Cart(int cartNo, double total,String voucherCode) {
        this.cartNo = cartNo;
        this.total = total;
        this.voucherCode=voucherCode;
        this.netTotal=total;
    }

    public int getCartNo() {
        return cartNo;
    }

    public double getTotal() {
        return total;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public String getVoucherCode() {
        return voucherCode;
    }
}
