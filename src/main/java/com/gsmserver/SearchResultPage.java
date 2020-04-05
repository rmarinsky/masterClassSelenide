package com.gsmserver;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    public String getSearchResultTitle() {
        return $(".search-title-highlight").getText();
    }
}
