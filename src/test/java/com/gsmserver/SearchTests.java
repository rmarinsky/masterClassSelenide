package com.gsmserver;

import com.gsmserver.pages.HomePage;
import com.gsmserver.pages.ProductComponent;
import com.gsmserver.pages.SearchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends BaseTest {

    @BeforeEach
    void openHomePage() {
        open("/");
    }

    @Test
    void searchProductByTitleAndAddToCart() {
        var productName = "Z3X Easy-Jtag Plus Full Set";
        var productId = "872994";

        element("[name='searchword']").val(productName).pressEnter();
        element(".search-title-highlight").shouldHave(text(productName+"d"));

        ProductComponent productComponent = new ProductComponent();
        productComponent.findProductById(productId).$(".product-info_title").shouldHave(text(productName));
        productComponent.findProductById(productId).$("[data-action-click='site.cart.add']").click();
        productComponent.findProductById(productId).$(".in-cart").click();

        element("#cart h1").shouldHave(text("Cart"));

        elements("#cart tr[data-product-id]").shouldHaveSize(1);
        productComponent.findProductById(productId).$(".product-title").shouldHave(text(productName));
    }

    @Test
    void searchProductByTitleTest() {
        var productName = "Z3X Easy-Jtag Plus Full Set";

        new HomePage().searchFor(productName);

        var searchResultPage = new SearchResultPage();

        var actualSearchResultTitle = searchResultPage.getSearchResultTitle();
        Assertions.assertEquals(productName, actualSearchResultTitle);

        var actualSizeOfSearchResult = searchResultPage.getSearchResultListSize();
        Assertions.assertEquals(actualSizeOfSearchResult, 3);

        var actualFirstProductTitle = searchResultPage.getFirstProductInfoTitle();
        Assertions.assertEquals(productName, actualFirstProductTitle);
    }



}
