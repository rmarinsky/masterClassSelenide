package com.gsmserver.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Calculator {

    public String multiply(String price, int count) {
        var firstValue = Double.valueOf(price);
        var result = firstValue * count;

        return String.valueOf(Math.round(result));
    }

}
