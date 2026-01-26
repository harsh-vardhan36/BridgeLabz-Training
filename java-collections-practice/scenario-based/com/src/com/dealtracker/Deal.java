package com.dealtracker;

public class Deal extends Promotion<Integer> {

    private int minPurchase;

    public Deal(String code,
                java.time.LocalDate validTill,
                int discountPercent,
                int minPurchase) {

        super(code, validTill, discountPercent);
        this.minPurchase = minPurchase;
    }

    public int getDiscount() {
        return benefit;
    }

    @Override
    public String toString() {
        return code + " | " + benefit + "% | Min ₹" +
               minPurchase + " | Valid till " + validTill;
    }
}
