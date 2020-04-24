package com.gsmserver.pages;

import com.gsmserver.product.ProductComponent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

public class HomePage {

    public SearchComponent searchComponent;

    public HomePage() {
        searchComponent = new SearchComponent();
    }

    public ProductComponent targetProduct(String productId) {
        return new ProductComponent(productId);
    }

    public static class DropdownAccount {

        private final By
                dropDownAccount = cssSelector("[space*='dropdown/account']"),
                loginDropDownItem = cssSelector("[name='login']"),
                registrationDropDownItem = cssSelector("[name='registration']");

        public DropdownAccount openDropDownPopup() {
            $(dropDownAccount).click();
            return this;
        }

        public void openLoginPopup() {
            $(loginDropDownItem).click();
            new LoginPopup();
        }

        public void openRegistrationPopup() {
            $(registrationDropDownItem).click();
        }

    }

}
