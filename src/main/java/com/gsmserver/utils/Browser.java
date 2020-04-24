package com.gsmserver.utils;

import com.codeborne.selenide.Selenide;

public class Browser {

    private Browser() {

    }

    public static void openPage(String targetUrl) {
        Selenide.open(targetUrl);
    }

}
