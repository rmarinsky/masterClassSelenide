package com.gsmserver;

import com.gsmserver.pages.HomePage;
import com.gsmserver.pages.SearchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends BaseTest {

    private final String
            productName = "Z3X Easy-Jtag Plus Full Set",
            productId = "872994";


    @BeforeEach
    void openHomePage() {
        open("/");
    }

    @Test
    void searchProductByTitleAndAddToCart() {
        element("[name='searchword']").val(productName).pressEnter();
        element(".search-title-highlight").shouldHave(text(productName));

        SearchResultPage searchResultPage = new SearchResultPage();

        var targetProduct = searchResultPage.targetProduct(productId);
        targetProduct.getProductTitle().shouldHave(text(productName));
        targetProduct.clickOnAddToCart().clickOnGoToCart();

        element("#cart h1").shouldHave(text("Cart"));

        elements("#cart tr[data-product-id]").shouldHaveSize(1);
        searchResultPage.targetProduct(productId).getProductTitle().shouldHave(text(productName));
    }

    @Test
    void searchProductByTitleTest() {
        new HomePage().searchComponent.searchFor(productName);

        var searchResultPage = new SearchResultPage();

        var actualSearchResultTitle = searchResultPage.getSearchResultTitle();
        Assertions.assertEquals(productName, actualSearchResultTitle);

        var actualSizeOfSearchResult = searchResultPage.getSearchResultListSize();
        Assertions.assertEquals(actualSizeOfSearchResult, 3);

        var actualFirstProductTitle = searchResultPage.getFirstProductInfoTitle();
        Assertions.assertEquals(productName, actualFirstProductTitle);
    }

    @Test
    void searchForProductViaClickOnSeeAllTest() {
        new HomePage().searchComponent.fillSearchQuery(productName).clickOnSeeAll();
        var searchResultPage = new SearchResultPage();

        var actualSearchResultTitle = searchResultPage.getSearchResultTitle();
        Assertions.assertEquals(productName, actualSearchResultTitle);

    }


}
