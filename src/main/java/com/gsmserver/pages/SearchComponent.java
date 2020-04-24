package com.gsmserver.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchComponent extends BasePage {

    @Step
    public void searchFor(String searchQuery) {
        $("[name='searchword']").val(searchQuery).pressEnter();
    }

    @Step
    public SearchComponent fillSearchQuery(String searchQuery) {
        $("[name='searchword']").val(searchQuery);
        return this;
    }

    @Step
    public SearchComponent clickOnSeeAll() {
        $("[data-quicksearch='bottom-block'] a").click();
        return this;
    }

}
