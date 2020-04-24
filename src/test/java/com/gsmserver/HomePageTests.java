package com.gsmserver;

import com.gsmserver.pages.HomePage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class HomePageTests extends BaseTest {

    @Test
    void addToCartProductFromCaruselTest() {
        open("");

        new HomePage().targetProduct("860988")
                .clickOnAddToCart();

    }


}
