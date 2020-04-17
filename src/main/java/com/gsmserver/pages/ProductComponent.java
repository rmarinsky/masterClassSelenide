package com.gsmserver.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.element;

public class ProductComponent {

    public SelenideElement findProductById(String productId) {
        return element(by("data-product-id", productId));
    }

}
