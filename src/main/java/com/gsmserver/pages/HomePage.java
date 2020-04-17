package com.gsmserver.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

public class HomePage {

    @Step
    public void searchFor(String searchQuery) {
        $("[name='searchword']").val(searchQuery).pressEnter();
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

        public LoginPopup openLoginPopup() {
            $(loginDropDownItem).click();
            return new LoginPopup();
        }

        public void openRegistrationPopup() {
            $(registrationDropDownItem).click();
        }

    }

}
