package com.gsmserver;

import com.gsmserver.product.ProductComponentSteps;
import com.gsmserver.product.Products;
import com.gsmserver.utils.Calculator;
import com.gsmserver.utils.PriceCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.gsmserver.utils.Browser.openPage;

public class ProductPageTests extends BaseTest {

    @Test
    void increaseAndDecreaseProductCountTest() {
        var productDto = Products.MedusaBox.getDto();

        openPage(productDto.getBasePath());

        var productSteps = ProductComponentSteps.targetProduct(productDto);

        Assertions.assertEquals(productSteps.getProductPageTitle(), productDto.getTitle());

        productSteps
                .addToCartProduct()
                .increaseProductCountTo(2)
                .decreaseProductCountTo(2);

        Calculator.multiply("126.99", 4);
        new PriceCalculator("126.99").multiply(4);

        Assertions.assertEquals(productSteps.getProductCount(), "1");
    }

}
