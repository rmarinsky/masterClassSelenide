package com.gsmserver.utils;

public class PriceCalculator {

    private final Double targetPrice;

    public PriceCalculator(String targetPrice) {
        this.targetPrice = Double.valueOf(targetPrice);
    }

    public String multiply(int secondDigit) {
        var result = targetPrice * secondDigit;
        return String.valueOf(result);
    }

}
