package com.gsmserver.product;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class ProductComponent {

    private final String productId;
    private SelenideElement parentElement = $("html");

    public ProductComponent(String productId) {
        this.productId = productId;
    }

    private ProductComponent(String productId, SelenideElement parentElement) {
        this.productId = productId;
        this.parentElement = parentElement;
    }

    public static ProductComponent findProductFromParent(String productId, SelenideElement parentElement) {
        return new ProductComponent(productId, parentElement);
    }

    private SelenideElement findProductById() {
        return parentElement.$(by("data-product-id", productId));
    }

    @Step
    public ProductComponent clickOnAddToCart() {
        findProductById().$(by("data-action-click", "site.cart.add")).click();
        return this;
    }

    @Step
    public void clickOnGoToCart() {
        findProductById().$(".in-cart").click();
    }

    @Step
    public SelenideElement getProductTitle() {
        return findProductById().$(".product-info_title,[original-title]");
    }

    @Step
    public ProductComponent clickOnPlus() {
        findProductById().$("[name='btn-plus']").click();
        return this;
    }

    @Step
    public ProductComponent clickOnMinus() {
        findProductById().$("[name='btn-minus']").click();
        return this;
    }

    @Step
    public SelenideElement getInCartQuantity() {
        return findProductById().$("[name='quantity']");
    }

}
