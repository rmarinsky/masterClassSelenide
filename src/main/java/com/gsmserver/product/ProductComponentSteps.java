package com.gsmserver.product;

import io.qameta.allure.Step;

public class ProductComponentSteps {

    private static ProductComponent productComponent;

    public static ProductComponentSteps targetProduct(ProductDto productDto) {
        productComponent = new ProductComponent(productDto.getId());
        return new ProductComponentSteps();
    }

    @Step
    public ProductComponentSteps addToCartProduct() {
        productComponent.clickOnAddToCart();
        return this;
    }

    @Step
    public ProductComponentSteps increaseProductCountTo(int count) {
        for (int i = 0; i < count; i++) {
            productComponent.clickOnPlus();
        }
        return this;
    }

    @Step
    public ProductComponentSteps decreaseProductCountTo(int count) {
        for (int i = 0; i < count; i++) {
            productComponent.clickOnMinus();
        }
        return this;
    }

    @Step
    public String getProductCount() {
        return productComponent.getInCartQuantity().getValue();
    }

    public String getProductPageTitle() {
        return new ProductPage().getTitle().getText();
    }

    public String getProductTitle() {
        return productComponent.getProductTitle().getText();
    }
}
