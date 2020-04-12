package com.gsmserver.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    @Step
    public void searchFor(String searchQuery) {
        $("[name='searchword']").val(searchQuery).pressEnter();
    }
}
