package com.swiftcart;

public interface ICheckout {
    void generateBill();
    void applyDiscount(double coupon);
}
