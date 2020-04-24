package com.gsmserver.product;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    public SelenideElement getTitle() {
        return $("h1");
    }

}
