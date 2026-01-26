package com.dealtracker;

import java.time.LocalDate;

public class Promotion<T> {
    protected String code;
    protected LocalDate validTill;
    protected T benefit;

    public Promotion(String code, LocalDate validTill, T benefit) {
        this.code = code;
        this.validTill = validTill;
        this.benefit = benefit;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getValidTill() {
        return validTill;
    }
}
