package com.gsmserver;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.gsmserver.pages.HomePage;
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

        findProductById(productId).$(".product-info_title").shouldHave(text(productName));
        findProductById(productId).$("[data-action-click='site.cart.add']").click();
        findProductById(productId).$(".in-cart").click();

        element("#cart h1").shouldHave(text("Cart"));

        elements("#cart tr[data-product-id]").shouldHaveSize(1);
        findProductById(productId).$(".product-title").shouldHave(text(productName));
    }

    @Test
    void searchProductByTitleTest() {
        var productName = "Z3X Easy-Jtag Plus Full Set";

        new HomePage().searchFor(productName);
        var actualSearchResultTitle = new SearchResultPage().getSearchResultTitle();

        Assertions.assertEquals(productName, actualSearchResultTitle);
    }

    private SelenideElement findProductById(String productId) {
        return element(Selectors.by("data-product-id", productId));
    }

}
