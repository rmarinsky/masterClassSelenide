package com.gsmserver.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

    private final By productListItem = By.cssSelector(".product-view-list li");

    @Step
    public String getSearchResultTitle() {
        return $(".search-title-highlight").getText();
    }

    public int getSearchResultListSize() {
        return $$(productListItem).size();
    }

    public String getFirstProductInfoTitle() {
        return $(productListItem).$(".product-info_title").getText();
    }


}
